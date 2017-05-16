package mmxresmis.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	private static final String driverName = "com.mysql.jdbc.Driver";
	Connection con=null;
	
	
	//�����ݿ�������ӣ��������ݿ����Ӷ���
	public Connection  getConn(){
//		Connection con=null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mmxresmis","root","109458");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//�ͷ�������Դ
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//��ɾ�ķ�װ,����true�� false
	public boolean operUpdate(String sql,List<Object> params){
		int res=0;//Ӱ�������
//		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConn();//�������ݿ�����
			pstmt=con.prepareStatement(sql);//װ��sql���
			if(params!=null){
				//�����У�ռλ������ִ��֮ǰ�ѣ�ռλ��ȥ��
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1,params.get(i) );
				}
			}
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,pstmt,con);
		}
		return res>0? true:false;	
	}
	
	//ʹ�÷��ͷ����ͷ�����ƽ��з�װ
	public <T> List<T> operQuery(String sql,List<Object> params,Class<T> cls)
	        throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<T> data =new ArrayList<T>();
		try {
			
			con=getConn();//�������ݿ�����
			pstmt=con.prepareStatement(sql);//װ��sql���
			if(params!=null){
				//�����У�ռλ������ִ��֮ǰ�ѣ�ռλ��ȥ��
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1,params.get(i) );
				}
			}
			rs=pstmt.executeQuery();
			//�Ѳ�ѯ�����ļ�¼��װ�ɶ�Ӧ��ʵ�������
			ResultSetMetaData rsd=rs.getMetaData();//�õ���¼��Ԫ���ݶ���
			//ͨ���˶�����Եõ���Ľṹ�������������еĸ������е���������
			while(rs.next()){
				T m=cls.newInstance();
				for(int i=0;i<rsd.getColumnCount();i++){
					String col_name=rsd.getColumnName(i+1);//�������
					Object value=rs.getObject(col_name);//���������Ӧ��ֵ
					Field field=cls.getDeclaredField(col_name);//����
					field.setAccessible(true);// ��˽���������ÿɷ���Ȩ
					field.set(m, value);//�������˽�����Ը�ֵ	
				}
				data.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(rs,pstmt,con);
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
