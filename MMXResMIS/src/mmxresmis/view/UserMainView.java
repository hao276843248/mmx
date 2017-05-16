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
	private JMenuBar mBar = null;// 菜单条
	private JPanel panel_left = null;// 面板
	private JPanel panel_right = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;
	private JPanel panel5 = null;
	private JPanel panel6 = null;

	private JSplitPane splitPane = null;// 分割容器类

	private JMenu syMenu = null;// 系统首页菜单
	private JMenu yzMenu = null;// 用户注册
	private JMenu wdMenu = null;// 我的订单
	private JMenu bzMenu = null;// 帮助
	private JMenu tcMenu = null;// 退出

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
		// 查询所有桌台信息
		zhuotaiList = zhuoTaiBiz.queryAllZhuotai();
		// 初始化菜单面板
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
			JMenuItem kaitai = new JMenuItem("开台");
			JMenuItem cancelkaitai = new JMenuItem("取消开台");
			JMenuItem orderitem = new JMenuItem("点/加菜");
			JMenuItem xiaofeichaxun = new JMenuItem("消费查询");
			JMenuItem jiezhang = new JMenuItem("结账");

			popupMenu.add(kaitai);
			popupMenu.add(cancelkaitai);
			popupMenu.add(orderitem);
			popupMenu.add(xiaofeichaxun);
			popupMenu.add(jiezhang);
			JPanel panel7 = new JPanel();
			if (zhuotaiList.get(i).getZhuotaizt().equals("shiyong")) {
				ImageIcon image1 = new ImageIcon("src/images/a_2.jpg");
				JLabel deskLabel = new JLabel(image1);
				deskLabel.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
				deskLabel.addMouseListener(caiDan(popupMenu));
				panel7.add(deskLabel);
				panel_right.add(panel7);

				kaitai.setEnabled(false);
				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(true);
				xiaofeichaxun.setEnabled(true);
				jiezhang.setEnabled(true);

				kaitai.addActionListener(
						ListenerKaitai(zhuotaiList.get(i), kaitai, cancelkaitai, orderitem, xiaofeichaxun, jiezhang));
				cancelkaitai.addActionListener(ListenerCancelkaitai(zhuotaiList.get(i).getZtid(), kaitai, cancelkaitai,
						orderitem, xiaofeichaxun, jiezhang));
				orderitem.addActionListener(ListenerOrderitem(zhuotaiList.get(i).getZtid(), kaitai, cancelkaitai,
						orderitem, xiaofeichaxun, jiezhang));
				xiaofeichaxun.addActionListener(ListenerXiaofeichaxun(zhuotaiList.get(i).getZtid(), kaitai,
						cancelkaitai, orderitem, xiaofeichaxun, jiezhang));
				jiezhang.addActionListener(ListenerJiezhang(zhuotaiList.get(i).getZtid(), kaitai, cancelkaitai,
						orderitem, xiaofeichaxun, jiezhang));
			} else {
				ImageIcon image1 = new ImageIcon("src/images/a_1.jpg");
				JLabel deskLabel = new JLabel(image1);
				deskLabel.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
				deskLabel.addMouseListener(caiDan(popupMenu));
				panel7.add(deskLabel);
				panel_right.add(panel7);

				cancelkaitai.setEnabled(false);
				orderitem.setEnabled(false);
				xiaofeichaxun.setEnabled(false);
				jiezhang.setEnabled(false);

				kaitai.addActionListener(
						ListenerKaitai(zhuotaiList.get(i), kaitai, cancelkaitai, orderitem, xiaofeichaxun, jiezhang));
				cancelkaitai.addActionListener(ListenerCancelkaitai(zhuotaiList.get(i).getZtid(), kaitai, cancelkaitai,
						orderitem, xiaofeichaxun, jiezhang));
				orderitem.addActionListener(ListenerOrderitem(zhuotaiList.get(i).getZtid(), kaitai, cancelkaitai,
						orderitem, xiaofeichaxun, jiezhang));
				xiaofeichaxun.addActionListener(ListenerXiaofeichaxun(zhuotaiList.get(i).getZtid(), kaitai,
						cancelkaitai, orderitem, xiaofeichaxun, jiezhang));
				jiezhang.addActionListener(ListenerJiezhang(zhuotaiList.get(i).getZtid(), kaitai, cancelkaitai,
						orderitem, xiaofeichaxun, jiezhang));
			}
		}

		// 初始化滚动条
		splitPane = new JSplitPane();
		// splitPane.setOneTouchExpandable(true);//让分割线显示出箭头
		// splitPane.setContinuousLayout(true);//当用户操作分割线时系统会重新绘图形???没有影响
		splitPane.setDividerSize(10);// 设置分隔线大小为10个单位 ？？？

		// 初始化菜单
		syMenu = new JMenu("系统首页");
		yzMenu = new JMenu("用户注册");
		wdMenu = new JMenu("我的订单");
		bzMenu = new JMenu("帮助");
		tcMenu = new JMenu("退出");

		syMenuItem = new JMenuItem("系统首页");
		yzMenuItem = new JMenuItem("用户注册");
		ddMenuItem = new JMenuItem("订单详情");
		bzMenuItem = new JMenuItem("关于我们");
		tcMenuItem = new JMenuItem("退出系统");

		// 初始化标签
		lb_gonggao = new JLabel("公告");
		lb_lianxi = new JLabel("联系我们");
		lb_lianxi.setFont(new Font("宋体", Font.BOLD, 20));// 设置字体
		lb_lianxi.setForeground(Color.red);// 设置颜色
		// lb_tel=new JLabel("电话:15612494925");
		lb_tel = new JLabel();
		lb_tel.setFont(new Font("宋体", Font.BOLD, 15));
		lb_addr = new JLabel("地址:河北地质大学");
		lb_addr.setFont(new Font("宋体", Font.BOLD, 15));

		// 把控件加到相应的位置上
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

		splitPane.setLeftComponent(panel_left);// 将panel_left放到分割线左边，panel_right放到右边
		splitPane.setRightComponent(panel_right);
		splitPane.setDividerLocation(0.3);// 左右比例大小
		splitPane.setEnabled(false);// 分割线不可左右移动

		this.getContentPane().add(splitPane);
		this.setJMenuBar(mBar);
		this.setSize(1000, 650);
		this.setTitle("中小型餐饮管理系统");
		this.setVisible(true);
		this.setResizable(false);// 不可改变窗体大小
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);// 居中显示

	}

	private void registerListener() {
		yzMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRegisterView urv = new UserRegisterView();
				panel_right.add(urv);// 把指定的视图添加到桌面容器中
				urv.toFront();// 视图显示在最前面
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

	/**
	 * 开桌
	 * 
	 **/
	public ActionListener ListenerKaitai(Zhuotai zhuotai, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KaitaiView ktv = new KaitaiView(zhuotai);
				// panel_right.add(ktv);//把指定的视图添加到桌面容器中
				ktv.toFront();// 视图显示在最前面
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
	 * 取消开桌
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
	 * 点/加菜
	 * 
	 **/
	public ActionListener ListenerOrderitem(int id, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Order_itemView oim = new Order_itemView();
				panel_right.add(oim);// 把指定的视图添加到桌面容器中
				oim.toFront();// 视图显示在最前面
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
	 * 消费情况
	 * 
	 **/

	public ActionListener ListenerXiaofeichaxun(int id, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Order_itemView oim = new Order_itemView();
				// panel_right.add(oim);//把指定的视图添加到桌面容器中
				oim.toFront();// 视图显示在最前面
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
	 * 结账
	 * 
	 **/
	public ActionListener ListenerJiezhang(int id, JMenuItem kaitai, JMenuItem cancelkaitai, JMenuItem orderitem,
			JMenuItem xiaofeichaxun, JMenuItem jiezhang) {
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JiezhangView jzv = new JiezhangView();
				// panel_right.add(jzv);//把指定的视图添加到桌面容器中
				jzv.toFront();// 视图显示在最前面
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
