package core;

import QuanLyMHKD.controller.MHKDListController;
import QuanLyPhuongThucVanChuyen.controller.TransportationInfoController;
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

    public void moveToTransportation() {
        Application.runController(new TransportationInfoController(), 1);
    }
    
    public void moveToHome() {
        Application.runController(new MainController(), 1);
    }
}
