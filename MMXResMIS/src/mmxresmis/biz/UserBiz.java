package mmxresmis.biz;

import java.util.List;

import mmxresmis.entity.User;

public interface UserBiz {
	public boolean addUser(User user);//添加用户
	public boolean delUser(int id);//删除用户
	public  List<User> queryAllUser();//查询所有用户
	public  List<User> queryUserByName(String uname);//查询指定名字用户
	//用户登录，返回的是登录用户的信息
	public User login(User user);
	// 注册用户
//	public int registerUser(User user);
}
