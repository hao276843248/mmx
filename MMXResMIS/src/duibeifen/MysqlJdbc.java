package duibeifen;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class MysqlJdbc {
public static void main(String args[]) {
try {
      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
//Class.forName("org.gjt.mm.mysql.Driver");
     System.out.println("Success loading Mysql Driver!");
    }
catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
try {
      java.sql.Connection connect = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/aaa","root","109458");
//����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

      System.out.println("Success connect Mysql server!");
      java.sql.Statement stmt = connect.createStatement();
      ResultSet rs = stmt.executeQuery("select * from user");
//user Ϊ��������
while (rs.next()) {
        System.out.println(rs.getString("name"));
      }
    }
catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }
}
