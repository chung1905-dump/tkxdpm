package QuanLyMHKD.view;

import QuanLyMHKD.controller.MHKDEditController;
import QuanLyMHKD.entity.MatHangKinhDoanh;
import QuanLyMHKD.view.edit.MHKDForm;
import main.IView;

import java.awt.*;

public class MHKDEditGUI implements IView {
    private final MHKDEditController controller;

    private MatHangKinhDoanh entity;

    public MHKDEditGUI(MHKDEditController controller, MatHangKinhDoanh entity) {
        this.controller = controller;
        this.entity = entity;
    }

    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(0, 10));

//        rootContainer.add((new MHKDListToolbar(this.controller).draw()), BorderLayout.PAGE_START);
        rootContainer.add((new MHKDForm(this.controller, this.entity)).draw(), BorderLayout.CENTER);
//        rootContainer.add(new JButton("Save"), BorderLayout.PAGE_END);

        return rootContainer;
    }
}
