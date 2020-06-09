package QuanLyPhuongThucVanChuyen;

public class TransportationInfo {
	String siteCode;
	String siteName;
	int byShip;
	int byAir;
	String others;

	/**
	 * @param siteCode
	 * @param siteName
	 * @param byShip
	 * @param byAir
	 * @param others
	 */
	public TransportationInfo(String siteCode, String siteName, int byShip, int byAir, String others) {
		super();
		this.siteCode = siteCode;
		this.siteName = siteName;
		this.byShip = byShip;
		this.byAir = byAir;
		this.others = others;
	}

	/**
	 * @return the siteCode
	 */
	public String getSiteCode() {
		return siteCode;
	}

	/**
	 * @param siteCode the siteCode to set
	 */
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	/**
	 * @return the siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * @param siteName the siteName to set
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * @return the byShip
	 */
	public int getByShip() {
		return byShip;
	}

	/**
	 * @param byShip the byShip to set
	 */
	public void setByShip(int byShip) {
		this.byShip = byShip;
	}

	/**
	 * @return the byAir
	 */
	public int getByAir() {
		return byAir;
	}

	/**
	 * @param byAir the byAir to set
	 */
	public void setByAir(int byAir) {
		this.byAir = byAir;
	}

	/**
	 * @return the others
	 */
	public String getOthers() {
		return others;
	}

	/**
	 * @param others the others to set
	 */
	public void setOthers(String others) {
		this.others = others;
	}

	public void display() {
		System.out.println(this.getSiteCode()+"-"+this.getSiteName()+"-"+this.getByShip()+"-"+this.getByAir()+"-"+this.others);
	}

}
