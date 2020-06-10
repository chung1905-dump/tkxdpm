package QuanLyMHKD.view.list;

import QuanLyMHKD.controller.MHKDListController;
import main.Application;
import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDListToolbar implements IView {
    private final MHKDListController controller;

    public MHKDListToolbar(MHKDListController controller) {
        this.controller = controller;
    }

    public Container draw() {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton button = new JButton("Create");
        button.addActionListener(e -> this.controller.moveToNewController());
        toolbar.add(button);
        toolbar.addSeparator();

        return toolbar;
    }
}
