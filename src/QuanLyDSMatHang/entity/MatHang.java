package QuanLyDSMatHang.entity;


import main.entity.annotation.Column;
import main.entity.annotation.Entity;

@Entity(table = "mathang", primaryKey = "id")
public class MatHang {
    @Column(name = "id", type = "VARCHAR(255)")
    private String id;
    @Column(name = "ten", type = "VARCHAR(255)")
    private String ten;

    private boolean isNew;

    public MatHang(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
