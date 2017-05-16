package mmxresmis.biz.impl;

import java.util.List;

import mmxresmis.biz.FoodBiz;
import mmxresmis.dao.FoodDao;
import mmxresmis.dao.impl.FoodDaoImpl;
import mmxresmis.entity.Food;

public class FoodBizImpl implements FoodBiz {
	private FoodDao foodDao=null;
	 public FoodBizImpl(){
		 foodDao=new FoodDaoImpl();
	 } 

	@Override
	public boolean addFood(Food food) {
		return foodDao.saveFood(food);
	}

	@Override
	public boolean delFood(int fid) {
		return foodDao.delFood(fid);
	}

	@Override
	public boolean modifyFood(Food food) {
		return foodDao.updateFood(food);
	}

	@Override
	public Food queryFood(Food food) {
		return foodDao.queryFood(food);
	}

	@Override
	public List<Food> findAllFood() {
		return foodDao.findAllFood();
	}

}
