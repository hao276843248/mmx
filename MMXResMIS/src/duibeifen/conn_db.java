package duibeifen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conn_db{
	Connection con;
	String url = null;
	//Statement stmt;
	
	public void connection() throws ClassNotFoundException{

//		url = "jdbc:mysql://localhost:3306/wang?"
//				+ "user=root & password=883883 & useUnicode=true & characterEnunicode=UTF8";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmxresmis","root","109458");
			System.out.println("���ӳɹ�");
			//stmt = con.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
//	public static void main(String[] args) throws ClassNotFoundException {
//		conn_db conn = new conn_db();
//		conn.connection();
//		
//	}
}