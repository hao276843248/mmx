package mmxresmis.dao;

import mmxresmis.entity.Evaluate;


public interface EvaluateDao {
	public boolean saveEvaluate(Evaluate evaluate);//�������
	public boolean updateEvaluate(Evaluate evaluate);//��������
	public Evaluate queryEvaluate(Evaluate evaluate);//��ѯ����
	
}
