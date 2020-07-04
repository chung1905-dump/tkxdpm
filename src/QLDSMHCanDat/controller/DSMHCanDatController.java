
package QLDSMHCanDat.controller;

import java.sql.SQLException;

import util.DBUtilities;
import QLDSMHCanDat.model.QLDSMHCanDatModel;
import QLDSMHCanDat.view.QLDSMHCanDatView;
import main.controller.IController;
import main.view.IView;
import main.controller.MainController;
import main.Application;

public class DSMHCanDatController implements IController {
    @Override
    public IView run() {
        return new QLDSMHCanDatView(this);
    }
    public void moveToHome() {
		Application.runController(new MainController(), Application.ANIM_SWIPE_LEFT);
	}
	public QLDSMHCanDatModel loadRecords() throws SQLException {
		String sql_stmt = "SELECT * FROM qldsmhcandat;";
		System.out.println(sql_stmt);
		// ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
		QLDSMHCanDatModel tableModel = new QLDSMHCanDatModel(sql_stmt);

		return tableModel;
	}
	
	public void deleteRecord(String idProduct) {
		String sql_stmt = "DELETE FROM qldsmhcandat WHERE idDSMHCD = '" + idProduct + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
	
	public void updateRecord(String idDSMHCD,String idSanPham, String SoLuong, String DonVi, String NgayNhan ) {
		String sql_stmt = "UPDATE qldsmhcandat SET idDSMHCD = '" + idDSMHCD + "'";
		// sql_stmt += ",gender = '" + cboGender.getSelectedItem().toString() + "'";
//		sql_stmt += ",TenSanPham = '" + TenSanPham + "'";
		sql_stmt += ",idSanPham = '" + idSanPham + "'";
		sql_stmt += ",SoLuong = '" + SoLuong + "'";
		sql_stmt += ",DonVi = '" + DonVi + "'";
		sql_stmt += ",NgayNhan = '" + NgayNhan + "'";
		sql_stmt += " WHERE idDSMHCD = '" + idDSMHCD + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
	
	public void addNew( String idSanPham, String SoLuong, String DonVi, String NgayNhan) {
		// INSERT INTO `tkxdpm`.`transportationinfo` (`SiteCode`, `SiteName`, `byShip`)
		// VALUES ('265', '21321', '1312sadsd');
		String sql_stmt = "INSERT INTO qldsmhcandat (idSanPham,SoLuong,DonVi,NgayNhan)";
		sql_stmt += " VALUES ('"+ idSanPham + "'," + SoLuong + ",'" + DonVi + "','" + NgayNhan + "')";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
}

