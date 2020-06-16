package QuanLyMHKD.setup;

import QuanLyMHKD.entity.MatHangKinhDoanh;
import main.entity.MetaData;
import main.entity.MetaDataFactory;
import setup.database.ISetup;
import setup.database.TableBuilder;

public class MHKDSchema implements ISetup {
    public String getRawSQL() {
        MetaDataFactory mdf = MetaDataFactory.getInstance();
        MetaData md = mdf.getMetaData(MatHangKinhDoanh.class);
        return TableBuilder.buildSQLFromMetaData(md);
    }
}
