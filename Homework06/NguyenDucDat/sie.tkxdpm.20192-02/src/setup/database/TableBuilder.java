package setup.database;

import main.entity.MetaData;
import main.entity.annotation.Column;

public class TableBuilder {
    public static String buildSQLFromMetaData(MetaData md) {
        StringBuilder rawSQL = new StringBuilder(String.format("CREATE TABLE IF NOT EXISTS %s (", md.getEntity().table()));
        for (Column c : md.getColumns()) {
            rawSQL.append(String.format("%s %s %s,", c.name(), c.type(), c.options()));
        }
        rawSQL.append(String.format("PRIMARY KEY (%s));", md.getEntity().primaryKey()));
        return rawSQL.toString();
    }
}
