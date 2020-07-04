package QLDSMHCanDat.setup;

import setup.database.ISetup;

public class QLDSDHSchema implements ISetup {
    public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS qldsmhcandat " +
                " (idDSMHCD int AUTO_INCREMENT, " +
                " idSanPham VARCHAR(255)," +
                " SoLuong int, " +
                " DonVi VARCHAR(255), " +
                " NgayNhan DATE, " +
                " maDonHang VARCHAR(20), " +
                " PRIMARY KEY ( idDSMHCD )," +
                " FOREIGN KEY (idSanPham) REFERENCES mathang (id) ON DELETE CASCADE ON UPDATE RESTRICT," +
                " FOREIGN KEY (maDonHang) REFERENCES donHang (maDonHang) ON DELETE CASCADE ON UPDATE RESTRICT )";
    }
}
