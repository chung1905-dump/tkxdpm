package QuanLyMHKD.model;

import QuanLyMHKD.entity.MatHangKinhDoanh;
import util.DatabaseExecutor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MHKD {
    DatabaseExecutor databaseExecutor;

    public MHKD() throws SQLException {
        databaseExecutor = DatabaseExecutor.getInstance();
    }

    public MatHangKinhDoanh find(int id) {
        ResultSet result = null;
        try {
            PreparedStatement stmt = databaseExecutor.createPreparedStatement("SELECT * FROM mat_hang_kinh_doanh WHERE id = ?");
            stmt.setInt(1, id);
            result = stmt.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("name"));
                MatHangKinhDoanh[] list = prepareEntity(result);
            }
            return null;
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

    /**
     * @return String[][]
     * @TODO: Use entity instead of String[] to represent data
     */
    public String[][] loadAll() {
        ResultSet result = null;

        try {
            String[][] ret = new String[count()][];
            result = databaseExecutor.executeQuery("SELECT * FROM mat_hang_kinh_doanh");
            while (result.next()) {
                String[] row = new String[5];
                row[0] = String.valueOf(result.getInt("id"));
                row[1] = result.getString("name");
                row[2] = result.getString("merchandise");
                row[3] = String.valueOf(result.getFloat("quantity"));
                row[4] = result.getString("unit");
                ret[result.getRow() - 1] = (row);
            }
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
            result = databaseExecutor.executeQuery("SELECT count(*) AS total FROM mat_hang_kinh_doanh");
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

    public void save(MatHangKinhDoanh entity) throws SQLException {
        if (isNew(entity)) {
            create(entity);
        }
    }

    private MatHangKinhDoanh[] prepareEntity(ResultSet resultSet) throws SQLException {
        List<MatHangKinhDoanh> list = new ArrayList<>();
        while (resultSet.next()) {
            MatHangKinhDoanh entity = new MatHangKinhDoanh(resultSet.getInt("id"));
            entity.setName(resultSet.getString("name"))
                    .setMerchandise(resultSet.getString("merchandise"))
                    .setQty(resultSet.getFloat("quantity"))
                    .setUnit(resultSet.getString("unit"));
            list.add(entity);
        }
        MatHangKinhDoanh[] array = new MatHangKinhDoanh[list.size()];
        return list.toArray(array);
    }

    private void create(MatHangKinhDoanh entity) throws SQLException {
        String sql = String.format(
                "INSERT INTO mat_hang_kinh_doanh (name, merchandise, quantity, unit) " +
                        "VALUES ('%s', '%s', %.2f, '%s');",
                entity.getName(),
                entity.getMerchandise(),
                entity.getQty(),
                entity.getUnit()
        );
        databaseExecutor.executeUpdate(sql);
    }

    private boolean isNew(MatHangKinhDoanh entity) {
        return entity.getId() == 0;
    }
}
