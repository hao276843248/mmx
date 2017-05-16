package mmxresmis.biz;

import java.util.List;

import mmxresmis.entity.Guestfood;

public interface GuestfoodBiz {
	public boolean addGuestfood(Guestfood guestfood );//添加顾客订单
	public boolean delGuestfood(int gid);//删除顾客订单
	public boolean updateGuestfood(Guestfood guestfood);//更新顾客订单
	public List<Guestfood> queryGuestfood(String id);//查询顾客订单
	
	
	
	
}
