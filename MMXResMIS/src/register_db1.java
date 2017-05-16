import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class register_db1 extends conn_db implements ActionListener{

	JTextField textacc,textname;
	private JButton btn_confirm=null;//ȷ�ϰ�ť
	private JButton btn_back=null;//���ذ�ť
	Statement stmt;
	ResultSet rs;
//	double acc;
//	String name;
//	Connection con = null;
	
	public void setaccountField(JTextField a){
		textacc = a;
	}
	public void setnameField(JTextField n){
		textname = n;
	}
	public void setokButton(JButton b1){
		btn_confirm = b1;
	}
	public void setresetButton(JButton b2){
		btn_back = b2;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btn_confirm){
			if(textacc.getText().equals(""))			//�ж��û������Ƿ�Ϊ�գ�
				JOptionPane.showMessageDialog(null, "�������˺�","����Ի���",JOptionPane.WARNING_MESSAGE);
			else if(textname.getText().equals(""))
				JOptionPane.showMessageDialog(null,"����������","����Ի���",JOptionPane.WARNING_MESSAGE);
			else{
				String acc = textacc.getText();
				String name = textname.getText();
				try {
					connection();
					writeInSql(acc,name);
				} catch (Exception e1) {
					System.out.println("����ʧ��");
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == btn_back){
			textacc.setText("");
			textname.setText("");
		}
	}
	
	void writeInSql(String acc,String name) throws Exception{
		String sql;
		
		Connection con = super.con;
		Statement stmt = con.createStatement();
		
		//������������ݿ����û��"my"���򴴽���ִ�в�������������Ѵ��ڣ���ֱ��ִ�в�������������
		sql = "create table if not exists users(uname varchar(255),upass varchar(255),type int(11))";
		
		stmt.executeUpdate(sql);
//		System.out.println(sql);		//���
		System.out.println("������ɹ�");	
		
		//������ı����л�ȡ�����ݣ�
		sql = "insert into my(account,name) values('"+acc+"','"+name+"')";
		int rw = stmt.executeUpdate(sql);
//		System.out.println(sql);
		if(rw <= 0){				//�ж������Ƿ����ɹ�
			JOptionPane.showMessageDialog(null,"ע��ʧ��");
		}
		else{
			JOptionPane.showMessageDialog(null, "ע��ɹ�");
		}
	}
}
