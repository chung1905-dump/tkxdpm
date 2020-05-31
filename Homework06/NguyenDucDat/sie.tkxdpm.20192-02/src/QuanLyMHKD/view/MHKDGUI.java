package QuanLyMHKD.view;

import QuanLyMHKD.controller.MHKDController;
import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDGUI implements IView {
    MHKDController controller;

    public MHKDGUI(MHKDController controller) {
        this.controller = controller;
    }

    public Container draw() {
        Container container = new Container();

        JButton b = new JButton("submit");
        b.setBounds(130, 100, 120, 60);
        b.addActionListener(e -> controller.onSubmit(e));

        container.add(b);
        return container;
    }
}
