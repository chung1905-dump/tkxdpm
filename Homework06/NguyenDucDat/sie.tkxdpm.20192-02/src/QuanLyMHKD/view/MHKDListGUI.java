package QuanLyMHKD.view;

import QuanLyMHKD.controller.MHKDListController;
import QuanLyMHKD.view.list.MHKDListToolbar;
import QuanLyMHKD.view.list.MHKDTable;
import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDListGUI implements IView {
    private final MHKDListController controller;

    public MHKDListGUI(MHKDListController controller) {
        this.controller = controller;
    }

    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(0, 10));

        rootContainer.add((new MHKDListToolbar(this.controller).draw()), BorderLayout.PAGE_START);
        rootContainer.add((new MHKDTable()).draw(), BorderLayout.CENTER);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> this.controller.back());
        rootContainer.add(backBtn, BorderLayout.PAGE_END);

        return rootContainer;
    }
}
