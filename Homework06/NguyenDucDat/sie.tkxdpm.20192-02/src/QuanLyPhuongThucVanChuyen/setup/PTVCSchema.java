package QuanLyPhuongThucVanChuyen.setup;
import setup.database.ISetup;
public class PTVCSchema implements ISetup {

    public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS transportationinfo " +
                "(SiteCode varchar(50) NOT NULL, " +
                " SiteName varchar(50) NOT NULL," +
                " byShip int NOT NULL DEFAULT '0', " +
                " byAir int NOT NULL DEFAULT '0', " +
                " others varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'No other infos'," +
                " PRIMARY KEY ( SiteCode ))";
    }
//    CREATE TABLE IF NOT EXISTS `mat_hang_kinh_doanh` (
//    		  `id` int NOT NULL AUTO_INCREMENT,
//    		  `ten` varchar(255) DEFAULT NULL,
//    		  `merchandise` varchar(255) DEFAULT NULL,
//    		  `quantity` int DEFAULT NULL,
//    		  `unit` varchar(255) DEFAULT NULL,
//    		  PRIMARY KEY (`id`)
//    		)
}
