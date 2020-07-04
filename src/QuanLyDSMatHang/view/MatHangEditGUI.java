package QuanLyDSMatHang.view;

import QuanLyDSMatHang.view.edit.MatHangForm;
import QuanLyDSMatHang.controller.MatHangEditController;
import QuanLyDSMatHang.entity.MatHang;
import main.view.IView;

import java.awt.*;

public class MatHangEditGUI implements IView {
    private final MatHangEditController controller;

    private final MatHang entity;

    public MatHangEditGUI(MatHangEditController controller, MatHang entity) {
        this.controller = controller;
        this.entity = entity;
    }

    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(0, 10));

        rootContainer.add((new MatHangForm(this.controller, this.entity)).draw(), BorderLayout.CENTER);

        return rootContainer;
    }
}
