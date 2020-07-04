package QuanLyDSMatHang.controller;

import QuanLyDSMatHang.view.MatHangListGUI;
import main.Application;
import main.controller.IController;
import main.controller.MainController;
import main.view.IView;

public class MatHangListController implements IController {
    public IView run() {
        return new MatHangListGUI(this);
    }

    public void moveToNewController() {
        Application.runController(new MatHangEditController(null), Application.ANIM_SWIPE_LEFT);
    }

    public void editController(String id) {
        Application.runController(new MatHangEditController(null, id), Application.ANIM_SWIPE_LEFT);
    }

    public void back() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_RIGHT);
    }
}
