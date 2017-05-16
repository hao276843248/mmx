package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.Food;

public interface FoodDao {
	public boolean saveFood(Food food);//添加菜品
	public boolean delFood(int fid);//删除菜品
	public boolean updateFood(Food food);//更新菜品
	public Food queryFood(Food food);//查询菜品
	public List<Food> findAllFood();//查询所有
	
}
