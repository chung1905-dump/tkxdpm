package QuanLyMHKD.controller;

import QuanLyMHKD.entity.MatHangKinhDoanh;
import QuanLyMHKD.model.MHKD;
import QuanLyMHKD.view.MHKDEditGUI;
import main.Application;
import main.controller.IController;
import main.view.IView;

import java.sql.SQLException;

public class MHKDEditController implements IController {
    private final MHKD model;

    private MatHangKinhDoanh entity;

    public MHKDEditController(MHKD model, int entityId) {
        this(model);
        entity = this.model.find(entityId);
    }

    public MHKDEditController(MHKD model) {
        if (model == null) {
            try {
                model = new MHKD();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.model = model;
    }

    public IView run() {
        return new MHKDEditGUI(this, entity);
    }

    public void save(MatHangKinhDoanh mhkd) {
        try {
            this.model.save(mhkd);
            this.back();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void back() {
        Application.runController(new MHKDListController(), Application.ANIM_SWIPE_RIGHT);
    }
}
