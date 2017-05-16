package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.FoodDao;
import mmxresmis.entity.Food;
import mmxresmis.entity.User;

public class FoodDaoImpl extends BaseDao implements FoodDao {

	@Override
	public boolean saveFood(Food food) {
		String sql="insert into food(foodtype,foodnum,foodname,foodprice)values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(food.getFoodtype());
		params.add(food.getFoodnum());
		params.add(food.getFoodname());
		params.add(food.getFoodprice());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delFood(int fid) {
		String sql="delete from food where fid=?" ;
		List<Object> params=new ArrayList<Object>();
		params.add(fid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateFood(Food food) {
		String sql="updata food set foodtype=?,foodnum=?,foodname=?,foodprice=? where fid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(food.getFoodtype());
		params.add(food.getFoodnum());
		params.add(food.getFoodname());
		params.add(food.getFoodprice());
		params.add(food.getFid());
		return this.operUpdate(sql, params);
	}

	@Override
	public Food queryFood(Food food) {
		List<Food> fList=null;
		String sql="select fid,foodtype,foodnum,foodname,foodprice from food where foodtype=?and foodnum=?and foodname=?and foodprice=?";
		List<Object> params=new ArrayList<Object>();
		params.add(food.getFoodtype());
		params.add(food.getFoodnum());
		params.add(food.getFoodname());
		params.add(food.getFoodprice());
		try {
			fList=this.operQuery(sql, params,Food.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(fList.size()>0){
			return fList.get(0);
		}
		return null;
	}

	
	@Override
	public List<Food> findAllFood() {
		List<Food> fList=null;
		String sql="select fid,foodtype,foodnum,foodname,foodprice from food ";
		try {
			fList=this.operQuery(sql,null,Food.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fList;
	}

}
