package mmxresmis.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mmxresmis.biz.ZhuotaiBiz;
import mmxresmis.biz.impl.ZhuotaiBizImpl;
import mmxresmis.entity.Zhuotai;

public class KaitaiView extends JInternalFrame {
	private static final long serialVersionUID = -8546047454814393569L;
	private JPanel panel_main = null;// �����
	private JPanel panel_left = null;// ������
	private JPanel panel_right = null;// �Ҳ����

	private JLabel lb_zhuotainum = null;// ��̨�ű�ǩ
	private JLabel lb_guestname = null;// �˿���
	private JLabel lb_zhangdandate = null;// �˵�����
	private JLabel lb_gsum = null;// �Ͳ�����
	private JLabel lb_wnum = null;// ����Ա��
	private JLabel lb_beizhu = null;// ��ע

	private JTextField tf_zhuotainame = null;// ��̨�ı���
	private JTextField tf_guestname = null;
	private JTextField tf_zhangdandate = null;
	private JTextField tf_gnum = null;
	private JTextField tf_beizhu = null;

	private JButton btn_confirm = null;// ȷ����ť
	private JButton btn_cancel = null;// ȡ����ť

	private JComboBox<String> cb_wnum = null;// ����Ա�������б��
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public ZhuotaiBiz zhuotaiBizImpl=new ZhuotaiBizImpl();
	private Zhuotai zhuotai=null;
	private UserMainView u=null;
	
	public KaitaiView(Zhuotai zhuotai) {
		this.zhuotai=zhuotai;
		init();// ���췽�����ã��������¼���ڶ���ʱ����ʼ����Ӧ�Ŀؼ����Դﵽ��ʾ�����Ч��
		registerListener();
	}
	

	// ��ʼ������ؼ��ķ���
	private void init() {
		this.setSize(560, 280);// ���ô����С
		this.setResizable(false);// �����϶������С
		this.setClosable(true);//����ɱ��ر�
	    this.setIconifiable(true);//JInternalFrame��Ƕ���壬�������С��
		// this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("��̨����");// ���ñ���
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �˳��رմ��幦��

		// ��ʼ�����
		panel_main = new JPanel(new GridLayout(1, 2));// �����һ�����еı��
		panel_left = new JPanel(new GridLayout(4, 2, 0, 10));
		panel_right = new JPanel(new GridLayout(4, 2, 0, 10));// �������������ˮƽ��ֱ���

		// ��ʼ���ؼ�
		tf_zhuotainame = new JTextField(zhuotai.getZhuotainum());// ����8
		tf_zhuotainame.setEditable(false);
		tf_guestname = new JTextField(8);
		tf_zhangdandate = new JTextField(formatter.format(new Date()));
		tf_zhangdandate.setEditable(false);
		tf_gnum = new JTextField(8);
		cb_wnum = new JComboBox<String>(new String[] { "001", "002", "003", "004", "005", "006", "007" });
		tf_beizhu = new JTextField(8);

		btn_confirm = new JButton("ȷ��");
		btn_cancel = new JButton("ȡ��");

		lb_zhuotainum = new JLabel("��̨��", JLabel.CENTER);
		lb_guestname = new JLabel("�˿���", JLabel.CENTER);
		lb_zhangdandate = new JLabel("�˵�����", JLabel.CENTER);
		lb_gsum = new JLabel("�Ͳ�����", JLabel.CENTER);
		lb_wnum = new JLabel("����Ա��", JLabel.CENTER);
		lb_beizhu = new JLabel("�� ע", JLabel.CENTER);

		// ����Ӧ�Ŀؼ��ŵ������ȥ
		panel_left.add(lb_zhuotainum);// 1
		panel_left.add(tf_zhuotainame);
		panel_right.add(lb_guestname); // 2
		panel_right.add(tf_guestname);
		panel_left.add(lb_zhangdandate);// 3
		panel_left.add(tf_zhangdandate);
		panel_right.add(lb_gsum);// 4
		panel_right.add(tf_gnum);
		panel_left.add(lb_wnum);// 5
		panel_left.add(cb_wnum);
		panel_right.add(lb_beizhu);// 6
		panel_right.add(tf_beizhu);

		panel_left.add(btn_confirm);
		panel_right.add(btn_cancel);

		  
		// ������з������������
		panel_main.add(panel_left);
		panel_main.add(panel_right);

		// �ٰ������ŵ�������
		this.getContentPane().add(panel_main);// �������
		this.pack();// ��������
		this.setVisible(true);// ��ʾ����
		
	}
	/**
	 * �رմ��� 
	 * **/
	private void close(){
		this.dispose();
	}
	private void registerListener() {
		btn_confirm.addActionListener(new ActionListener() {
			@Override // �����д
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�û���������
				String guestname = tf_guestname.getText();
				String zhangdandate = tf_zhangdandate.getText();
				String num = tf_gnum.getText().trim();
				int wnum = cb_wnum.getSelectedIndex();
				String zhuotaiBZ = tf_beizhu.getText();
				if (tf_guestname.equals("")) {
					JOptionPane.showMessageDialog(KaitaiView.this, "�˿�������Ϊ��"); // JOptionPane��Ϣ��
																				// ,������LoginView
					return;
				}else if (lb_gsum.equals("")) {
					JOptionPane.showMessageDialog(KaitaiView.this, "�Ͳ���������Ϊ��");
					return;
				}else{
					zhuotai.setGuestname(guestname);
					zhuotai.setZhangdandate(zhangdandate);
					zhuotai.setNum(Integer.valueOf(num));
					zhuotai.setZhuotaizt("shiyong");
					zhuotai.setWname(wnum+"");
					zhuotai.setZhuotaibz(zhuotaiBZ);
					zhuotaiBizImpl.updateZhuotai(zhuotai);
				}
				close();
				UserMainView a=new UserMainView(null);
				a.shuaxin();
				// User user =new User(uname,upass,type);//��װ��User���� ��û�е����
				// user = userBiz.login(user);//����ҵ��㷽�� ,�鿴�ȶ���û�д��û�
			}
		});
		
		btn_cancel.addActionListener(new ActionListener() {
			@Override // �����д
			public void actionPerformed(ActionEvent e) {
				UserMainView a=new UserMainView(null);
				close();
				a.shuaxin();
			}
			
		});
	}
	

}
