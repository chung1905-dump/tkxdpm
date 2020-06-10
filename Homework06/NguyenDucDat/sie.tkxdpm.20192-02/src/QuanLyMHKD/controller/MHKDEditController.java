package QuanLyMHKD.controller;

import QuanLyMHKD.entity.MatHangKinhDoanh;
import QuanLyMHKD.view.MHKDEditGUI;
import main.IController;
import main.IView;

public class MHKDEditController implements IController {
    public IView run() {
        return new MHKDEditGUI(this);
    }

    public void save(MatHangKinhDoanh mhkd) {

    }
}
