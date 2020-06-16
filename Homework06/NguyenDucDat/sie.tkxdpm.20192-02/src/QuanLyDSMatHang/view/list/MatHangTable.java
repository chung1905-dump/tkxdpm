package QuanLyDSMatHang.view.list;

import QuanLyDSMatHang.entity.MatHang;
import QuanLyDSMatHang.model.MatHangModel;
import main.view.IView;
import main.view.list.table.TableModel;

import javax.swing.*;
import java.awt.*;

public class MatHangTable implements IView {
    private JTable table;

    public Container draw() {
        try {
            Container rootContainer = new Container();

            MatHangModel mhkd = new MatHangModel();
            MatHang[] data = mhkd.loadAll();

            table = new JTable();
            table.setModel(new TableModel<>(data, MatHang.class));
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

    public String getSelectedId() {
        int row = table.getSelectedRow();
        return table.getModel().getValueAt(row, 0).toString();
    }
}
