package mmxresmis.biz;

import java.util.List;

import mmxresmis.entity.Foodtype;

public interface FoodtypeBiz {

	public boolean addFoodtype(Foodtype foodtype);//�����Ʒ���
	public boolean modifyFoodtype(Foodtype foodtype);//���²�Ʒ���
	public boolean delFoodtype(int ftid);//ɾ����Ʒ���
	public Foodtype queryFoodtype(Foodtype foodtype);//��ѯ��Ʒ���
	public List<Foodtype> findallFoodtype();//��ѯ���в�Ʒ���
}
