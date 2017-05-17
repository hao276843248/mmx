package mmxresmis.biz.impl;

import java.util.List;

import mmxresmis.biz.WaiterBiz;
import mmxresmis.dao.WaiterDao;
import mmxresmis.dao.impl.WaiterDaoImpl;
import mmxresmis.entity.Waiter;

public class WaiterBizImpl1 implements WaiterBiz {
	 @Override
	public List<Waiter> findallWaiter() {
			return waiterDao.findAllWaiter();
	}

	private WaiterDao waiterDao=null;
	 public WaiterBizImpl1(){
			waiterDao=new WaiterDaoImpl();
	 } 

	@Override
	public boolean addWaiter(Waiter waiter) {
		return waiterDao.saveWaiter(waiter);
	}

	@Override
	public boolean delWaiter(int wid) {
		return waiterDao.delWaiter(wid);
	}

	@Override
	public boolean modifyWaiter(Waiter waiter) {
		return waiterDao.updateWaiter(waiter);
	}

	@Override
	public Waiter queryWaiter(Waiter waiter) {
		return waiterDao.queryWaiter(waiter);
	}

}
