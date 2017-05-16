package mmxresmis.entity;

import java.math.BigDecimal;

public class Food {
	   private Integer fid;
	   private String foodtype;
	   private String foodnum;
	   private String foodname;
	   private BigDecimal foodprice;
	   public Food(){
	    	
	    }
	   
	public Food(Integer fid, String foodtype, String foodnum, String foodname,
			BigDecimal foodprice) {
		super();
		this.fid = fid;
		this.foodtype = foodtype;
		this.foodnum = foodnum;
		this.foodname = foodname;
		this.foodprice = foodprice;
	}
	
	public Food(String foodtype, String foodnum, String foodname,
			BigDecimal foodprice) {
		super();
		this.foodtype = foodtype;
		this.foodnum = foodnum;
		this.foodname = foodname;
		this.foodprice = foodprice;
	}

	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
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
	public BigDecimal getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(BigDecimal foodprice) {
		this.foodprice = foodprice;
	}
	   
}
