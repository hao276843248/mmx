package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.Guestfood;

public interface GuestfoodDao {
	public boolean saveGuestfood(Guestfood guestfood );//��ӹ˿Ͷ���
	public boolean delGuestfood(int gid);//ɾ���˿Ͷ���
	public boolean updateGuestfood(Guestfood guestfood);//���¹˿Ͷ���
	public List<Guestfood> queryGuestfood(String id);//��ѯ�˿Ͷ���
	
}
