package mmxresmis.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;

import mmxresmis.biz.ZhuotaiBiz;
import mmxresmis.biz.impl.ZhuotaiBizImpl;
import mmxresmis.entity.Zhuotai;

public class HAdminMainView extends JFrame {
	private static final long serialVersionUID = 7942766018128337161L;
	private JMenuBar mBar = null;// �˵���
	private JPanel panel_left = null;// ���
	private JPanel panel_right = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;
	private JPanel panel5 = null;
	private JPanel panel6 = null;
	private JPanel panel7 = null;
	private JPanel panel8 = null;
	private JPanel panel9 = null;
	private JFrame frame = null;

	private JSplitPane splitPane = null;// �ָ�������

	private JMenu syMenu = null;// ϵͳ��ҳ�˵�
	private JMenu xgMenu = null;// �޸��������˵�
	private JMenu ctMenu = null;// ������Ϣ����˵�
	private JMenu yhMenu = null;// �û���Ϣ����˵�
	private JMenu cpMenu = null;// ��Ʒ��Ϣ����˵�
	private JMenu ddMenu = null;// ������Ϣ����
	private JMenu tcMenu = null;// �˳�

	private JMenuItem syMenuItem = null;
	private JMenuItem xgMenuItem = null;
	private JMenuItem ctMenuItem = null;
	private JMenuItem yhMenuItem = null;
	private JMenuItem foodMenuItem = null;
	private JMenuItem foodtypeMenuItem = null;
	private JMenuItem ddMenuItem = null;
	private JMenuItem tcMenuItem = null;

	private JLabel lb_gonggao = null;
	private JLabel lb_lianxi = null;
	private JLabel lb_tel = null;
	private JLabel lb_addr = null;

	private JPopupMenu popupMenu2;

	private JMenuItem addZT = null;// �����̨
	private List<Zhuotai> zhuotaiList = null;
	private ZhuotaiBiz zhuotaiBiz = new ZhuotaiBizImpl();

	public HAdminMainView() {
		init();
		registerListener();
	}

	private void init() {
		// ��ʼ���˵����
		mBar = new JMenuBar();
		panel_left = new JPanel(new GridLayout(10, 1, 0, 35));
		panel_right = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();

		zhuotaiList = zhuotaiBiz.queryAllZhuotai();
		for (int i = 0; i < zhuotaiList.size(); i++) {
			JPopupMenu popupMenu = new JPopupMenu();
			JMenuItem deleteZT = new JMenuItem("ɾ����̨");
			JMenuItem jibenxinxi = new JMenuItem("��̨������Ϣ");
			
			popupMenu.add(deleteZT);
			popupMenu.add(jibenxinxi);
			JPanel panel7 = new JPanel();
			deleteZT.setEnabled(true);
			jibenxinxi.setEnabled(true);
			JLabel deskLabel = new JLabel();
			if (zhuotaiList.get(i).getZhuotaizt().equals("shiyong")) {
				ImageIcon image1 = new ImageIcon("src/images/a_2.jpg");
				deskLabel.setIcon(image1);
				deskLabel.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
			} else {
				ImageIcon image1 = new ImageIcon("src/images/a_1.jpg");
				deskLabel.setIcon(image1);
				deskLabel.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
			}
			
			
			deskLabel.addMouseListener(caiDan(popupMenu));
			panel7.add(deskLabel);
			panel_right.add(panel7);
			deleteZT.addActionListener(ListenerDeleteZT(zhuotaiList.get(i)));
			jibenxinxi.addActionListener(ListenerJibenxinxi(zhuotaiList.get(i)));
		}

		// ��ʼ��������
		splitPane = new JSplitPane();
		// splitPane.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
		// splitPane.setContinuousLayout(true);//���û������ָ���ʱϵͳ�����»�ͼ��???û��Ӱ��
		splitPane.setDividerSize(10);// ���÷ָ��ߴ�СΪ10����λ ������

		popupMenu2 = new JPopupMenu();

		// ��ʼ���˵�
		syMenu = new JMenu("ϵͳ��ҳ");
		xgMenu = new JMenu("�޸��������");
		ctMenu = new JMenu("������Ϣ����");
		yhMenu = new JMenu("�û���Ϣ����");
		cpMenu = new JMenu("��Ʒ��Ϣ����");
		ddMenu = new JMenu("������Ϣ����");
		tcMenu = new JMenu("�˳�");

		syMenuItem = new JMenuItem("ϵͳ��ҳ");
		xgMenuItem = new JMenuItem("�޸��������");
		ctMenuItem = new JMenuItem("������Ϣ����");
		yhMenuItem = new JMenuItem("�û���Ϣ����");
		foodMenuItem = new JMenuItem("��Ʒ��Ϣ����");
		foodtypeMenuItem = new JMenuItem("��Ʒ������Ϣ����");
		ddMenuItem = new JMenuItem("������Ϣ����");
		tcMenuItem = new JMenuItem("�˳�ϵͳ");

		// ��ʼ����ǩ
		lb_gonggao = new JLabel("����");
		lb_lianxi = new JLabel("��ϵ����");
		lb_lianxi.setFont(new Font("����", Font.BOLD, 20));// ��������
		lb_lianxi.setForeground(Color.red);// ������ɫ
		lb_tel = new JLabel("�绰:15612494925");
		lb_tel.setFont(new Font("����", Font.BOLD, 15));
		lb_addr = new JLabel("��ַ:�ӱ����ʴ�ѧ");
		lb_addr.setFont(new Font("����", Font.BOLD, 15));

		addZT = new JMenuItem("�����̨");


		// �ѿؼ��ӵ���Ӧ��λ����
		syMenu.add(syMenuItem);
		xgMenu.add(xgMenuItem);
		ctMenu.add(ctMenuItem);
		yhMenu.add(yhMenuItem);
		cpMenu.add(foodMenuItem);
		cpMenu.add(foodtypeMenuItem);
		ddMenu.add(ddMenuItem);
		tcMenu.add(tcMenuItem);

		mBar.add(syMenu);
		mBar.add(xgMenu);
		mBar.add(ctMenu);
		mBar.add(yhMenu);
		mBar.add(cpMenu);
		mBar.add(ddMenu);
		mBar.add(tcMenu);

		panel2.add(lb_gonggao);
		panel4.add(lb_lianxi);
		panel5.add(lb_tel);
		panel6.add(lb_addr);

		panel_left.add(panel1);
		panel_left.add(panel2);
		panel_left.add(panel3);
		panel_left.add(panel4);
		panel_left.add(panel5);
		panel_left.add(panel6);
		panel_right.add(panel7);
		panel_right.add(panel8);
		panel_right.add(panel9);

		popupMenu2.add(addZT);

		splitPane.setLeftComponent(panel_left);// ��panel_left�ŵ��ָ�����ߣ�panel_right�ŵ��ұ�
		splitPane.setRightComponent(panel_right);

		this.getContentPane().add(splitPane);
		this.setJMenuBar(mBar);
		this.setSize(1000, 650);
		this.setTitle("��С�Ͳ�������ϵͳ��̨");
		this.setVisible(true);
		this.setResizable(false);// ���ɸı䴰���С
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);// ������ʾ

