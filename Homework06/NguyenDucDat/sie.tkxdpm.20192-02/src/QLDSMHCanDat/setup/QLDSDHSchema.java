package QLDSMHCanDat.setup;
import setup.database.ISetup;
public class QLDSDHSchema implements ISetup{
	public String getRawSQL() {
        return "CREATE TABLE IF NOT EXISTS qldsmhcandat " +
                
                " (idProduct int AUTO_INCREMENT, " +
                " number int, " +
                " unit VARCHAR(255), " +
                " date DATE, " +
                " PRIMARY KEY ( idProduct ))";
    }
}
