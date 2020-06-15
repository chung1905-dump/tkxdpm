package core;

import QLDSMHCanDat.controller.DSMHCanDatController;
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
<<<<<<< HEAD
        Application.runController(new TransportationInfoController(), 1);
        
    }
    public void moveToListProduct() {
    	Application.runController(new DSMHCanDatController());
=======
        Application.runController(new TransportationInfoController(), Application.ANIM_SWIPE_LEFT);
    }

    public void moveToHome() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_LEFT);
>>>>>>> 37e6aa55e18d21e81d2757e85a310e76d5b88f07
    }
}
