package qita;


import java.sql.*;  
public class ConnectSQL2005 {  
public static void main(String[] args)throws Exception{  
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();   
   String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tempdb";//数据库名需要自定义  
   String user="mmx"; //用户需要自定义  
   String password="123456"; //密码需要自定义  
   Connection conn= DriverManager.getConnection(url,user,password);  
   Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);     
   String sql="select * from Student";//SQL查询语句需要自定义  
   ResultSet rs=stmt.executeQuery(sql);     
   while(rs.next()) {     
    System.out.println("您的第一个字段内容为："+rs.getString(1));  
    System.out.println("您的第二个字段内容为："+rs.getString(2));  
   }   
   System.out.print("数据库操作成功，恭喜你");     
   rs.close();     
   stmt.close();     
   conn.close();     
}  
} 
