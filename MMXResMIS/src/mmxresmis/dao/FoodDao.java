package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.Food;

public interface FoodDao {
	public boolean saveFood(Food food);//��Ӳ�Ʒ
	public boolean delFood(int fid);//ɾ����Ʒ
	public boolean updateFood(Food food);//���²�Ʒ
	public Food queryFood(Food food);//��ѯ��Ʒ
	public List<Food> findAllFood();//��ѯ����
	
}
