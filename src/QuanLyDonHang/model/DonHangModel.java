package QuanLyDonHang.model;

import util.DBUtilities;
import QuanLyDonHang.entity.DonHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DonHangModel extends AbstractTableModel {
    List<DonHang> data = new ArrayList<DonHang>();
    private Connection connection;
    private final Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;

    public DonHangModel(String query) throws SQLException {
        connection = DBUtilities.getConnection();
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);
        metaData = resultSet.getMetaData();
        data = this.getData();
        resultSet.last();
        numberOfRows = resultSet.getRow();
        fireTableStructureChanged();
    }

    public ArrayList<DonHang> getData() {
        //TransportationInfo[] list = null;
        ArrayList<DonHang> list = new ArrayList<DonHang>();
        try {
            while (resultSet.next()) {
                String maDonHang = resultSet.getString("maDonHang");
                Date ngayNhan = resultSet.getDate("ngayNhan");
                String status = resultSet.getString("status");
//				  int byAir = resultSet.getInt("byAir");
//				  String others = resultSet.getString("others");
                DonHang e = new DonHang(maDonHang, ngayNhan);
                list.add(e);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Class getColumnClass(int column) throws IllegalStateException {
        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Object.class;
    }

    @Override
    public int getColumnCount() throws IllegalStateException {
        try {
            return metaData.getColumnCount();
        } catch (SQLException sex) {
            System.out.println(sex.getMessage());
        }

        return 0;
    }

    @Override
    public String getColumnName(int column) throws IllegalStateException {
        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException sex) {
            System.out.println(sex.getMessage());
        }

        return "";
    }

    @Override
    public int getRowCount() throws IllegalStateException {
        return numberOfRows;
    }

    @Override
    public Object getValueAt(int row, int column) throws IllegalStateException {
        try {
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        } catch (SQLException sex) {
            System.out.println(sex.getMessage());
        }
        return "";
    }

    public void disconnectFromDatabase() {
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sex) {
            System.out.println(sex.getMessage());
        }
    }
}

