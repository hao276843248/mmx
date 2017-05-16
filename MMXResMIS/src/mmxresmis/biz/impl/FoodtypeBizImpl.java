package mmxresmis.biz.impl;

import java.util.List;

import mmxresmis.biz.FoodtypeBiz;
import mmxresmis.dao.FoodtypeDao;
import mmxresmis.dao.impl.FoodtypeDaoImpl;
import mmxresmis.entity.Foodtype;

public class FoodtypeBizImpl implements FoodtypeBiz {
	private  FoodtypeDao  foodtypeDao=null;
	 public  FoodtypeBizImpl(){
		 foodtypeDao=new  FoodtypeDaoImpl();
	 } 

	@Override
	public boolean addFoodtype(Foodtype foodtype) {
		return foodtypeDao.saveFoodtype(foodtype);
	}

	@Override
	public boolean modifyFoodtype(Foodtype foodtype) {
		return foodtypeDao.updateFoodtype(foodtype);
	}

	@Override
	public boolean delFoodtype(int ftid) {
		return foodtypeDao.delFoodtype(ftid);
	}

	@Override
	public Foodtype queryFoodtype(Foodtype foodtype) {
		return foodtypeDao.queryFoodtype(foodtype);
	}

	@Override
	public List<Foodtype> findallFoodtype() {
		return foodtypeDao.findallFoodtype();
	}

}
