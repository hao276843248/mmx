package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.FoodtypeDao;
import mmxresmis.entity.Food;
import mmxresmis.entity.Foodtype;

public class FoodtypeDaoImpl extends BaseDao implements FoodtypeDao {

	@Override
	public boolean saveFoodtype(Foodtype foodtype) {
		String sql="insert into foodtype(foodtype)values(?)";
		List<Object> params=new ArrayList<Object>();
		params.add(foodtype.getFoodtype());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateFoodtype(Foodtype foodtype) {
		String sql="updata foodtype set foodtype=? where ftypeid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(foodtype.getFoodtype());
		params.add(foodtype.getFtypeid());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delFoodtype(int ftid) {
		String sql="delete from foodtype where ftypeid=?" ;
		List<Object> params=new ArrayList<Object>();
		params.add(ftid);
		return this.operUpdate(sql, params);
	}

	@Override
	public Foodtype queryFoodtype(Foodtype foodtype) {
		List<Foodtype> ftList=null;
		String sql="select ftypeid,foodtype from foodtype where foodtype=?";
		List<Object> params=new ArrayList<Object>();
		params.add(foodtype.getFoodtype());
		try {
			ftList=this.operQuery(sql, params,Foodtype.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(ftList.size()>0){
			return ftList.get(0);
		}
		return null;
	}

	@Override
	public List<Foodtype> findallFoodtype() {
		List<Foodtype> fList=null;
		String sql="select ftypeid,foodtype from foodtype";
		try {
			fList=this.operQuery(sql,null,Foodtype.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fList;
	}

}
