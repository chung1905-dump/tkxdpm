package QuanLyMHKD.entity;

import main.entity.annotation.*;

@Entity(table = "mat_hang_kinh_doanh", primaryKey = "id")
public class MatHangKinhDoanh {
    @Column(name = "id", type = "INTEGER", options = "NOT NULL AUTO_INCREMENT")
    private int id;
    @Column(name = "name", type = "VARCHAR(255)")
    private String name;
    @Column(name = "merchandise", type = "VARCHAR(255)")
    private String merchandise;
    @Column(name = "qty", type = "FLOAT")
    private float qty;
    @Column(name = "unit", type = "VARCHAR(255)")
    private String unit;

    public MatHangKinhDoanh(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public MatHangKinhDoanh setId(int id) throws Exception {
        if (this.id > 0) {
            throw new Exception("Can not change ID of entity");
        }
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MatHangKinhDoanh setName(String name) {
        this.name = name;
        return this;
    }

    public String getMerchandise() {
        return merchandise;
    }

    public MatHangKinhDoanh setMerchandise(String merchandise) {
        this.merchandise = merchandise;
        return this;
    }

    public float getQty() {
        return qty;
    }

    public MatHangKinhDoanh setQty(float qty) {
        this.qty = qty;
        return this;
    }

    public String getUnit() {
        return unit;
    }

    public MatHangKinhDoanh setUnit(String unit) {
        this.unit = unit;
        return this;
    }
}
