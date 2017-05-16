package mmxresmis.biz;

import java.util.List;

import mmxresmis.entity.Foodtype;

public interface FoodtypeBiz {

	public boolean addFoodtype(Foodtype foodtype);//保存菜品类别
	public boolean modifyFoodtype(Foodtype foodtype);//更新菜品类别
	public boolean delFoodtype(int ftid);//删除菜品类别
	public Foodtype queryFoodtype(Foodtype foodtype);//查询菜品类别
	public List<Foodtype> findallFoodtype();//查询所有菜品类别
}
