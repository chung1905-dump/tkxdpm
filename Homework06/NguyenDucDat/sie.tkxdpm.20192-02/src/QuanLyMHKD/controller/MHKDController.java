package QuanLyMHKD.controller;

import QuanLyMHKD.view.MHKDGUI;
import main.IController;
import main.IView;

import java.awt.event.ActionEvent;

public class MHKDController implements IController {
    public IView run() {
        return new MHKDGUI(this);
    }

    public void onSubmit(ActionEvent e) {
        main.Application.runController(new NextController());
    }
}
