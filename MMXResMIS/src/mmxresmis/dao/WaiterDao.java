package mmxresmis.dao;

import mmxresmis.entity.Waiter;

public interface WaiterDao {
	public boolean saveWaiter(Waiter waiter);//添加服务员
	public boolean delWaiter(int wid);//删除服务员
	public boolean updateWaiter(Waiter waiter);//更新服务员
	public  Waiter queryWaiter(Waiter waiter);//查询服务员
	
}
