package mmxresmis.biz;

import java.util.List;

import mmxresmis.entity.Food;

public interface FoodBiz {
	public boolean addFood(Food food);//��Ӳ�Ʒ
	public boolean delFood(int fid);//ɾ����Ʒ
	public boolean modifyFood(Food food);//���²�Ʒ
	public Food queryFood(Food food);//��ѯ��Ʒ
	public List<Food> findAllFood();//��ѯ����
}
