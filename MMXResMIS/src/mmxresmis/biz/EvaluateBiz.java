package mmxresmis.biz;

import mmxresmis.entity.Evaluate;

public interface EvaluateBiz {
	public boolean addEvaluate(Evaluate evaluate);//添加评论
	public boolean updateEvaluate(Evaluate evaluate);//更新评论
	public Evaluate queryEvaluate(Evaluate evaluate);//查询评论
}
