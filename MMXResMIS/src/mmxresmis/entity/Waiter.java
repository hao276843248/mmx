package mmxresmis.entity;

public class Waiter {
  
	private int wid;
	private String wnum;
	private String wname;
	private String wsex;
	private String wage;
	private String wtel;
	 public Waiter(){
	    	
	    }
	
	public Waiter(int wid, String wnum, String wname, String wsex, String wage,
			String wtel) {
		super();
		this.wid = wid;
		this.wnum = wnum;
		this.wname = wname;
		this.wsex = wsex;
		this.wage = wage;
		this.wtel = wtel;
	}
	
	public Waiter(String wnum, String wname, String wsex, String wage,
			String wtel) {
		super();
		this.wnum = wnum;
		this.wname = wname;
		this.wsex = wsex;
		this.wage = wage;
		this.wtel = wtel;
	}

	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getWnum() {
		return wnum;
	}
	public void setWnum(String wnum) {
		this.wnum = wnum;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWsex() {
		return wsex;
	}
	public void setWsex(String wsex) {
		this.wsex = wsex;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	public String getWtel() {
		return wtel;
	}
	public void setWtel(String wtel) {
		this.wtel = wtel;
	}
}
