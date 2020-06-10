package setup.database;

import java.sql.*;

import QuanLyMHKD.setup.MHKDFixture;
import QuanLyMHKD.setup.MHKDSchema;
import QuanLyPhuongThucVanChuyen.setup.PTVCFixture;
import QuanLyPhuongThucVanChuyen.setup.PTVCSchema;
import util.DatabaseConfig;

public class Schema {
    public void run() {
        Connection conn = null;
        DatabaseConfig config = new DatabaseConfig();
        try {
            conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            System.out.println("Connected to database");

            for (ISetup setup : loadSetup()) {
                runOne(conn, setup.getRawSQL());
                System.out.println("Ran " + setup.getClass().getName());
            }
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void runOne(Connection conn, String rawSQL) {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(rawSQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ISetup[] loadSetup() {
        return new ISetup[]{
                new MHKDSchema(),
                new MHKDFixture(),
                new PTVCSchema(),
                new PTVCFixture()
                // @todo: Insert more setup classes here
        };
    }
}
