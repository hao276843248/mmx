package mmxresmis.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;

import mmxresmis.biz.ZhuotaiBiz;
import mmxresmis.biz.impl.ZhuotaiBizImpl;
import mmxresmis.entity.Zhuotai;

public class UserMainView extends JFrame {
	private static final long serialVersionUID = -140364745910693543L;
	private JMenuBar mBar = null;// �˵���
	private JPanel panel_left = null;// ���
	private JPanel panel_right = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;
	private JPanel panel5 = null;
	private JPanel panel6 = null;

	private JSplitPane splitPane = null;// �ָ�������

	private JMenu syMenu = null;// ϵͳ��ҳ�˵�
	private JMenu yzMenu = null;// �û�ע��
	private JMenu wdMenu = null;// �ҵĶ���
	private JMenu bzMenu = null;// ����
	private JMenu tcMenu = null;// �˳�

	private JMenuItem syMenuItem = null;
	private JMenuItem yzMenuItem = null;
	private JMenuItem ddMenuItem = null;
	private JMenuItem bzMenuItem = null;
	private JMenuItem tcMenuItem = null;

	private JLabel lb_gonggao = null;
	private JLabel lb_lianxi = null;
	private JLabel lb_tel = null;
	private JLabel lb_addr = null;

	private ZhuotaiBiz zhuoTaiBiz = new ZhuotaiBizImpl();
	private List<Zhuotai> zhuotaiList = new ArrayList<>();

	public UserMainView() {
		init();
		registerListener();
	}

	public UserMainView(String a) {

	}

