package mmxresmis.dao;

import mmxresmis.entity.Evaluate;


public interface EvaluateDao {
	public boolean saveEvaluate(Evaluate evaluate);//添加评论
	public boolean updateEvaluate(Evaluate evaluate);//更新评论
	public Evaluate queryEvaluate(Evaluate evaluate);//查询评论
	
}
