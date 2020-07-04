
package QLDSMHCanDat.entity;
import java.util.Date;

public class QLDSMHCanDat {
	String idProduct;
	int numberProduct;
	String unit;
	Date dateRecieve = new Date();
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public int getNumberProduct() {
		return numberProduct;
	}
	public void setNumberProduct(int numberProduct) {
		this.numberProduct = numberProduct;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getDateRecieve() {
		return dateRecieve;
	}
	public void setDateRecieve(Date dateRecieve) {
		this.dateRecieve = dateRecieve;
	}
	public QLDSMHCanDat(String idProduct, int numberProduct, String unit, Date dateRecieve) {
		super();
		this.idProduct = idProduct;
		this.numberProduct = numberProduct;
		this.unit = unit;
		this.dateRecieve = dateRecieve;
	}
	
}
