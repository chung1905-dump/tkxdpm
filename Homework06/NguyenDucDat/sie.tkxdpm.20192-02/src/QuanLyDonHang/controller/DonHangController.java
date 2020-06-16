package QuanLyDonHang.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import JDBC.DBUtilities;
import QuanLyDonHang.entity.MHCanDat;
import QuanLyDonHang.entity.DonHang;
import QuanLyDonHang.view.DonHangView;
import QuanLyDonHang.model.DonHangModel;
import QuanLyDSMatHang.MatHang;
import core.MainController;
import main.Application;
import main.IController;
import main.IView;

public class DonHangController implements IController {
	@Override
	public IView run() {
		// TransportationInfoController controller = new TransportationInfoController();
		return new DonHangView(this);
	}

	public void moveToHome() {
		Application.runController(new MainController(), Application.ANIM_SWIPE_LEFT);
	}

	public DonHangModel loadRecords() throws SQLException {

		String sql_stmt = "SELECT * FROM transportationinfo;";
		System.out.println(sql_stmt);
		// ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
		DonHangModel tableModel = new DonHangModel(sql_stmt);

		return tableModel;
	}

	public void deleteRecord(String siteCode) {
		String sql_stmt = "DELETE FROM transportationinfo WHERE id = '" + siteCode + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}

	public void updateRecord(DonHang data, String id) {
		String maDonHang = data.getMaDonHang();
		String siteName = data.getSiteName();
		String byShip = Integer.toString(data.getByShip());
		String byAir = Integer.toString(data.getByAir());
		String others = data.getOthers();
//		try {
//			TransportationInfoModel tableModel = this.loadRecords();
//			
//			ArrayList<TransportationInfo> list = tableModel.getData();
//			int index = list.indexOf(data);
//			if (index != -1) {
//				list.get(index).setSiteCode(siteCode);
//				list.get(index).setSiteCode(siteName);
//				list.get(index).setSiteCode(byShip);
//				list.get(index).setSiteCode(byAir);
//				list.get(index).setSiteCode(others);
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

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

	public void addNew(DonHang data) {
		String maDonHang = data.getMaDonHang();
		String ngayNhan = data.getNgayNhan().toString();
		// INSERT INTO `tkxdpm`.`transportationinfo` (`SiteCode`, `SiteName`, `byShip`)
		// VALUES ('265', '21321', '1312sadsd');
		String sql_stmt = "INSERT INTO transportationinfo (SiteCode,SiteName,byShip,byAir,others)";
		sql_stmt += " VALUES (" + maDonHang + "," + ngayNhan +")";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
}