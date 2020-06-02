package QuanLyMHKD.view.list;

import QuanLyMHKD.model.MHKD;
import main.IView;

import javax.swing.*;
import java.awt.*;

public class MHKDTable implements IView {
    public Container draw() {
        Container rootContainer = new Container();

        MHKD mhkd = new MHKD();
        String[] column = {"ID", "Name", "Sitecode", "Qty", "Unit"};
        String[][] data = mhkd.loadAll();

        JTable table = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        rootContainer.setLayout(new BorderLayout(0, 10));
        rootContainer.add(scrollPane, BorderLayout.CENTER);

        return rootContainer;
    }
}
