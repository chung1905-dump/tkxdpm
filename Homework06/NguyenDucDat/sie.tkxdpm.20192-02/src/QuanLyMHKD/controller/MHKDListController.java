package QuanLyMHKD.controller;

import QuanLyMHKD.view.MHKDListGUI;
import main.IController;
import main.IView;

public class MHKDListController implements IController {
    public IView run() {
        return new MHKDListGUI();
    }
}
