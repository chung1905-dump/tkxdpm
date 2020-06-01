package QuanLyMHKD.view;

import QuanLyMHKD.view.list.MHKDTable;
import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDListGUI implements IView {
    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(0, 10));

        rootContainer.add(new JButton("Toolbar"), BorderLayout.PAGE_START);
        rootContainer.add((new MHKDTable()).draw(), BorderLayout.CENTER);
        rootContainer.add(new JButton("Back"), BorderLayout.PAGE_END);

        return rootContainer;
    }
}
