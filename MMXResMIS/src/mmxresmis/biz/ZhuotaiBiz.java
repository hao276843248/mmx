package mmxresmis.biz;

import java.util.List;

import mmxresmis.entity.Zhuotai;

public interface ZhuotaiBiz {
	public boolean addZhuotai(Zhuotai zhuotai);//��ӷ���
	public boolean delZhuotai(int ztid);//ɾ������
	public boolean updateZhuotai(Zhuotai zhuotai);//���·���
	public Zhuotai queryZhuotai(Zhuotai zhuotai);//��ѯ����
	public List<Zhuotai> queryAllZhuotai();//��ѯ���з���
	
	
}
