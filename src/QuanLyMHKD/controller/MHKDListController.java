package QuanLyMHKD.controller;

import QuanLyMHKD.view.MHKDListGUI;
import main.controller.MainController;
import main.Application;
import main.controller.IController;
import main.view.IView;

public class MHKDListController implements IController {
    public IView run() {
        return new MHKDListGUI(this);
    }

    public void moveToNewController() {
        Application.runController(new MHKDEditController(null), Application.ANIM_SWIPE_LEFT);
    }

    public void editController(int id) {
        Application.runController(new MHKDEditController(null, id), Application.ANIM_SWIPE_LEFT);
    }

    public void back() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_RIGHT);
    }
}
