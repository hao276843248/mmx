package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.Foodtype;


public interface FoodtypeDao {
	public boolean saveFoodtype(Foodtype foodtype);//�����Ʒ���
	public boolean updateFoodtype(Foodtype foodtype);//���²�Ʒ���
	public boolean delFoodtype(int ftid);//ɾ����Ʒ���
	public Foodtype queryFoodtype(Foodtype foodtype);//��ѯ��Ʒ���
	public List<Foodtype> findallFoodtype();//��ѯ���в�Ʒ���
}
