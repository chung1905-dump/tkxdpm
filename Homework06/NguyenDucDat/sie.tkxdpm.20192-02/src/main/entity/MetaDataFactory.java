package main.entity;

import main.entity.annotation.Column;
import main.entity.annotation.Entity;

import java.lang.reflect.Field;

public class MetaDataFactory<A> {
    public MetaData createMetaData(Class<A> className) {
        MetaData md = new MetaData();

        md.setEntity(className.getAnnotation(Entity.class));
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            Column col = field.getAnnotation(Column.class);
            if (col == null) {
                continue;
            }
            md.addColumn(col);
        }

        return md;
    }
}
