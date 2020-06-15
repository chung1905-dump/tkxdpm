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

    public Object getData(int i) {
        switch (i) {
            case 0:
                return getId();
            case 1:
                return getName();
            case 2:
                return getMerchandise();
            case 3:
                return getQty();
            case 4:
                return getUnit();
            default:
                return null;
        }
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
