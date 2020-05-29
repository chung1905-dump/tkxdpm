package QuanLyMHKD;

import setup.database.ISetup;

public class MHKDSetup implements ISetup {
    public String getRawSQL() {
        return "CREATE TABLE mat_hang_kinh_doanh " +
                "(id INTEGER not NULL, " +
                " ten VARCHAR(255), " +
                " merchandise VARCHAR(255), " +
                " quantity INTEGER, " +
                " unit VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
    }
}
