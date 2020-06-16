
package QLDSMHCanDat.controller;

import java.sql.SQLException;

import util.DBUtilities;
import QLDSMHCanDat.model.QLDSMHCanDatModel;
import QLDSMHCanDat.view.QLDSMHCanDatView;
import main.controller.IController;
import main.view.IView;

public class DSMHCanDatController implements IController {
    @Override
    public IView run() {
        return new QLDSMHCanDatView(this);
    }
    
	public QLDSMHCanDatModel loadRecords() throws SQLException {
		String sql_stmt = "SELECT * FROM qldsmhcandat;";
		System.out.println(sql_stmt);
		// ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);
		QLDSMHCanDatModel tableModel = new QLDSMHCanDatModel(sql_stmt);

		return tableModel;
	}
	
	public void deleteRecord(String idProduct) {
		String sql_stmt = "DELETE FROM qldsmhcandat WHERE idProduct = '" + idProduct + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
	
	public void updateRecord(String idProduct, String number, String unit, String date ) {
		String sql_stmt = "UPDATE qldsmhcandat SET idProduct = '" + idProduct + "'";
		// sql_stmt += ",gender = '" + cboGender.getSelectedItem().toString() + "'";
		sql_stmt += ",number = '" + number + "'";
		sql_stmt += ",unit = '" + unit + "'";
		sql_stmt += ",date = '" + date + "'";
		sql_stmt += " WHERE idProduct = '" + idProduct + "'";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
	
	public void addNew(String idProduct, String number, String unit, String date) {
		// INSERT INTO `tkxdpm`.`transportationinfo` (`SiteCode`, `SiteName`, `byShip`)
		// VALUES ('265', '21321', '1312sadsd');
		String sql_stmt = "INSERT INTO qldsmhcandat (number,unit,date)";
		sql_stmt += " VALUES ('"+ number + "','" + unit + "','" + date + "')";
		System.out.println(sql_stmt);
		DBUtilities.ExecuteSQLStatement(sql_stmt);
	}
}

