package QuanLyDonHang.controller;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        return new DonHangGUI(this);
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
        String sql_stmt = "UPDATE donHang SET ngayNhan = '" + formatDate(data.getNgayNhan());
        sql_stmt += "' WHERE maDonHang = '" + id + "'";
        System.out.println(sql_stmt);
        DBUtilities.ExecuteSQLStatement(sql_stmt);
    }

    public void addNew(DonHang data) {
        String maDonHang = data.getMaDonHang();
        String ngayNhan = formatDate(data.getNgayNhan());
        String sql_stmt = "INSERT INTO donHang (maDonHang,ngayNhan)";
        sql_stmt += " VALUES ('" + maDonHang + "','" + ngayNhan + "')";
        System.out.println(sql_stmt);
        DBUtilities.ExecuteSQLStatement(sql_stmt);
    }

    private String formatDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "-" + month + "-" + day;
    }
}
