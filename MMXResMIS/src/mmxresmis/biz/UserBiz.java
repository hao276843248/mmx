package mmxresmis.biz;

import java.util.List;

import mmxresmis.entity.User;

public interface UserBiz {
	public boolean addUser(User user);//����û�
	public boolean delUser(int id);//ɾ���û�
	public  List<User> queryAllUser();//��ѯ�����û�
	public  List<User> queryUserByName(String uname);//��ѯָ�������û�
	//�û���¼�����ص��ǵ�¼�û�����Ϣ
	public User login(User user);
	// ע���û�
//	public int registerUser(User user);
}
