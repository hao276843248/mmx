package mmxresmis.entity;

import java.math.BigDecimal;

public class Guestfood {
	private int gid;
	private String foodnum;
	private String foodname;
	private String foodsum;
	private BigDecimal foodprice;
	private BigDecimal foodallprice;
	private String wname;
	private String beizhu;
	private String zhuotainum;
	private String gdatetime;

	public Guestfood() {
	}
	

	public Guestfood(int gid, String foodnum, String foodname, String foodsum, BigDecimal foodprice,
			BigDecimal foodallprice, String wname, String beizhu, String zhuotainum, String gdatetime) {
		super();
		this.gid = gid;
		this.foodnum = foodnum;
		this.foodname = foodname;
		this.foodsum = foodsum;
		this.foodprice = foodprice;
		this.foodallprice = foodallprice;
		this.wname = wname;
		this.beizhu = beizhu;
		this.zhuotainum = zhuotainum;
		this.gdatetime = gdatetime;
	}




	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getFoodnum() {
		return foodnum;
	}

	public void setFoodnum(String foodnum) {
		this.foodnum = foodnum;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodsum() {
		return foodsum;
	}

	public void setFoodsum(String foodsum) {
		this.foodsum = foodsum;
	}

	public BigDecimal getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(BigDecimal foodprice) {
		this.foodprice = foodprice;
	}

	public BigDecimal getFoodallprice() {
		return foodallprice;
	}

	public void setFoodallprice(BigDecimal foodallprice) {
		this.foodallprice = foodallprice;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getZhuotainum() {
		return zhuotainum;
	}

	public void setZhuotainum(String zhuotainum) {
		this.zhuotainum = zhuotainum;
	}

	public String getGdatetime() {
		return gdatetime;
	}

	public void setGdatetime(String gdatetime) {
		this.gdatetime = gdatetime;
	}

	
	

}