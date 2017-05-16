package mmxresmis.entity;

public class Evaluate {
	 private int eid;
	 private String neirong;
	 private String fid;
	 private String edatetime;
	 public Evaluate(){
	    	
	    }
	 
	public Evaluate(int eid, String neirong, String fid, String edatetime) {
		super();
		this.eid = eid;
		this.neirong = neirong;
		this.fid = fid;
		this.edatetime = edatetime;
	}
	
	public Evaluate(String neirong, String fid, String edatetime) {
		super();
		this.neirong = neirong;
		this.fid = fid;
		this.edatetime = edatetime;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getEdatetime() {
		return edatetime;
	}
	public void setEdatetime(String edatetime) {
		this.edatetime = edatetime;
	}
	
	
	 
}
