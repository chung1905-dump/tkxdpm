package QuanLyDonHang.setup;
import setup.database.ISetup;
public class QLDHSchema implements ISetup {
    public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS donHang " +
                "(maDonHang varchar(20) NOT NULL, " +
                " ngayNhan DATE NOT NULL," +
                " maDSMHCD int,"+
                "PRIMARY KEY (maDonHang)"+
                "FOREIGN KEY (maDSMHCD) REFERENCES qldsmhcandat (idDSMHCD) ON UPDATE RESTRICT ON DELETE CASCADE)";
    }
}
