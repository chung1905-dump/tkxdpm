package QuanLyMHKD.setup;

import QuanLyMHKD.entity.MatHangKinhDoanh;
import main.entity.MetaData;
import main.entity.MetaDataFactory;
import setup.database.ISetup;
import setup.database.TableBuilder;

public class MHKDSchema implements ISetup {
    public String getRawSQL() {
        MetaDataFactory<MatHangKinhDoanh> mdf = new MetaDataFactory<>();
        MetaData md = mdf.createMetaData(MatHangKinhDoanh.class);
        return TableBuilder.buildSQLFromMetaData(md);
    }
}
