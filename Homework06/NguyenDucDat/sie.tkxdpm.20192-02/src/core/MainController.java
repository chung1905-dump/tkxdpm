package core;

import QuanLyMHKD.controller.MHKDListController;
import QuanLyPhuongThucVanChuyen.TransportationInfoController;
import main.IController;
import main.IView;
import main.Application;

public class MainController implements IController {
    public IView run() {
        return new MainView(this);
    }

    public void moveToMHKD() {
        Application.runController(new MHKDListController(), 1);
    }
}
