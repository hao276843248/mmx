package qita;


import java.sql.*;  
public class ConnectSQL2005 {  
public static void main(String[] args)throws Exception{  
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();   
   String url = "jdbc:sqlserver://localhost:1433;DatabaseName=tempdb";//���ݿ�����Ҫ�Զ���  
   String user="mmx"; //�û���Ҫ�Զ���  
   String password="123456"; //������Ҫ�Զ���  
   Connection conn= DriverManager.getConnection(url,user,password);  
   Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);     
   String sql="select * from Student";//SQL��ѯ�����Ҫ�Զ���  
   ResultSet rs=stmt.executeQuery(sql);     
   while(rs.next()) {     
    System.out.println("���ĵ�һ���ֶ�����Ϊ��"+rs.getString(1));  
    System.out.println("���ĵڶ����ֶ�����Ϊ��"+rs.getString(2));  
   }   
   System.out.print("���ݿ�����ɹ�����ϲ��");     
   rs.close();     
   stmt.close();     
   conn.close();     
}  
} 
