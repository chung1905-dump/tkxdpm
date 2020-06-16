package QuanLyDonHang.controller;

import java.sql.SQLException;

import QuanLyDonHang.view.DonHangGUI;
import util.DBUtilities;
import QuanLyDonHang.entity.DonHang;
import QuanLyDonHang.model.DonHangModel;
import main.controller.MainController;
import main.Application;
import main.controller.IController;
import main.view.IView;

public class DonHangController implements IController {
    @Override
    public IView run() {
        // TransportationInfoController controller = new TransportationInfoController();
        return new DonHangGUI();
    }

    public void moveToHome() {
        Application.runController(new MainController(), Application.ANIM_SWIPE_LEFT);
    }

    public DonHangModel loadRecords() throws SQLException {
        String sql_stmt = "SELECT * FROM donHang;";
        System.out.println(sql_stmt);
        return new DonHangModel(sql_stmt);
    }

    public void deleteRecord(String maDonHang) {
        String sql_stmt = "DELETE FROM donHang WHERE maDonHang = '" + maDonHang + "'";
        System.out.println(sql_stmt);
        DBUtilities.ExecuteSQLStatement(sql_stmt);
    }

    public void updateRecord(DonHang data, String id) {
        String ngayNhan = data.getNgayNhan().toString();
        String sql_stmt = "UPDATE donHang SET ngayNhan = " + ngayNhan;
        sql_stmt += " WHERE maDonHang = '" + id + "'";
        System.out.println(sql_stmt);
        DBUtilities.ExecuteSQLStatement(sql_stmt);
    }

    public void addNew(DonHang data) {
        String maDonHang = data.getMaDonHang();
        String ngayNhan = data.getNgayNhan().toString();
        String sql_stmt = "INSERT INTO donHang (maDonHang,ngayNhan)";
        sql_stmt += " VALUES ('" + maDonHang + "'," + ngayNhan + ")";
        System.out.println(sql_stmt);
        DBUtilities.ExecuteSQLStatement(sql_stmt);
    }
}
