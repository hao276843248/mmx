package mmxresmis.entity;

public class Zhuotai {
	private Integer ztid;
	private String zhuotainum;
	private String zhuotaijc;
	private String zhuotaibjf;
	private String zhuotaiwz;
	private String zhuotaizt;
	private String zhuotaitype;
	private String zhuotaibz;
	private String zhuotaiqt;
	private String guestname;
	private String zhangdandate;
	private Integer num;
	private String wname;
	public Zhuotai(){
    	
    }
	
	public Zhuotai(int ztid, String zhuotainum, String zhuotaijc,
			String zhuotaibjf, String zhuotaiwz, String zhuotaizt,
			String zhuotaitype, String zhuotaibz, String zhuotaiqt,
			String guestname, String zhangdandate, int num, String wname) {
		super();
		this.ztid = ztid;
		this.zhuotainum = zhuotainum;
		this.zhuotaijc = zhuotaijc;
		this.zhuotaibjf = zhuotaibjf;
		this.zhuotaiwz = zhuotaiwz;
		this.zhuotaizt = zhuotaizt;
		this.zhuotaitype = zhuotaitype;
		this.zhuotaibz = zhuotaibz;
		this.zhuotaiqt = zhuotaiqt;
		this.guestname = guestname;
		this.zhangdandate = zhangdandate;
		this.num = num;
		this.wname = wname;
	}
	
	
	public Zhuotai(String zhuotainum, String zhuotaijc, String zhuotaibjf,
			String zhuotaiwz, String zhuotaizt, String zhuotaitype,
			String zhuotaibz, String zhuotaiqt, String guestname,
			String zhangdandate, int num, String wname) {
		super();
		this.zhuotainum = zhuotainum;
		this.zhuotaijc = zhuotaijc;
		this.zhuotaibjf = zhuotaibjf;
		this.zhuotaiwz = zhuotaiwz;
		this.zhuotaizt = zhuotaizt;
		this.zhuotaitype = zhuotaitype;
		this.zhuotaibz = zhuotaibz;
		this.zhuotaiqt = zhuotaiqt;
		this.guestname = guestname;
		this.zhangdandate = zhangdandate;
		this.num = num;
		this.wname = wname;
	}

	public int getZtid() {
		return ztid;
	}
	public void setZtid(int ztid) {
		this.ztid = ztid;
	}
	public String getZhuotainum() {
		return zhuotainum;
	}
	public void setZhuotainum(String zhuotainum) {
		this.zhuotainum = zhuotainum;
	}
	public String getZhuotaijc() {
		return zhuotaijc;
	}
	public void setZhuotaijc(String zhuotaijc) {
		this.zhuotaijc = zhuotaijc;
	}
	public String getZhuotaibjf() {
		return zhuotaibjf;
	}
	public void setZhuotaibjf(String zhuotaibjf) {
		this.zhuotaibjf = zhuotaibjf;
	}
	public String getZhuotaiwz() {
		return zhuotaiwz;
	}
	public void setZhuotaiwz(String zhuotaiwz) {
		this.zhuotaiwz = zhuotaiwz;
	}
	public String getZhuotaizt() {
		return zhuotaizt;
	}
	public void setZhuotaizt(String zhuotaizt) {
		this.zhuotaizt = zhuotaizt;
	}
	public String getZhuotaitype() {
		return zhuotaitype;
	}
	public void setZhuotaitype(String zhuotaitype) {
		this.zhuotaitype = zhuotaitype;
	}
	public String getZhuotaibz() {
		return zhuotaibz;
	}
	public void setZhuotaibz(String zhuotaibz) {
		this.zhuotaibz = zhuotaibz;
	}
	public String getZhuotaiqt() {
		return zhuotaiqt;
	}
	public void setZhuotaiqt(String zhuotaiqt) {
		this.zhuotaiqt = zhuotaiqt;
	}
	public String getGuestname() {
		return guestname;
	}
	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	public String getZhangdandate() {
		return zhangdandate;
	}
	public void setZhangdandate(String zhangdandate) {
		this.zhangdandate = zhangdandate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	
	
}
