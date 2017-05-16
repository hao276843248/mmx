package mmxresmis.biz;

import mmxresmis.entity.Waiter;

public interface WaiterBiz {
	public boolean addWaiter(Waiter waiter);//添加服务员
	public boolean delWaiter(int wid);//删除服务员
	public boolean modifyWaiter(Waiter waiter);//更新服务员
	public  Waiter queryWaiter(Waiter waiter);//查询服务员
}
