package QuanLyDSMatHang.model;

import QuanLyDSMatHang.entity.MatHang;
import util.DatabaseExecutor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatHangModel {
    DatabaseExecutor databaseExecutor;

    public MatHangModel() throws SQLException {
        databaseExecutor = DatabaseExecutor.getInstance();
    }

    public MatHang find(String id) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = databaseExecutor.createPreparedStatement("SELECT * FROM mathang WHERE id = ?");
            stmt.setString(1, id);
            result = stmt.executeQuery();
            MatHang[] list = prepareEntity(result);
            return list[0];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (Exception e) {
                    System.out.println("Cannot close stmt");
                }
            }
        }
        return null;
    }

    public void delete(String id) {
        try {
            PreparedStatement stmt = databaseExecutor.createPreparedStatement("DELETE FROM mathang WHERE id = ?");
            stmt.setString(1, id);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MatHang[] loadAll() {
        ResultSet result = null;

        try {
            result = databaseExecutor.executeQuery("SELECT * FROM mathang");

            MatHang[] ret = prepareEntity(result);
            result.close();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (Exception e) {
                    System.out.println("Cannot close count stmt");
                }
            }
        }
        return null;
    }

    public int count() {
        ResultSet result = null;
        try {
            result = databaseExecutor.executeQuery("SELECT count(*) AS total FROM mathang");
            result.next();
            return result.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (Exception e) {
                    System.out.println("Cannot close count stmt");
                }
            }
        }
        return 0;
    }

    public void save(MatHang entity) throws SQLException {
        if (isNew(entity)) {
            create(entity);
        } else {
            update(entity);
        }
    }

    private MatHang[] prepareEntity(ResultSet resultSet) throws SQLException {
        List<MatHang> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(resultSet2Entity(resultSet));
        }
        MatHang[] array = new MatHang[list.size()];
        return list.toArray(array);
    }

    private MatHang resultSet2Entity(ResultSet resultSet) throws SQLException {
        return new MatHang(resultSet.getString("id"), resultSet.getString("ten"));
    }

    private void create(MatHang entity) throws SQLException {
        String sql = String.format(
                "INSERT INTO mathang (id, ten) " +
                        "VALUES ('%s', '%s');",
                entity.getId(),
                entity.getTen()
        );
        databaseExecutor.executeUpdate(sql);
    }

    private void update(MatHang entity) throws SQLException {
        String sql = String.format(
                "UPDATE mathang " +
                        "SET id = '%s', ten = '%s' " +
                        "WHERE id = '%s'",
                entity.getId(),
                entity.getTen(),
                entity.getId()
        );
        databaseExecutor.executeUpdate(sql);
    }

    private boolean isNew(MatHang entity) {
        return entity.isNew();
    }
}
