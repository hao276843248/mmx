package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.GuestfoodDao;
import mmxresmis.entity.Guestfood;

public class GuestfoodDaoImpl extends BaseDao implements GuestfoodDao {

	@Override
	public boolean saveGuestfood(Guestfood guestfood) {
		String sql="INSERT INTO mmxresmis.guestfood ( foodnum, foodname, foodsum, foodallprice, wname, beizhu, zhuotainum, gdatetime, foodprice) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		List<Object> params=new ArrayList<Object>();
		params.add(guestfood.getFoodnum());
		params.add(guestfood.getFoodname());
		params.add(guestfood.getFoodsum());
		params.add(guestfood.getFoodallprice());//
		params.add(guestfood.getWname());
		params.add(guestfood.getBeizhu());
		params.add(guestfood.getZhuotainum());
		params.add(guestfood.getGdatetime());//
		params.add(guestfood.getFoodprice());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delGuestfood(int gid) {
		String sql="delete from guestfood where gid=?" ;
		List<Object> params=new ArrayList<Object>();
		params.add(gid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateGuestfood(Guestfood guestfood) {
		String sql="UPDATE mmxresmis.guestfood SET foodnum=?, foodname=?, foodsum=?, foodallprice=?, wname=?, beizhu=?, zhuotainum=?, gdatetime=?, foodprice=? WHERE gid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(guestfood.getFoodnum());
		params.add(guestfood.getFoodname());
		params.add(guestfood.getFoodsum());
		params.add(guestfood.getFoodallprice());//
		params.add(guestfood.getWname());
		params.add(guestfood.getBeizhu());
		params.add(guestfood.getZhuotainum());
		params.add(guestfood.getGdatetime());//
		params.add(guestfood.getFoodprice());//
		params.add(guestfood.getGid());
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Guestfood> queryGuestfood(String id){//²éÑ¯¹Ë¿Í¶©µ¥
		List<Guestfood> gList=null;
		String sql="SELECT gid, foodnum, foodname, foodsum, foodallprice, wname, beizhu, zhuotainum, gdatetime,foodprice FROM guestfood  where zhuotainum=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		try {
			gList=this.operQuery(sql, params,Guestfood.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gList;
	}

}
