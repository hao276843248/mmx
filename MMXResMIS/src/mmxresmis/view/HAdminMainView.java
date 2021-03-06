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
	private JMenuBar mBar = null;// 菜单条
	private JPanel panel_left = null;// 面板
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

	private JSplitPane splitPane = null;// 分割容器类

	private JMenu syMenu = null;// 系统首页菜单
	private JMenu xgMenu = null;// 修改密码管理菜单
	private JMenu waiterMenu = null;// 服务员信息管理菜单
	private JMenu yhMenu = null;// 用户信息管理菜单
	private JMenu cpMenu = null;// 菜品信息管理菜单
	private JMenu ddMenu = null;// 订单信息管理
	private JMenu tcMenu = null;// 退出

	private JMenuItem syMenuItem = null;
	private JMenuItem xgMenuItem = null;
	private JMenuItem waiterMenuItem = null;
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

	private JMenuItem addZT = null;// 添加桌台
	private List<Zhuotai> zhuotaiList = null;
	private ZhuotaiBiz zhuotaiBiz = new ZhuotaiBizImpl();

	public HAdminMainView() {
		init();
		registerListener();
	}

	private void init() {
		// 初始化菜单面板
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
			JMenuItem deleteZT = new JMenuItem("删除桌台");
			JMenuItem jibenxinxi = new JMenuItem("桌台基本信息");
			
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

		// 初始化滚动条
		splitPane = new JSplitPane();
		// splitPane.setOneTouchExpandable(true);//让分割线显示出箭头
		// splitPane.setContinuousLayout(true);//当用户操作分割线时系统会重新绘图形???没有影响
		splitPane.setDividerSize(10);// 设置分隔线大小为10个单位 ？？？

		popupMenu2 = new JPopupMenu();

		// 初始化菜单
		syMenu = new JMenu("系统首页");
		xgMenu = new JMenu("修改密码管理");
		waiterMenu = new JMenu("服务员信息管理");
		yhMenu = new JMenu("用户信息管理");
		cpMenu = new JMenu("菜品信息管理");
		ddMenu = new JMenu("订单信息管理");
		tcMenu = new JMenu("退出");

		syMenuItem = new JMenuItem("系统首页");
		xgMenuItem = new JMenuItem("修改密码管理");
		waiterMenuItem = new JMenuItem("服务员信息管理");
		yhMenuItem = new JMenuItem("用户信息管理");
		foodMenuItem = new JMenuItem("菜品信息管理");
		foodtypeMenuItem = new JMenuItem("菜品类型信息管理");
		ddMenuItem = new JMenuItem("订单信息管理");
		tcMenuItem = new JMenuItem("退出系统");

		// 初始化标签
		lb_gonggao = new JLabel("公告");
		lb_lianxi = new JLabel("联系我们");
		lb_lianxi.setFont(new Font("宋体", Font.BOLD, 20));// 设置字体
		lb_lianxi.setForeground(Color.red);// 设置颜色
		lb_tel = new JLabel("电话:15612494925");
		lb_tel.setFont(new Font("宋体", Font.BOLD, 15));
		lb_addr = new JLabel("地址:河北地质大学");
		lb_addr.setFont(new Font("宋体", Font.BOLD, 15));

		addZT = new JMenuItem("添加桌台");


		// 把控件加到相应的位置上
		syMenu.add(syMenuItem);
		xgMenu.add(xgMenuItem);
		waiterMenu.add(waiterMenuItem);
		yhMenu.add(yhMenuItem);
		cpMenu.add(foodMenuItem);
		cpMenu.add(foodtypeMenuItem);
		ddMenu.add(ddMenuItem);
		tcMenu.add(tcMenuItem);

		mBar.add(syMenu);
		mBar.add(xgMenu);
		mBar.add(waiterMenu);
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

		splitPane.setLeftComponent(panel_left);// 将panel_left放到分割线左边，panel_right放到右边
		splitPane.setRightComponent(panel_right);

		this.getContentPane().add(splitPane);
		this.setJMenuBar(mBar);
		this.setSize(1000, 650);
		this.setTitle("中小型餐饮管理系统后台");
		this.setVisible(true);
		this.setResizable(false);// 不可改变窗体大小
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);// 居中显示

		splitPane.setDividerLocation(0.3);// 左右比例大小
		splitPane.setEnabled(false);// 分割线不可左右移动
	}

	private void registerListener() {
		waiterMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HWaiterManagerView Hwaiterv = new HWaiterManagerView();
				panel_right.add(Hwaiterv);// 把指定的视图添加到桌面容器中
				Hwaiterv.toFront();// 视图显示在最前面
			}
		});
		
		yhMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HUserManagerView Huserv = new HUserManagerView();
				panel_right.add(Huserv);// 把指定的视图添加到桌面容器中
				Huserv.toFront();// 视图显示在最前面
			}
		});

		foodMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HFoodManagerView hfview = new HFoodManagerView();
				panel_right.add(hfview);// 把指定的视图添加到桌面容器中
				hfview.toFront();// 视图显示在最前面
			}
		});

		foodtypeMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HFoodtypeManagerView hftview = new HFoodtypeManagerView();
				panel_right.add(hftview);// 把指定的视图添加到桌面容器中
				hftview.toFront();// 视图显示在最前面
			}
		});

		tcMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "确认退出?") == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		
	
		panel_right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 如果点击右键 显示子菜单
				if (e.getButton() == MouseEvent.BUTTON3) {
					// 获取相对于窗口的逻辑位置
					Point p = e.getPoint();
					popupMenu2.show(e.getComponent(), p.x, p.y);

				}
				// 否则不显示子菜单
				else {
					popupMenu2.setVisible(false);
				}
			}
		});

	}

	/**
	 * 菜单
	 * 
	 **/
	public MouseAdapter caiDan(JPopupMenu popupMenu) {
		MouseAdapter a = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 如果点击右键 显示子菜单
				if (e.getButton() == MouseEvent.BUTTON3) {
					// 获取相对于窗口的逻辑位置
					Point p = e.getPoint();
					popupMenu.show(e.getComponent(), p.x, p.y);
				}
				// 否则不显示子菜单
				else {
					popupMenu.setVisible(false);
				}
			}
		};
		return a;
	}
	
	
	/***
	 * 
	 * 删除桌面
	 * */
	public ActionListener ListenerDeleteZT(Zhuotai zhuotai){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "确定删除此桌台?") == JOptionPane.YES_OPTION) {
					if("shiyong".equals(zhuotai.getZhuotaizt())){
						JOptionPane.showMessageDialog(null, "此桌台正在使用不能删除！", "警告",JOptionPane.WARNING_MESSAGE);  
					}else{
						zhuotaiBiz.delZhuotai(zhuotai.getZtid());
						//刷新界面
					}
					System.out.println(zhuotai);
				}

			}
		};
	}

	/***
	 * 基本信息
	 * */
	public ActionListener ListenerJibenxinxi(Zhuotai Zhuotai){
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frame, "确定删除此桌台?") == JOptionPane.YES_OPTION) {
					// System.exit(0); //？？？？？？？？？？？？？？？？？、、
					// int[] seleteRows=deleteZT.getSelectedRows();
				}

			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
