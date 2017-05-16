package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.GuestfoodDao;
import mmxresmis.entity.Guestfood;

public class GuestfoodDaoImpl extends BaseDao implements GuestfoodDao {

	@Override
	public boolean saveGuestfood(Guestfood guestfood) {
		String sql="insert into tb_Guestfood(foodnum,foodname,foodsum,foodallprice,wname,beizhu,zhuotainame,gdatetime)values(?,?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(guestfood.getFoodnum());
		params.add(guestfood.getFoodname());
		params.add(guestfood.getFoodsum());
		params.add(guestfood.getFoodallprice());//
		params.add(guestfood.getWname());
		params.add(guestfood.getBeizhu());
		params.add(guestfood.getZhuotainum());
		params.add(guestfood.getGatetime());//
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delGuestfood(int gid) {
		String sql="delete from tb_Guestfood where gid=?" ;
		List<Object> params=new ArrayList<Object>();
		params.add(gid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateGuestfood(Guestfood guestfood) {
		String sql="updata tb_Guestfood set foodnum=?,foodname=?,foodsum=?,foodallprice=?,wname=?,beizhu=?,zhuotainame=?,gdatetime=? where gid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(guestfood.getFoodnum());
		params.add(guestfood.getFoodname());
		params.add(guestfood.getFoodsum());
		params.add(guestfood.getFoodallprice());//
		params.add(guestfood.getWname());
		params.add(guestfood.getBeizhu());
		params.add(guestfood.getZhuotainum());
		params.add(guestfood.getGatetime());//
		params.add(guestfood.getGid());
		return this.operUpdate(sql, params);
	}

	@Override
	public Guestfood queryGuestfood(Guestfood guestfood) {
		List<Guestfood> gList=null;
		String sql="select gid,foodnum,foodname,foodsum,foodallprice,wname,beizhu,zhuotainame,gdatetime from tb_Guestfood where foodnum=?and foodname=? and foodsum=? and foodallprice =? and wname =? and beizhu =? and zhuotainame =? and gdatetime=?";
		List<Object> params=new ArrayList<Object>();
		params.add(guestfood.getFoodnum());
		params.add(guestfood.getFoodname());
		params.add(guestfood.getFoodsum());
		params.add(guestfood.getFoodallprice());//
		params.add(guestfood.getWname());
		params.add(guestfood.getBeizhu());
		params.add(guestfood.getZhuotainum());
		params.add(guestfood.getGatetime());//
		try {
			gList=this.operQuery(sql, params,Guestfood.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(gList.size()>0){
			return gList.get(0);
		}
		return null;
	}

}
