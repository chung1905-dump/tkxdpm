package QuanLyMHKD.controller;

import QuanLyMHKD.view.NextGUI;
import main.IController;
import main.IView;

public class NextController implements IController {
    public IView run() {
        return new NextGUI();
    }
}
