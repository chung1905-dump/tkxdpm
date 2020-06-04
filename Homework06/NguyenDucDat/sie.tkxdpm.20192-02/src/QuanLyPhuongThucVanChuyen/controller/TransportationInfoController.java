package QuanLyPhuongThucVanChuyen.controller;

import QuanLyPhuongThucVanChuyen.view.TransportationWindow;
import main.IController;
import main.IView;

public class TransportationInfoController implements IController {
    @Override
    public IView run() {
        return new TransportationWindow();
    }
}
