package mmxresmis.dao;

import mmxresmis.entity.Waiter;

public interface WaiterDao {
	public boolean saveWaiter(Waiter waiter);//��ӷ���Ա
	public boolean delWaiter(int wid);//ɾ������Ա
	public boolean updateWaiter(Waiter waiter);//���·���Ա
	public  Waiter queryWaiter(Waiter waiter);//��ѯ����Ա
	
}
