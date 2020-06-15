package QLDSMHCanDat.setup;
import setup.database.ISetup;
public class QLDSDHFixture implements ISetup {
	 public String getRawSQL() {
	        return "INSERT INTO qldsmhcandat (number,unit, date) " +
	                "VALUES ('1', 'chiec', '2020-02-03')" ;
	    }
}
