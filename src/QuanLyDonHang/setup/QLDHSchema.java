package QuanLyDonHang.setup;
import setup.database.ISetup;
public class QLDHSchema implements ISetup {
    public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS donHang " +
                "(maDonHang varchar(20) NOT NULL, " +
                " ngayNhan DATE NOT NULL," +
                " status VARCHAR(255),"+
                " PRIMARY KEY (maDonHang));";
    }
}
