package QuanLyMHKD.setup;

import setup.database.ISetup;

public class MHKDFixture implements ISetup {
    public String getRawSQL() {
        return "INSERT INTO mat_hang_kinh_doanh (name, merchandise, quantity, unit) " +
                "VALUES ('test', 'merchan', 2, 'hello')," +
                "('123', 'zxcv', 1, 'hihihi');";
    }
}
