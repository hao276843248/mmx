package mmxresmis.entity;

public class Foodtype {
	private int ftypeid;
	private String foodtype;
	 public Foodtype(){
	    	
	    }
	
	public Foodtype(int ftypeid, String foodtype) {
		super();
		this.ftypeid = ftypeid;
		this.foodtype = foodtype;
	}
	
	public Foodtype(String foodtype) {
		super();
		this.foodtype = foodtype;
	}

	public int getFtypeid() {
		return ftypeid;
	}
	public void setFtypeid(int ftypeid) {
		this.ftypeid = ftypeid;
	}
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	
}
