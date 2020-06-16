package QuanLyDSMatHang.view;

import QuanLyDSMatHang.controller.MatHangListController;
import QuanLyDSMatHang.view.list.MatHangListToolbar;
import QuanLyDSMatHang.view.list.MatHangTable;
import main.view.IView;

import javax.swing.*;
import java.awt.*;

public class MatHangListGUI implements IView {
    private final MatHangListController controller;

    private MatHangListToolbar toolbar;
    private MatHangTable table;

    public MatHangListGUI(MatHangListController controller) {
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
        toolbar = new MatHangListToolbar(this);
        table = new MatHangTable();
    }

    public MatHangListController getController() {
        return controller;
    }

    public MatHangListToolbar getToolbar() {
        return toolbar;
    }

    public MatHangTable getTable() {
        return table;
    }
}
