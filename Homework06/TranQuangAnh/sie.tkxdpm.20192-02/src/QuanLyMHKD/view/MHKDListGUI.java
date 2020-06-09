package QuanLyMHKD.view;

import QuanLyMHKD.view.list.MHKDTable;
import QuanLyPhuongThucVanChuyen.TransportationWindow;
import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDListGUI implements IView {
    public Container draw() {
        Container rootContainer = new Container();
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        rootContainer.setLayout(new BorderLayout(0, 10));
        JButton toolbar = new JButton("Toolbar");
        
        toolbar.addActionListener(this::newWindow);
        rootContainer.add(toolbar, BorderLayout.PAGE_START);
        rootContainer.add((new MHKDTable()).draw(), BorderLayout.CENTER);
        rootContainer.add(new JButton("Back"), BorderLayout.PAGE_END);

        return rootContainer;
    }
    
    public void newWindow(java.awt.event.ActionEvent evt) {
    	TransportationWindow sForm = new TransportationWindow(null, false);
        sForm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        sForm.pack();
        sForm.setLocationRelativeTo(null);

        sForm.setVisible(true);
    }
}
