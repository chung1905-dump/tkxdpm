package QuanLyPhuongThucVanChuyen.setup;
import setup.database.ISetup;
public class PTVCFixture implements ISetup {
    public String getRawSQL() {
        return "INSERT INTO transportationinfo (SiteCode, SiteName, byShip, byAir,others) " +
                "VALUES ('1ww', '1a', 1, 1, '1')," +
                "('12123131', '1231', 123, 213, '21312')";
    }
}
