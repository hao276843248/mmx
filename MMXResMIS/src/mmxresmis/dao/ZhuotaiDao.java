package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.Zhuotai;

public interface ZhuotaiDao {
	public boolean saveZhuotai(Zhuotai zhuotai);//��ӷ���
	public boolean delZhuotai(int ztid);//ɾ������
	public boolean updateZhuotai(Zhuotai zhuotai);//���·���
	public Zhuotai queryZhuotai(Zhuotai zhuotai);//��ѯ����
	public List<Zhuotai> queryAllZhuotai();//��ѯ���з���
}
