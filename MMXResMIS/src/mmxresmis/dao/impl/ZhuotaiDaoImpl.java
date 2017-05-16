package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.ZhuotaiDao;
import mmxresmis.entity.User;
import mmxresmis.entity.Zhuotai;

public class ZhuotaiDaoImpl extends BaseDao implements ZhuotaiDao {

	@Override
	public boolean saveZhuotai(Zhuotai zhuotai) {
		String sql="insert into zhuotai(zhuotainum,zhuotaijc,zhuotaibjf,zhuotaiwz,zhuotaizt,zhuotaitype,zhuotaibz,zhuotaiqt,guestname,zhangdandate,num,wname)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(zhuotai.getZhuotainum());
		params.add(zhuotai.getZhuotaijc());
		params.add(zhuotai.getZhuotaibjf());
		params.add(zhuotai.getZhuotaiwz());//
		params.add(zhuotai.getZhuotaizt());
		params.add(zhuotai.getZhuotaitype());
		params.add(zhuotai.getZhuotaibz());//
		params.add(zhuotai.getZhuotaiqt());
		params.add(zhuotai.getGuestname());
		params.add(zhuotai.getZhangdandate());//
		params.add(zhuotai.getNum());
		params.add(zhuotai.getWname());
	
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delZhuotai(int ztid) {
		String sql="delete from zhuotai where ztid=?" ;
		List<Object> params=new ArrayList<Object>();
		params.add(ztid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateZhuotai(Zhuotai zhuotai) {
		String sql="UPDATE mmxresmis.zhuotai SET zhuotainum=?, zhuotaijc=?, zhuotaibjf=?, zhuotaiwz=?, zhuotaizt=?, zhuotaitype=?, zhuotaibz=?, zhuotaiqt=?, guestname=?, zhangdandate=?, num=?, wname=? WHERE ztid=?;";
		List<Object> params=new ArrayList<Object>();
		params.add(zhuotai.getZhuotainum());
		params.add(zhuotai.getZhuotaijc());
		params.add(zhuotai.getZhuotaibjf());
		params.add(zhuotai.getZhuotaiwz());//
		params.add(zhuotai.getZhuotaizt());
		params.add(zhuotai.getZhuotaitype());
		params.add(zhuotai.getZhuotaibz());//
		params.add(zhuotai.getZhuotaiqt());
		params.add(zhuotai.getGuestname());
		params.add(zhuotai.getZhangdandate());//
		params.add(zhuotai.getNum());
		params.add(zhuotai.getWname());
		params.add(zhuotai.getZtid());
		System.out.println(sql);
		return this.operUpdate(sql, params);
	}

	@Override
	public Zhuotai queryZhuotai(Zhuotai zhuotai) {
		List<Zhuotai> ztList=null;
		String sql="select ztid,zhuotainum,zhuotaijc,zhuotaibjf,zhuotaiwz,zhuotaizt,zhuotaitype,zhuotaibz,zhuotaiqt,guestname,zhangdandate,num,wname from zhuotai where zhuotainum=?and zhuotaijc=?and zhuotaibjf=?and zhuotaiwz=?and zhuotaizt=?and zhuotaitype=?and zhuotaibz=?and zhuotaiqt=?and guestname=?and zhangdandate=?and num=?and wname=?";
		List<Object> params=new ArrayList<Object>();
		params.add(zhuotai.getZhuotainum());
		params.add(zhuotai.getZhuotaijc());
		params.add(zhuotai.getZhuotaibjf());
		params.add(zhuotai.getZhuotaiwz());//
		params.add(zhuotai.getZhuotaizt());
		params.add(zhuotai.getZhuotaitype());
		params.add(zhuotai.getZhuotaibz());//
		params.add(zhuotai.getZhuotaiqt());
		params.add(zhuotai.getGuestname());
		params.add(zhuotai.getZhangdandate());//
		params.add(zhuotai.getNum());
		params.add(zhuotai.getWname());
		try {
			ztList=this.operQuery(sql, params,Zhuotai.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ztList.size()>0){
			return ztList.get(0);
		}
		return null;
	
	}

	@Override
	public List<Zhuotai> queryAllZhuotai() {
		List<Zhuotai> uList=null;
		String sql="select ztid,zhuotainum,zhuotaijc,zhuotaibjf,zhuotaiwz,zhuotaizt,zhuotaitype,zhuotaibz,zhuotaiqt,guestname,zhangdandate,num,wname from zhuotai ";
		try {
			uList=this.operQuery(sql, null, Zhuotai.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uList;
	}

}