		splitPane.setDividerLocation(0.3);// ���ұ�����С
		splitPane.setEnabled(false);// �ָ��߲��������ƶ�
	}

	private void registerListener() {
		yhMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HUserManagerView Huserv = new HUserManagerView();
				panel_right.add(Huserv);// ��ָ������ͼ��ӵ�����������
				Huserv.toFront();// ��ͼ��ʾ����ǰ��
			}
		});

		foodMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HFoodManagerView hfview = new HFoodManagerView();
				panel_right.add(hfview);// ��ָ������ͼ��ӵ�����������
				hfview.toFront();// ��ͼ��ʾ����ǰ��
			}
		});

		foodtypeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HFoodtypeManagerView hftview = new HFoodtypeManagerView();
				panel_right.add(hftview);// ��ָ������ͼ��ӵ�����������
				hftview.toFront();// ��ͼ��ʾ����ǰ��
			}
		});

		tcMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "ȷ���˳�?") == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});

		panel_right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �������Ҽ� ��ʾ�Ӳ˵�
				if (e.getButton() == MouseEvent.BUTTON3) {
					// ��ȡ����ڴ��ڵ��߼�λ��
					Point p = e.getPoint();
					popupMenu2.show(e.getComponent(), p.x, p.y);

				}
				// ������ʾ�Ӳ˵�
				else {
					popupMenu2.setVisible(false);
				}
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
	
	
	/***
	 * 
	 * ɾ������
	 * */
	public ActionListener ListenerDeleteZT(Zhuotai zhuotai){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "ȷ��ɾ������̨?") == JOptionPane.YES_OPTION) {
					if("shiyong".equals(zhuotai.getZhuotaizt())){
						JOptionPane.showMessageDialog(null, "����̨����ʹ�ò���ɾ����", "����",JOptionPane.WARNING_MESSAGE);  
					}else{
						zhuotaiBiz.delZhuotai(zhuotai.getZtid());
						//ˢ�½���
					}
					System.out.println(zhuotai);
				}

			}
		};
	}

	/***
	 * ������Ϣ
	 * */
	public ActionListener ListenerJibenxinxi(Zhuotai Zhuotai){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "ȷ��ɾ������̨?") == JOptionPane.YES_OPTION) {
					// System.exit(0); //��������������������������������������
					// int[] seleteRows=deleteZT.getSelectedRows();
				}

			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
