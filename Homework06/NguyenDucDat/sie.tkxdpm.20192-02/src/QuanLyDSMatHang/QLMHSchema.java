package QuanLyDSMatHang;
import setup.database.ISetup;
public class QLMHSchema implements ISetup {
	public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS mathang " +    
                " (maMH VARCHAR(255), " +
                "tenMatHang VARCHAR(255)," + 
                " PRIMARY KEY ( maMH ))";
    }
}
