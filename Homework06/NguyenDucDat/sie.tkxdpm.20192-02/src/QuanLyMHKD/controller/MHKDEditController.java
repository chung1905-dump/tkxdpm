package QuanLyMHKD.controller;

import QuanLyMHKD.view.MHKDEditGUI;
import main.IController;
import main.IView;

public class MHKDEditController implements IController {
    public IView run() {
        return new MHKDEditGUI();
    }
}
