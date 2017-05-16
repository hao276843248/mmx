package mmxresmis.dao;

import java.util.List;

import mmxresmis.entity.Zhuotai;

public interface ZhuotaiDao {
	public boolean saveZhuotai(Zhuotai zhuotai);//添加房间
	public boolean delZhuotai(int ztid);//删除房间
	public boolean updateZhuotai(Zhuotai zhuotai);//更新房间
	public Zhuotai queryZhuotai(Zhuotai zhuotai);//查询房间
	public List<Zhuotai> queryAllZhuotai();//查询所有房间
}
