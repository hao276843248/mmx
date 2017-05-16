package mmxresmis.biz.impl;

import java.util.List;

import mmxresmis.biz.UserBiz;
import mmxresmis.dao.UserDao;
import mmxresmis.dao.impl.UserDaoImpl;
import mmxresmis.entity.User;

public class UserBizImpl implements UserBiz {
	private UserDao userDao=null;
	 public UserBizImpl(){
	    userDao=new UserDaoImpl();
	 } 
	 
	@Override
	public List<User> queryUserByName(String uname) {
		return userDao.queryUserByName(uname);
	}
	
	@Override
	public boolean addUser(User user) {
		return userDao.saveUser(user);
	
	}

	@Override
	public boolean delUser(int id) {
		return userDao.delUser(id);
	}

	@Override
	public List<User> queryAllUser() {
		return userDao.queryAllUser();
	}
	@Override
	public User login(User user) {
		return userDao.queryUser1(user);
	}

//	@Override
//	public int registerUser(User user) {
//		if(userDao.queryUser(user)!=null){
//			return 1;//此用户已经存在
//		}else{
//			boolean res=userDao.saveUser(user);
//			if(res){
//				return 2;//注册成功
//			}else{
//				return 3;//注册失败
//			}
			
//		}
//	}

}
