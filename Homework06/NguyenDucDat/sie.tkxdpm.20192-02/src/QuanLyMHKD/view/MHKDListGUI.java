package QuanLyMHKD.view;

import QuanLyMHKD.controller.MHKDListController;
import QuanLyMHKD.view.list.MHKDListToolbar;
import QuanLyMHKD.view.list.MHKDTable;
import main.view.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDListGUI implements IView {
    private final MHKDListController controller;

    private MHKDListToolbar toolbar;
    private MHKDTable table;

    public MHKDListGUI(MHKDListController controller) {
        this.controller = controller;
        initialize();
    }

    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(0, 10));

        rootContainer.add(toolbar.draw(), BorderLayout.PAGE_START);
        rootContainer.add(table.draw(), BorderLayout.CENTER);

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> this.controller.back());
        rootContainer.add(backBtn, BorderLayout.PAGE_END);

        return rootContainer;
    }

    private void initialize() {
        toolbar = new MHKDListToolbar(this);
        table = new MHKDTable();
    }

    public MHKDListController getController() {
        return controller;
    }

    public MHKDListToolbar getToolbar() {
        return toolbar;
    }

    public MHKDTable getTable() {
        return table;
    }
}
