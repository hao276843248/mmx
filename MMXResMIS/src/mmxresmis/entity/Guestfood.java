package mmxresmis.entity;

public class Guestfood {
	private int gid;
	private String foodnum;
	private String foodname;
	private String foodsum;
	private String foodallprice;
	private String wname;
	private String beizhu;
	private String zhuotainum;
	private String gdatetime;
	 public Guestfood(){
	    	
	    }
	
	public Guestfood(int gid, String foodnum, String foodname, String foodsum,
			String foodallprice, String wname, String beizhu, String zhuotainum,
			String gdatetime) {
		super();
		this.gid = gid;
		this.foodnum = foodnum;
		this.foodname = foodname;
		this.foodsum = foodsum;
		this.foodallprice = foodallprice;
		this.wname = wname;
		this.beizhu = beizhu;
		this.zhuotainum = zhuotainum;
		this.gdatetime = gdatetime;
	}
	
	public Guestfood(String foodnum, String foodname, String foodsum,
			String foodallprice, String wname, String beizhu, String zhuotainum,
			String gdatetime) {
		super();
		this.foodnum = foodnum;
		this.foodname = foodname;
		this.foodsum = foodsum;
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
	public String getFoodallprice() {
		return foodallprice;
	}
	public void setFoodallprice(String foodallprice) {
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
	public String getGatetime() {
		return gdatetime;
	}
	public void setDatatime(String gdatetime) {
		this.gdatetime = gdatetime;
	}
	
}
