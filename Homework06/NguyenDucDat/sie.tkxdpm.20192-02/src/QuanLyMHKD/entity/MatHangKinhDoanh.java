package QuanLyMHKD.entity;

public class MatHangKinhDoanh {
    private int id;
    private String name;
    private String merchandise;
    private float qty;
    private String unit;

    public MatHangKinhDoanh(int id) {
        this.id = id;
    }

    public MatHangKinhDoanh() {

    }

    public int getId() {
        return id;
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
