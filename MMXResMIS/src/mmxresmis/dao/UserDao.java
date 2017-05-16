package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.User;

public interface UserDao {
	public boolean saveUser(User user);//添加用户
	public boolean delUser(int id);//删除用户
	public boolean updateUser(User user);//更新用户
	public User queryUser1(User user) ;//登录查询用户
	public List<User> queryAllUser() ;//查询用户
	public List<User> queryUserByName(String uname) ;//查询指定名字的用户
	
	
}
