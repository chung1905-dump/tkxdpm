package main.view.list.table;

import main.entity.MetaData;
import main.entity.MetaDataFactory;
import util.StringHelper;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableModel<A> extends AbstractTableModel {
    private final MetaData metaData;

    private final List<A> collection;

    public TableModel(A[] collection, Class<A> type) {
        this.collection = new ArrayList<>(Arrays.asList(collection));
        metaData = MetaDataFactory.getInstance().getMetaData(type);
    }

    public String getColumnName(int column) {
        return StringHelper.capitalizeFirstLetter(metaData.getColumns().get(column).name());
    }

    public int getRowCount() {
        return collection.size();
    }

    public int getColumnCount() {
        return metaData.getColumns().size();
    }

    public Object getValueAt(int i, int i1) {
        A entity = collection.get(i);
        String column = metaData.getColumns().get(i1).name();
        String methodName = "get" + StringHelper.capitalizeFirstLetter(column);
        try {
            return entity.getClass().getMethod(methodName).invoke(entity);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getClass());
        }
        return null;
    }
}
