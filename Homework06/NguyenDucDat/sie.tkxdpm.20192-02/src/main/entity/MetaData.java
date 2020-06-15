package main.entity;

import main.entity.annotation.Column;
import main.entity.annotation.Entity;

import java.util.ArrayList;
import java.util.List;

public class MetaData {
    private Entity entity;
    private List<Column> columns;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void addColumn(Column column) {
        if (columns == null) {
            columns = new ArrayList<>();
        }
        columns.add(column);
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
