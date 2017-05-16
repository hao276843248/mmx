package mmxresmis.biz.impl;

import mmxresmis.biz.EvaluateBiz;
import mmxresmis.dao.EvaluateDao;
import mmxresmis.dao.impl.EvaluateDaoImpl;
import mmxresmis.entity.Evaluate;

public class EvaluateBizImpl implements EvaluateBiz {
	 private EvaluateDao evaluateDao=null;
	 public EvaluateBizImpl(){
		 evaluateDao=new EvaluateDaoImpl();
	 } 

	@Override
	public boolean addEvaluate(Evaluate evaluate) {
		return evaluateDao.saveEvaluate(evaluate);
	}

	@Override
	public boolean updateEvaluate(Evaluate evaluate) {
		return evaluateDao.updateEvaluate(evaluate);
	}

	@Override
	public Evaluate queryEvaluate(Evaluate evaluate) {
		return evaluateDao.queryEvaluate(evaluate);
	}

}
