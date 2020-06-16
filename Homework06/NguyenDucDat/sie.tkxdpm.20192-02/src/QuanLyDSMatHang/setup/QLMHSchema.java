package QuanLyDSMatHang.setup;

import setup.database.ISetup;

public class QLMHSchema implements ISetup {
    public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS mathang " +
                " (id VARCHAR(255), " +
                " ten VARCHAR(255)," +
                " PRIMARY KEY ( id ))";
    }
}
