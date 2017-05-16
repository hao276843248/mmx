package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.User;

public interface UserDao {
	public boolean saveUser(User user);//����û�
	public boolean delUser(int id);//ɾ���û�
	public boolean updateUser(User user);//�����û�
	public User queryUser1(User user) ;//��¼��ѯ�û�
	public List<User> queryAllUser() ;//��ѯ�û�
	public List<User> queryUserByName(String uname) ;//��ѯָ�����ֵ��û�
	
	
}
