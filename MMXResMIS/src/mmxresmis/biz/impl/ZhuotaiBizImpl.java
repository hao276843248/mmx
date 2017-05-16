package mmxresmis.biz.impl;

import java.util.List;

import mmxresmis.biz.ZhuotaiBiz;
import mmxresmis.dao.ZhuotaiDao;
import mmxresmis.dao.impl.ZhuotaiDaoImpl;
import mmxresmis.entity.Zhuotai;

public class ZhuotaiBizImpl implements ZhuotaiBiz {
	private ZhuotaiDao zhuotaiDao=null;
	 public ZhuotaiBizImpl(){
		 zhuotaiDao=new ZhuotaiDaoImpl();
	 } 

	@Override
	public boolean addZhuotai(Zhuotai zhuotai) {
		return zhuotaiDao.saveZhuotai(zhuotai);
	}

	@Override
	public boolean delZhuotai(int ztid) {
		return zhuotaiDao.delZhuotai(ztid);
	}

	@Override
	public boolean updateZhuotai(Zhuotai zhuotai) {
		return zhuotaiDao.updateZhuotai(zhuotai);
	}

	@Override
	public Zhuotai queryZhuotai(Zhuotai zhuotai) {
		return zhuotaiDao.queryZhuotai(zhuotai);
	}

	@Override
	public List<Zhuotai> queryAllZhuotai() {
		// TODO Auto-generated method stub
		return zhuotaiDao.queryAllZhuotai();
	}
}
