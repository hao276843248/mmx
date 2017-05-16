package mmxresmis.biz.impl;

import java.util.List;

import mmxresmis.biz.GuestfoodBiz;
import mmxresmis.dao.GuestfoodDao;
import mmxresmis.dao.impl.GuestfoodDaoImpl;
import mmxresmis.entity.Guestfood;

public class GuestfoodBizImpl implements GuestfoodBiz {
	 private GuestfoodDao guestfoodDao=null;
	 public GuestfoodBizImpl(){
		 guestfoodDao=new GuestfoodDaoImpl();
	 } 

	@Override
	public boolean addGuestfood(Guestfood guestfood) {
		return guestfoodDao.saveGuestfood(guestfood);
	}

	@Override
	public boolean delGuestfood(int gid) {
		return guestfoodDao.delGuestfood(gid);
	}

	@Override
	public boolean updateGuestfood(Guestfood guestfood) {
		return guestfoodDao.updateGuestfood(guestfood);
	}


	@Override
	public List<Guestfood> queryGuestfood(String id) {
		return guestfoodDao.queryGuestfood(id);
	}

}
