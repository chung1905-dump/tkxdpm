package main.entity;

import main.entity.annotation.Column;
import main.entity.annotation.Entity;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MetaDataFactory {
    private static MetaDataFactory instance;

    private Map<String, MetaData> metaDataMap;

    private MetaDataFactory() {
    }

    public static MetaDataFactory getInstance() {
        if (instance == null) {
            instance = new MetaDataFactory();
        }
        return instance;
    }

    public MetaData getMetaData(Class<?> className) {
        if (metaDataMap == null) {
            metaDataMap = new HashMap<>();
        }
        if (!metaDataMap.containsKey(className.getName())) {
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

            metaDataMap.put(className.getName(), md);
            System.out.println("Cached metadata for class " + className.getName());
        }

        return metaDataMap.get(className.getName());
    }
}
