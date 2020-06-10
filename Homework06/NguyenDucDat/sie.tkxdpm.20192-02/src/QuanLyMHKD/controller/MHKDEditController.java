package QuanLyMHKD.controller;

import QuanLyMHKD.entity.MatHangKinhDoanh;
import QuanLyMHKD.model.MHKD;
import QuanLyMHKD.view.MHKDEditGUI;
import main.IController;
import main.IView;

import java.sql.SQLException;

public class MHKDEditController implements IController {
    private final MHKD model;

    public MHKDEditController(MHKD model) {
        if (model == null) {
            model = new MHKD();
        }
        this.model = model;
    }

    public IView run() {
        return new MHKDEditGUI(this);
    }

    public void save(MatHangKinhDoanh mhkd) {
        try {
            this.model.save(mhkd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
