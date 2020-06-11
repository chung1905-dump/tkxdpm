package QuanLyPhuongThucVanChuyen.setup;
import setup.database.ISetup;
public class PTVCSchema implements ISetup {
    public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS transportationinfo " +
                "(SiteCode varchar(50) NOT NULL, " +
                " SiteName varchar(50) NOT NULL," +
                " byShip int NOT NULL DEFAULT '0', " +
                " byAir int NOT NULL DEFAULT '0', " +
                " others varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'No other infos'," +
                " PRIMARY KEY ( SiteCode ))";
    }
}
