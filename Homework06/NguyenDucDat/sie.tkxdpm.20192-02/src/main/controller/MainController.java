package main.controller;

import QLDSMHCanDat.controller.DSMHCanDatController;
import QuanLyDSMatHang.controller.MatHangListController;
import QuanLyDonHang.controller.DonHangController;
import QuanLyMHKD.controller.MHKDListController;
import QuanLyPhuongThucVanChuyen.controller.TransportationInfoController;
import main.Application;
import main.view.MainView;
import main.view.IView;

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

    public void moveToListProduct() {
        Application.runController(new DSMHCanDatController(), Application.ANIM_SWIPE_LEFT);
    }

    public void moveToMatHang() {
        Application.runController(new MatHangListController(), Application.ANIM_SWIPE_LEFT);
    }

    public void moveToDonHang() {
        Application.runController(new DonHangController(), Application.ANIM_SWIPE_LEFT);
    }

    public void moveToHome() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_LEFT);
    }
}
