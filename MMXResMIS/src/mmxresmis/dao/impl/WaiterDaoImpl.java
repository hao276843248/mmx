package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.WaiterDao;
import mmxresmis.entity.Waiter;

public class WaiterDaoImpl extends BaseDao implements WaiterDao {

	@Override
	public boolean saveWaiter(Waiter waiter) {
		String sql="insert into tb_Waiter(wnum,wname,wsex,wage,wtel)values(?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(waiter.getWnum());
		params.add(waiter.getWname());
		params.add(waiter.getWsex());
		params.add(waiter.getWage());
		params.add(waiter.getWtel());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean delWaiter(int wid) {
		String sql="delete from tb_Waiter where wid=?" ;
		List<Object> params=new ArrayList<Object>();
		params.add(wid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateWaiter(Waiter waiter) {
		String sql="updata tb_Waiter set wnum=?,wname=?,wsex=?,wage=?,wtel=? where wid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(waiter.getWnum());
		params.add(waiter.getWname());
		params.add(waiter.getWsex());
		params.add(waiter.getWage());
		params.add(waiter.getWtel());
		params.add(waiter.getWid());
		return this.operUpdate(sql, params);
	}

	@Override
	public Waiter queryWaiter(Waiter waiter) {
		List<Waiter> wList=null;
		String sql="select wid,wnum,wname,wsex,wage,wtel from tb_Waiter where wnum=?and wname=? and wsex= and wage=? and wtel=?";
		List<Object> params=new ArrayList<Object>();
		params.add(waiter.getWnum());
		params.add(waiter.getWname());
		params.add(waiter.getWsex());
		params.add(waiter.getWage());
		params.add(waiter.getWtel());
		try {
			wList=this.operQuery(sql, params,Waiter.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(wList.size()>0){
			return wList.get(0);
	}
		return null;
	}
}
