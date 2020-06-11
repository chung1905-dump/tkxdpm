package QuanLyPhuongThucVanChuyen.controller;

import java.sql.SQLException;

import JDBC.DBUtilities;
import QuanLyPhuongThucVanChuyen.view.TransportationInfoGUI;
import QuanLyPhuongThucVanChuyen.model.TransportationInfoModel;
import QuanLyPhuongThucVanChuyen.view.TransportationWindow;
import core.MainController;
import main.Application;
import main.IController;
import main.IView;

public class TransportationInfoController implements IController {
    @Override
    public IView run() {
    	//TransportationInfoController controller = new TransportationInfoController();
        return new TransportationWindow(this);
    }
    
    public void moveToHome() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_LEFT);
    }
    
	public TransportationInfoModel loadRecords() throws SQLException {
		
		String sql_stmt = "SELECT * FROM transportationinfo;";
		System.out.println(sql_stmt);
		// ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
		TransportationInfoModel tableModel = new TransportationInfoModel(sql_stmt);

		return tableModel;
	}
	
	public void deleteRecord(String siteCode) {
		String sql_stmt = "DELETE FROM transportationinfo WHERE SiteCode = '" + siteCode + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
	
	public void updateRecord(String siteCode, String siteName, String byShip, String byAir, String others,String id) {
		String sql_stmt = "UPDATE transportationinfo SET SiteName = '" + siteName + "'";
		// sql_stmt += ",gender = '" + cboGender.getSelectedItem().toString() + "'";
		sql_stmt += ",SiteCode = '" + siteCode + "'";
		sql_stmt += ",byShip = '" + byShip + "'";
		sql_stmt += ",byAir = '" + byAir + "'";
		sql_stmt += ",others = '" + others + "'";
		sql_stmt += " WHERE id = '" + id + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
	
	public void addNew(String siteCode, String siteName, String byShip, String byAir, String others) {
		// INSERT INTO `tkxdpm`.`transportationinfo` (`SiteCode`, `SiteName`, `byShip`)
		// VALUES ('265', '21321', '1312sadsd');
		String sql_stmt = "INSERT INTO transportationinfo (SiteCode,SiteName,byShip,byAir,others)";
		sql_stmt += " VALUES ('" + siteCode + "','" + siteName + "','" + byShip + "','" + byAir + "','" + others + "')";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
}