	private void init() {
		// ��ѯ������̨��Ϣ
		zhuotaiList = zhuoTaiBiz.queryAllZhuotai();
		// ��ʼ���˵����
		mBar = new JMenuBar();
		panel_left = new JPanel(new GridLayout(10, 1, 0, 35));
		panel_right = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();

		for (int i = 0; i < zhuotaiList.size(); i++) {
			JPopupMenu popupMenu = new JPopupMenu();
			JMenuItem kaitai = new JMenuItem("��̨");
			JMenuItem cancelkaitai = new JMenuItem("ȡ����̨");
			JMenuItem orderitem = new JMenuItem("��/�Ӳ�");
			JMenuItem xiaofeichaxun = new JMenuItem("���Ѳ�ѯ");
			JMenuItem jiezhang = new JMenuItem("����");

			popupMenu.add(kaitai);
			popupMenu.add(cancelkaitai);
			popupMenu.add(orderitem);
			popupMenu.add(xiaofeichaxun);
			popupMenu.add(jiezhang);
			JPanel panel7 = new JPanel();
			JLabel deskLabel = new JLabel();
			ImageIcon image1=null;
			if (zhuotaiList.get(i).getZhuotaizt().equals("shiyong")) {
				image1 = new ImageIcon("src/images/a_2.jpg");
				kaitai.setEnabled(false);
				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(true);
				xiaofeichaxun.setEnabled(true);
				jiezhang.setEnabled(true);
			} else {
				image1 = new ImageIcon("src/images/a_1.jpg");
				deskLabel.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
				deskLabel.addMouseListener(caiDan(popupMenu));
				panel7.add(deskLabel);
				panel_right.add(panel7);
				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(false);
				xiaofeichaxun.setEnabled(false);
				jiezhang.setEnabled(false);
			}
			
			deskLabel.setIcon(image1);
			deskLabel.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
			deskLabel.addMouseListener(caiDan(popupMenu));
			panel7.add(deskLabel);
			panel_right.add(panel7);
			
			kaitai.addActionListener(
					ListenerKaitai(zhuotaiList.get(i), kaitai, cancelkaitai, orderitem, xiaofeichaxun, jiezhang));
			cancelkaitai.addActionListener(ListenerCancelkaitai(zhuotaiList.get(i).getZtid(), kaitai, cancelkaitai,
					orderitem, xiaofeichaxun, jiezhang));
			orderitem.addActionListener(ListenerOrderitem(zhuotaiList.get(i), kaitai, cancelkaitai,
					orderitem, xiaofeichaxun, jiezhang));
			xiaofeichaxun.addActionListener(ListenerXiaofeichaxun(zhuotaiList.get(i).getZtid(), kaitai,
					cancelkaitai, orderitem, xiaofeichaxun, jiezhang));
			jiezhang.addActionListener(ListenerJiezhang(zhuotaiList.get(i), kaitai, cancelkaitai,
					orderitem, xiaofeichaxun, jiezhang));
		}

		// ��ʼ��������
		splitPane = new JSplitPane();
		// splitPane.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
		// splitPane.setContinuousLayout(true);//���û������ָ���ʱϵͳ�����»�ͼ��???û��Ӱ��
		splitPane.setDividerSize(10);// ���÷ָ��ߴ�СΪ10����λ ������

		// ��ʼ���˵�
		syMenu = new JMenu("ϵͳ��ҳ");
		yzMenu = new JMenu("�û�ע��");
		wdMenu = new JMenu("�ҵĶ���");
		bzMenu = new JMenu("����");
		tcMenu = new JMenu("�˳�");

		syMenuItem = new JMenuItem("ϵͳ��ҳ");
		yzMenuItem = new JMenuItem("�û�ע��");
		ddMenuItem = new JMenuItem("��������");
		bzMenuItem = new JMenuItem("��������");
		tcMenuItem = new JMenuItem("�˳�ϵͳ");

		// ��ʼ����ǩ
		lb_gonggao = new JLabel("����");
		lb_lianxi = new JLabel("��ϵ����");
		lb_lianxi.setFont(new Font("����", Font.BOLD, 20));// ��������
		lb_lianxi.setForeground(Color.red);// ������ɫ
		// lb_tel=new JLabel("�绰:15612494925");
		lb_tel = new JLabel();
		lb_tel.setFont(new Font("����", Font.BOLD, 15));
		lb_addr = new JLabel("��ַ:�ӱ����ʴ�ѧ");
		lb_addr.setFont(new Font("����", Font.BOLD, 15));

		// �ѿؼ��ӵ���Ӧ��λ����
		syMenu.add(syMenuItem);
		yzMenu.add(yzMenuItem);
		wdMenu.add(ddMenuItem);
		bzMenu.add(bzMenuItem);
		tcMenu.add(tcMenuItem);

		mBar.add(syMenu);
		mBar.add(yzMenu);
		mBar.add(wdMenu);
		mBar.add(bzMenu);
		mBar.add(tcMenu);

		panel2.add(lb_gonggao);
		panel4.add(lb_lianxi);
		panel5.add(lb_tel);
		panel6.add(lb_addr);

		panel_left.add(panel2);
		panel_left.add(panel3);
		panel_left.add(panel4);
		panel_left.add(panel5);
		panel_left.add(panel6);

		splitPane.setLeftComponent(panel_left);// ��panel_left�ŵ��ָ�����ߣ�panel_right�ŵ��ұ�
		splitPane.setRightComponent(panel_right);
		splitPane.setDividerLocation(0.3);// ���ұ�����С
		splitPane.setEnabled(false);// �ָ��߲��������ƶ�

		this.getContentPane().add(splitPane);
		this.setJMenuBar(mBar);
		this.setSize(1000, 650);
		this.setTitle("��С�Ͳ�������ϵͳ");
		this.setVisible(true);
		this.setResizable(false);// ���ɸı䴰���С
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);// ������ʾ

	}

	private void registerListener() {
		yzMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRegisterView urv = new UserRegisterView();
				panel_right.add(urv);// ��ָ������ͼ��ӵ�����������
				urv.toFront();// ��ͼ��ʾ����ǰ��
			}

		});
	}

	/**
	 * �˵�
	 * 
	 **/
	public MouseAdapter caiDan(JPopupMenu popupMenu) {
		MouseAdapter a = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// �������Ҽ� ��ʾ�Ӳ˵�
				if (e.getButton() == MouseEvent.BUTTON3) {
					// ��ȡ����ڴ��ڵ��߼�λ��
					Point p = e.getPoint();
					popupMenu.show(e.getComponent(), p.x, p.y);
				}
				// ������ʾ�Ӳ˵�
				else {
					popupMenu.setVisible(false);
				}
			}
		};
		return a;
	}

	/**
	 * ����
	 * 
	 **/
	public ActionListener ListenerKaitai(Zhuotai zhuotai, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KaitaiView ktv = new KaitaiView(zhuotai);
				// panel_right.add(ktv);//��ָ������ͼ��ӵ�����������
				ktv.toFront();// ��ͼ��ʾ����ǰ��
				kaitai.setEnabled(false);
				cancelkaitai.setEnabled(true);
				orderitem.setEnabled(true);
				xiaofeichaxun.setEnabled(false);
				jiezhang.setEnabled(false);
			}
		};
		return lis;
	}

	/**
	 * ȡ������
	 * 
	 **/
	public ActionListener ListenerCancelkaitai(int id, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				kaitai.setEnabled(true);
				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(false);
				xiaofeichaxun.setEnabled(false);
				jiezhang.setEnabled(false);
				shuaxin();
			}
		};
		return lis;
	}

	/**
	 * ��/�Ӳ�
	 * 
	 **/
	public ActionListener ListenerOrderitem(Zhuotai zhuotai, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Order_itemView oim = new Order_itemView(zhuotai);
				panel_right.add(oim);// ��ָ������ͼ��ӵ�����������
				oim.toFront();// ��ͼ��ʾ����ǰ��
				kaitai.setEnabled(false);
				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(true);
				xiaofeichaxun.setEnabled(true);
				jiezhang.setEnabled(true);
			}
		};
		return lis;
	}

	/**
	 * �������
	 * 
	 **/

	public ActionListener ListenerXiaofeichaxun(int id, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HZhuotaiManagerView hz=new HZhuotaiManagerView();
//				Order_itemView oim = new Order_itemView();
				// panel_right.add(oim);//��ָ������ͼ��ӵ�����������
				hz.toFront();// ��ͼ��ʾ����ǰ��
				kaitai.setEnabled(false);
				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(true);
				xiaofeichaxun.setEnabled(true);
				jiezhang.setEnabled(true);
			}
		};
		return lis;
	}

	/**
	 * ����
	 * 
	 **/
	public ActionListener ListenerJiezhang(Zhuotai zhuotai, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JiezhangView jzv = new JiezhangView(zhuotai);
				// panel_right.add(jzv);//��ָ������ͼ��ӵ�����������
				jzv.toFront();// ��ͼ��ʾ����ǰ��
				kaitai.setEnabled(true);
				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(false);
				xiaofeichaxun.setEnabled(false);
				jiezhang.setEnabled(false);
			}
		};
		return lis;
	}

	public void shuaxin() {
		this.dispose();
		new UserMainView();
	}

}
