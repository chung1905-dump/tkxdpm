package QuanLyMHKD.view.list;

import QuanLyMHKD.entity.MatHangKinhDoanh;
import QuanLyMHKD.model.MHKD;
import main.view.IView;
import main.view.list.table.TableModel;

import javax.swing.*;
import java.awt.*;

public class MHKDTable implements IView {
    private JTable table;

    public Container draw() {
        try {
            Container rootContainer = new Container();

            MHKD mhkd = new MHKD();
            MatHangKinhDoanh[] data = mhkd.loadAll();

            table = new JTable();
            table.setModel(new TableModel<>(data, MatHangKinhDoanh.class));
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            rootContainer.setLayout(new BorderLayout(0, 10));
            rootContainer.add(scrollPane, BorderLayout.CENTER);

            return rootContainer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getSelectedId() {
        int row = table.getSelectedRow();
        return Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
    }
}
