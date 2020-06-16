package QuanLyDSMatHang.controller;

import QuanLyDSMatHang.entity.MatHang;
import QuanLyDSMatHang.model.MatHangModel;
import QuanLyDSMatHang.view.MatHangEditGUI;
import main.Application;
import main.controller.IController;
import main.view.IView;

import java.sql.SQLException;

public class MatHangEditController implements IController {
    private final MatHangModel model;

    private MatHang entity;

    public MatHangEditController(MatHangModel model, String entityId) {
        this(model);
        entity = this.model.find(entityId);
    }

    public MatHangEditController(MatHangModel model) {
        if (model == null) {
            try {
                model = new MatHangModel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.model = model;
    }

    public IView run() {
        return new MatHangEditGUI(this, entity);
    }

    public void save(MatHang mhkd) {
        try {
            this.model.save(mhkd);
            this.back();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void back() {
        Application.runController(new MatHangListController(), Application.ANIM_SWIPE_RIGHT);
    }
}
