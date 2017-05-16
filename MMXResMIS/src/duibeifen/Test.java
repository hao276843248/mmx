package duibeifen;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Test extends JFrame {
	// �������
	private JScrollPane scpDemo;
	private JTableHeader jth;// ��ͷ
	private JTable tabDemo;
	private JButton btnShow;

	// ���췽��
	public Test() {
		// �����������ԵĶ���
		super("JTable���ݰ�ʾ��");
		this.setSize(330, 400);
		this.setLayout(null);
		this.setLocation(100, 50);
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(10, 50, 300, 270);
		this.btnShow = new JButton("��ʾ����");
		this.btnShow.setBounds(10, 10, 300, 30);
		// ����ťע�����
		this.btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btnShow_ActionPerformed(ae);
			}
		});
		// ��������뵽������
		add(this.scpDemo);
		add(this.btnShow);
		// ��ʾ����
		this.setVisible(true);
	}

	// �����ťʱ���¼�����
	public void btnShow_ActionPerformed(ActionEvent ae) {
		// ��������������Դ����ʾ���ݵľ��崦��������ע����
		try {
			// �������
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mmxresmis", "root", "123");
			// ������ѯ����
			String sql = "select * from users";
			PreparedStatement pstm = conn.prepareStatement(sql);
			// ִ�в�ѯ
			ResultSet rs = pstm.executeQuery();
			// �����ж�������¼
			int count = 0;
			while (rs.next()) {
				count++;
			}
			rs = pstm.executeQuery();
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			Object[][] info = new Object[count][4];
			count = 0;
			while (rs.next()) {
				info[count][0] = Integer.valueOf(rs.getInt("id"));
				info[count][1] = rs.getString("Uname");
				info[count][2] = rs.getString("upass");
				info[count][3] =  Integer.valueOf(rs.getInt("type"));
				count++;
			}
			// �����ͷ
			String[] title = { "ѧ��", "����", "����", "�Ա�" };
			// ����JTable
			this.tabDemo = new JTable(info, title);
			// ��ʾ��ͷ
			this.jth = this.tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			this.scpDemo.getViewport().add(tabDemo);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			JOptionPane.showMessageDialog(null, "����Դ����", "����", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			JOptionPane.showMessageDialog(null, "���ݲ�������", "����", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new Test();
	}
}
