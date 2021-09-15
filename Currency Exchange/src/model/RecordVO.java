package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RecordVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rid;
	private Double rate;
	private String currency;
	private Double price;
	private Double discount;
	private Double result;
	private Timestamp record_time;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public Timestamp getRecord_time() {
		return record_time;
	}

	public void setRecord_time(Timestamp record_time) {
		this.record_time = record_time;
	}

	@Override
	public String toString() {
		return "recordVO [rid=" + rid + ", rate=" + rate + ", currency=" + currency + ", price=" + price + ", discount="
				+ discount + ", result=" + result + ", record_time=" + record_time + "]";
	}

}
