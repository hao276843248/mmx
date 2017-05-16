


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
// �������
	private DefaultTableModel tableModel =null;//���ģ��
private JScrollPane scpDemo;
private JTableHeader jth;//��ͷ
private JTable tabDemo;
private JButton btnShow;
private JButton btn_add;//��Ӱ�ť
private JButton btn_del;//ɾ����ť
// ���췽��
public Test(){
// �����������ԵĶ���
super("JTable���ݰ�ʾ��");
this.setSize(330,400);
this.setLayout(null);
this.setLocation(100,50);

// �������
this.scpDemo = new JScrollPane();
this.scpDemo.setBounds(10,50,300,270);
this.btnShow = new JButton("��ѯ");
this.btnShow.setBounds(10,10,60,30);
this.btn_add=new JButton("���");//����û�
this.btn_add.setBounds(110,10,60,30);
this.btn_del=new JButton("ɾ��");//����û�
this.btn_del.setBounds(200,10,60,30);


// ����ťע�����
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

// ��������뵽������
add(this.scpDemo);
add(this.btnShow);
add(this.btn_add);
add(this.btn_del);

// ��ʾ����
this.setVisible(true);
}
// �����ťʱ���¼�����


public void btnShow_ActionPerformed(ActionEvent ae){
// ��������������Դ����ʾ���ݵľ��崦��������ע����
try{
// �������
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmxresmis","root","109458");
// ������ѯ����
String sql = "select * from users";
PreparedStatement pstm = conn.prepareStatement(sql);
// ִ�в�ѯ
ResultSet rs = pstm.executeQuery();
// �����ж�������¼
int count = 0;
while(rs.next()){
count++;
}
rs = pstm.executeQuery();
// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
Object[][] info = new Object[count][4];
count = 0;
while(rs.next()){
info[count][0] = Integer.valueOf( rs.getInt("id"));
info[count][1] = rs.getString("Uname");
info[count][2] = Integer.valueOf( rs.getInt("upass") );
info[count][3] = rs.getString("type");
count++;
}
// �����ͷ
String[] title = {"ѧ��","����","����","�Ա�"};
// ����JTable
//this.tabDemo = new JTable(info,title);

tableModel =new DefaultTableModel(info,title);//�����ƶ����������ݵı��
tabDemo=new JTable(tableModel);
//scpDemo=new JScrollPane(tabDemo);//������ʾ���Ĺ������
//getContentPane().add(scpDemo,BorderLayout.CENTER);

// ��ʾ��ͷ
this.jth = this.tabDemo.getTableHeader();
// ��JTable���뵽���������������
this.scpDemo.getViewport().add(tabDemo);
}catch(ClassNotFoundException cnfe){
JOptionPane.showMessageDialog(null,"����Դ����","����",JOptionPane.ERROR_MESSAGE);
}catch(SQLException sqle){
JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
}}






public void btn_del_ActionPerformed(ActionEvent ae){
//		int[] seleteRows=tabDemo.getSelectedRows();	
//		for(int row=0;row<seleteRows.length;row++){
//			tableModel.removeRow(seleteRows[row]- row);			
//	}
	
	try{
		// �������
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmxresmis","root","109458");
		// ������ѯ����
		String sql = "select * from users";
		PreparedStatement pstm = conn.prepareStatement(sql);
		// ִ�в�ѯ
		ResultSet rs = pstm.executeQuery();
		// �����ж�������¼
		int count = 0;
		while(rs.next()){
		count++;
		}
//		rs = pstm.executeQuery();
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		Object[][] info = new Object[count][4];
		count = 0;
		while(rs.next()){
		info[count][0] = Integer.valueOf( rs.getInt("id"));
		info[count][1] = rs.getString("Uname");
		info[count][2] = Integer.valueOf( rs.getInt("upass") );
		info[count][3] = rs.getString("type");
		count++;
		}
		// �����ͷ
		String[] title = {"ѧ��","����","����","�Ա�"};
		// ����JTable
		//this.tabDemo = new JTable(info,title);

		tableModel =new DefaultTableModel(info,title);//�����ƶ����������ݵı��
		tabDemo=new JTable(tableModel);
		//scpDemo=new JScrollPane(tabDemo);//������ʾ���Ĺ������
		//getContentPane().add(scpDemo,BorderLayout.CENTER);
		int[] seleteCount=tabDemo.getSelectedRows();	
		tableModel.removeRow(seleteCount[count]- count);
		// ��ʾ��ͷ
		this.jth = this.tabDemo.getTableHeader();
		// ��JTable���뵽���������������
		this.scpDemo.getViewport().add(tabDemo);
		
		}catch(ClassNotFoundException cnfe){
		JOptionPane.showMessageDialog(null,"����Դ����","����",JOptionPane.ERROR_MESSAGE);
		}catch(SQLException sqle){
		JOptionPane.showMessageDialog(null,"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}}


public static void main(String[] args){
new Test();
}
}
