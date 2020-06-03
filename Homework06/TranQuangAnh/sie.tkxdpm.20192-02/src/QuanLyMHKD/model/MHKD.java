package QuanLyMHKD.model;

import util.DatabaseExecutor;

import java.sql.ResultSet;

public class MHKD {
    DatabaseExecutor databaseExecutor;

    public MHKD() {
        databaseExecutor = new DatabaseExecutor();
    }

    public String[][] loadAll() {
        ResultSet result = null;

        try {
            String[][] ret = new String[count()][];
            result = databaseExecutor.executeQuery("SELECT * FROM mat_hang_kinh_doanh");
            while (result.next()) {
                String[] row = new String[5];
                row[0] = String.valueOf(result.getInt("id"));
                row[1] = result.getString("ten");
                row[2] = result.getString("merchandise");
                row[3] = String.valueOf(result.getInt("quantity"));
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
}
