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
	
	
	//与数据库家里连接，返回数据库连接对象
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
	
	//释放所有资源
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
	
	//增删改封装,返回true或 false
	public boolean operUpdate(String sql,List<Object> params){
		int res=0;//影响的行数
//		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConn();//建立数据库连接
			pstmt=con.prepareStatement(sql);//装载sql语句
			if(params!=null){
				//假如有？占位符，在执行之前把？占位符去掉
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
	
	//使用泛型方法和反射机制进行封装
	public <T> List<T> operQuery(String sql,List<Object> params,Class<T> cls)
	        throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<T> data =new ArrayList<T>();
		try {
			
			con=getConn();//建立数据库连接
			pstmt=con.prepareStatement(sql);//装载sql语句
			if(params!=null){
				//假如有？占位符，在执行之前把？占位符去掉
				for(int i=0;i<params.size();i++){
					pstmt.setObject(i+1,params.get(i) );
				}
			}
			rs=pstmt.executeQuery();
			//把查询出来的记录封装成对应的实体类对象
			ResultSetMetaData rsd=rs.getMetaData();//得到记录集元数据对象，
			//通过此对象可以得到表的结构，包括列名，列的个数，列的数据类型
			while(rs.next()){
				T m=cls.newInstance();
				for(int i=0;i<rsd.getColumnCount();i++){
					String col_name=rsd.getColumnName(i+1);//获得列名
					Object value=rs.getObject(col_name);//获得列所对应的值
					Field field=cls.getDeclaredField(col_name);//属性
					field.setAccessible(true);// 给私有属性设置可访问权
					field.set(m, value);//给对象的私有属性赋值	
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
