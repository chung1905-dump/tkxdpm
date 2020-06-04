package QuanLyPhuongThucVanChuyen;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

import JDBC.DBUtilities;

public class TransportationInfoController {
	TransportationInfo model;
	TransportationWindow gui;
	List<TransportationInfo> data = new ArrayList<TransportationInfo>();
	/**
	 * @param model
	 */
	public TransportationInfoController() {
		super();
		// this.model = model;
	}

//	public String getSiteCode() {
//		return model.getSiteCode();
//	}
//
//	/**
//	 * @param siteCode the siteCode to set
//	 */
//	public void setSiteCode(String siteCode) {
//		model.setSiteCode(siteCode);;
//	}
//
//	/**
//	 * @return the siteName
//	 */
//	public String getSiteName() {
//		return model.getSiteName();
//	}
//
//	/**
//	 * @param siteName the siteName to set
//	 */
//	public void setSiteName(String siteName) {
//		model.setSiteName(siteName);
//	}
//
//	/**
//	 * @return the byShip
//	 */
//	public int getByShip() {
//		return model.getByShip();
//	}
//
//	/**
//	 * @param byShip the byShip to set
//	 */
//	public void setByShip(int byShip) {
//		model.setByShip(byShip);
//	}
//
//	/**
//	 * @return the byAir
//	 */
//	public int getByAir() {
//		return model.getByAir();
//	}
//
//	/**
//	 * @param byAir the byAir to set
//	 */
//	public void setByAir(int byAir) {
//		model.setByAir(byAir);
//	}
//
//	/**
//	 * @return the others
//	 */
//	public String getOthers() {
//		return model.getOthers();
//	}
//
//	/**
//	 * @param others the others to set
//	 */
//	public void setOthers(String others) {
//		model.setOthers(others);
//	}

	public TransportationInfoModel loadRecords(TransportationInfoGUI transportationInfoGUI) throws SQLException {
		
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

	public void updateRecord(String siteCode, String siteName, String byShip, String byAir, String others) {
		String sql_stmt = "UPDATE transportationinfo SET SiteName = '" + siteName + "'";
		// sql_stmt += ",gender = '" + cboGender.getSelectedItem().toString() + "'";
		sql_stmt += ",byShip = '" + byShip + "'";
		sql_stmt += ",byAir = '" + byAir + "'";
		sql_stmt += ",others = '" + others + "'";
		sql_stmt += " WHERE SiteCode = '" + siteCode + "'";
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
