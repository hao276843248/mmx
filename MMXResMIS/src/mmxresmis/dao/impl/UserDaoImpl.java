package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.UserDao;
import mmxresmis.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<User> queryUserByName(String uname) {
		List<User> uList=null;
		String sql="select id,uname,upass,type from users where uname=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uname);
		try {
			uList=this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uList;
	}

	@Override
	public boolean saveUser(User user) {
		String sql="insert into users(uname,upass,type)values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		return this.operUpdate(sql, params);
		
	}

	@Override
	public boolean delUser(int id) {
		String sql="delete from users where id=?" ;
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateUser(User user) {
		String sql="updata users set uname=?,upass=?,type=? where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		params.add(user.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public User queryUser1(User user) {
		List<User> uList=null;
		String sql="select id,uname,upass,type from users where uname=?and upass=?and type=?";
//		String sql="select * from users ";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getUpass());
		params.add(user.getType());
		try {
			uList=this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(uList.size()>0){
			return uList.get(0);
		}
		return null;
	}
	
	@Override
	public List<User> queryAllUser() {
		List<User> uList=null;
		String sql="select id,uname,upass,type from users ";
		try {
			uList=this.operQuery(sql, null, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uList;
	}


}
