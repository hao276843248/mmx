package mmxresmis.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mmxresmis.dao.EvaluateDao;
import mmxresmis.entity.Evaluate;

public class EvaluateDaoImpl extends BaseDao implements EvaluateDao {

	@Override
	public boolean saveEvaluate(Evaluate evaluate) {
		String sql="insert into tb_Evaluate(neirong,fid,edatetime)values(?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(evaluate.getNeirong());
		params.add(evaluate.getFid());
		params.add(evaluate.getEdatetime());
		return this.operUpdate(sql, params);
		
	}

	@Override
	public boolean updateEvaluate(Evaluate evaluate) {
		String sql="updata tb_Evaluate set neirong=?,fid=?,edatetime=? where eid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(evaluate.getNeirong());
		params.add(evaluate.getFid());
		params.add(evaluate.getEdatetime());
		params.add(evaluate.getEid());
		return this.operUpdate(sql, params);
	}

	@Override
	public Evaluate queryEvaluate(Evaluate evaluate) {
		List<Evaluate> eList=null;
		String sql="select eid,neirong,fid,edatetime from tb_Evaluate where neirong=?and fid=?and edatetime=?";
		List<Object> params=new ArrayList<Object>();
		params.add(evaluate.getNeirong());
		params.add(evaluate.getFid());
		params.add(evaluate.getEdatetime());
		try {
			eList=this.operQuery(sql, params,Evaluate.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(eList.size()>0){
			return eList.get(0);
		}
		return null;
	}

}
