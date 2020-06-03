package QuanLyMHKD.controller;

import main.IController;
import main.IView;

public class MHKDController implements IController {
    public IView run() {
        return (new MHKDListController()).run();
    }
}
