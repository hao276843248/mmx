package mmxresmis.biz;

import mmxresmis.entity.Waiter;

public interface WaiterBiz {
	public boolean addWaiter(Waiter waiter);//���ӷ���Ա
	public boolean delWaiter(int wid);//ɾ������Ա
	public boolean modifyWaiter(Waiter waiter);//���·���Ա
	public  Waiter queryWaiter(Waiter waiter);//��ѯ����Ա
}