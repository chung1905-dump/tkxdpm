package QuanLyMHKD.view.list.table;

import QuanLyMHKD.entity.MatHangKinhDoanh;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<MatHangKinhDoanh> collection;

    public TableModel(MatHangKinhDoanh[] collection) {
        this.collection = new ArrayList<>(Arrays.asList(collection));
    }

    public String getColumnName(int column) {
        return super.getColumnName(column);
    }

    public int getRowCount() {
        return collection.size();
    }

    public int getColumnCount() {
        return 5;
    }

    public Object getValueAt(int i, int i1) {
        return collection.get(i).getData(i1);
    }
}
