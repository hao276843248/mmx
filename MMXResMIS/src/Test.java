


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class Test extends JFrame{
// 定义组件
	private DefaultTableModel tableModel =null;//表格模型
private JScrollPane scpDemo;
private JTableHeader jth;//表头
private JTable tabDemo;
private JButton btnShow;
private JButton btn_add;//添加按钮
private JButton btn_del;//删除按钮
// 构造方法
public Test(){
// 窗体的相关属性的定义
super("JTable数据绑定示例");
this.setSize(330,400);
this.setLayout(null);
this.setLocation(100,50);

// 创建组件
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,300,270);
this.btnShow = new JButton("查询");
this.btnShow.setBounds(10,10,60,30);
this.btn_add=new JButton("添加");//添加用户
this.btn_add.setBounds(110,10,60,30);
this.btn_del=new JButton("删除");//添加用户
this.btn_del.setBounds(200,10,60,30);


// 给按钮注册监听
this.btnShow.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
btnShow_ActionPerformed(ae);
}
});
//this.btn_add.addActionListener(new ActionListener(){
//public void actionPerformed(ActionEvent ae){
//btn_add_ActionPerformed(ae);
//}
//});
this.btn_del.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
btn_del_ActionPerformed(ae);
}
});

// 将组件加入到窗体中
add(this.scpDemo);
add(this.btnShow);
add(this.btn_add);
add(this.btn_del);

// 显示窗体
this.setVisible(true);
}
// 点击按钮时的事件处理


public void btnShow_ActionPerformed(ActionEvent ae){
// 以下是连接数据源和显示数据的具体处理方法，请注意下
try{
// 获得连接
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmxresmis","root","109458");
// 建立查询条件
String sql = "select * from users";
PreparedStatement pstm = conn.prepareStatement(sql);
// 执行查询
ResultSet rs = pstm.executeQuery();
// 计算有多少条记录
int count = 0;
while(rs.next()){
count++;
}
rs = pstm.executeQuery();
// 将查询获得的记录数据，转换成适合生成JTable的数据形式
Object[][] info = new Object[count][4];
count = 0;
while(rs.next()){
info[count][0] = Integer.valueOf( rs.getInt("id"));
info[count][1] = rs.getString("Uname");
info[count][2] = Integer.valueOf( rs.getInt("upass") );
info[count][3] = rs.getString("type");
count++;
}
// 定义表头
String[] title = {"学号","姓名","年龄","性别"};
// 创建JTable
//this.tabDemo = new JTable(info,title);

tableModel =new DefaultTableModel(info,title);//创建制定列名和数据的表格
tabDemo=new JTable(tableModel);
//scpDemo=new JScrollPane(tabDemo);//创建显示表格的滚动面板
//getContentPane().add(scpDemo,BorderLayout.CENTER);

// 显示表头
this.jth = this.tabDemo.getTableHeader();
// 将JTable加入到带滚动条的面板中
this.scpDemo.getViewport().add(tabDemo);
}catch(ClassNotFoundException cnfe){
JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
}catch(SQLException sqle){
JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
}}






public void btn_del_ActionPerformed(ActionEvent ae){
//		int[] seleteRows=tabDemo.getSelectedRows();	
//		for(int row=0;row<seleteRows.length;row++){
//			tableModel.removeRow(seleteRows[row]- row);			
//	}
	
	try{
		// 获得连接
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmxresmis","root","109458");
		// 建立查询条件
		String sql = "select * from users";
		PreparedStatement pstm = conn.prepareStatement(sql);
		// 执行查询
		ResultSet rs = pstm.executeQuery();
		// 计算有多少条记录
		int count = 0;
		while(rs.next()){
		count++;
		}
//		rs = pstm.executeQuery();
		// 将查询获得的记录数据，转换成适合生成JTable的数据形式
		Object[][] info = new Object[count][4];
		count = 0;
		while(rs.next()){
		info[count][0] = Integer.valueOf( rs.getInt("id"));
		info[count][1] = rs.getString("Uname");
		info[count][2] = Integer.valueOf( rs.getInt("upass") );
		info[count][3] = rs.getString("type");
		count++;
		}
		// 定义表头
		String[] title = {"学号","姓名","年龄","性别"};
		// 创建JTable
		//this.tabDemo = new JTable(info,title);

		tableModel =new DefaultTableModel(info,title);//创建制定列名和数据的表格
		tabDemo=new JTable(tableModel);
		//scpDemo=new JScrollPane(tabDemo);//创建显示表格的滚动面板
		//getContentPane().add(scpDemo,BorderLayout.CENTER);
		int[] seleteCount=tabDemo.getSelectedRows();	
		tableModel.removeRow(seleteCount[count]- count);
		// 显示表头
		this.jth = this.tabDemo.getTableHeader();
		// 将JTable加入到带滚动条的面板中
		this.scpDemo.getViewport().add(tabDemo);
		
		}catch(ClassNotFoundException cnfe){
		JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
		}catch(SQLException sqle){
		JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}}


public static void main(String[] args){
new Test();
}
}
