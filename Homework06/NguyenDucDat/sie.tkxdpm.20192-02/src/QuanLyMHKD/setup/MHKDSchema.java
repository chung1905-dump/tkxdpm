package QuanLyMHKD.setup;

import setup.database.ISetup;

public class MHKDSchema implements ISetup {
    public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS mat_hang_kinh_doanh " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                " name VARCHAR(255), " +
                " merchandise VARCHAR(255), " +
                " quantity INTEGER, " +
                " unit VARCHAR(255), " +
                " PRIMARY KEY (id));";
    }
}
