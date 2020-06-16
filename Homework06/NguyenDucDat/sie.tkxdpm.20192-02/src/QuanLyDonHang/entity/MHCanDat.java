package QuanLyDonHang.entity;

import QuanLyDSMatHang.MatHang;

public class MHCanDat {
	private MatHang matHang;
	private int soLuong;
	
	public MHCanDat(MatHang matHang, int soLuong) {
		this.matHang = matHang;
		this.soLuong = soLuong;
	}

	public MatHang getMatHang() {
		return matHang;
	}

	public void setMatHang(MatHang matHang) {
		this.matHang = matHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
}
