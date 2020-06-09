package QuanLyMHKD.view;

import QuanLyMHKD.view.edit.MHKDForm;
import main.IView;

import java.awt.*;

public class MHKDEditGUI implements IView {
    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(0, 10));

//        rootContainer.add((new MHKDListToolbar(this.controller).draw()), BorderLayout.PAGE_START);
        rootContainer.add((new MHKDForm()).draw(), BorderLayout.CENTER);
//        rootContainer.add(new JButton("Back"), BorderLayout.PAGE_END);

        return rootContainer;
    }
}
