package QuanLyDonHang.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import QuanLySite.Site;
import QLDSMHCanDat.entity.*;

public class DonHang {
	private String maDonHang;
	private Date ngayNhan;
	private List<QLDSMHCanDat> DSMH;
	private TrangThai trangThai;
	private Site site;
	
	public DonHang(String maDonHang, Date ngayNhan) {
		this.maDonHang = maDonHang;
		this.ngayNhan = ngayNhan;
		this.trangThai = TrangThai.ChuaChuyen;
		this.DSMH = new ArrayList<QLDSMHCanDat>();		
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public List<QLDSMHCanDat> getDSMH() {
		return DSMH;
	}

	public void setDSMH(List<QLDSMHCanDat> dSMH) {
		DSMH = dSMH;
	}

	public TrangThai getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThai trangThai) {
		this.trangThai = trangThai;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
