package XacNhanDonHang.controller;

import XacNhanDonHang.view.XacNhanDonHangGUI;
import main.controller.MainController;
import main.Application;
import main.controller.IController;
import main.view.IView;

public class XacNhanDonHangController implements IController {
    public IView run() {
        return new XacNhanDonHangGUI();
    }



    public void back() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_RIGHT);
    }
}