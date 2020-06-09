package QuanLyMHKD.controller;

import QuanLyMHKD.view.MHKDListGUI;
import main.Application;
import main.IController;
import main.IView;

public class MHKDListController implements IController {
    public IView run() {
        return new MHKDListGUI(this);
    }

    public void moveToNewController() {
        Application.runController(new MHKDEditController(), 1);
    }
}
