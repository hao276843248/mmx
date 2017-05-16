package mmxresmis.dao;

import mmxresmis.entity.Guestfood;

public interface GuestfoodDao {
	public boolean saveGuestfood(Guestfood guestfood );//添加顾客订单
	public boolean delGuestfood(int gid);//删除顾客订单
	public boolean updateGuestfood(Guestfood guestfood);//更新顾客订单
	public Guestfood queryGuestfood(Guestfood guestfood);//查询顾客订单
	
}
