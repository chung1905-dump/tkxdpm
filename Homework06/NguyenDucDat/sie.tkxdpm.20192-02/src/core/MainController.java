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
        Application.runController(new MHKDListController(), Application.ANIM_SWIPE_LEFT);
    }

    public void moveToTransportation() {
        Application.runController(new TransportationInfoController(), Application.ANIM_SWIPE_LEFT);
    }

    public void moveToHome() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_LEFT);
    }
}
