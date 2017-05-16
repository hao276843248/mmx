package mmxresmis.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mmxresmis.biz.ZhuotaiBiz;
import mmxresmis.biz.impl.ZhuotaiBizImpl;
import mmxresmis.entity.Zhuotai;

public class KaitaiView extends JFrame {
	private static final long serialVersionUID = -8546047454814393569L;
	private JPanel panel_main = null;// 主面板
	private JPanel panel_left = null;// 左侧面板
	private JPanel panel_right = null;// 右侧面板

	private JLabel lb_zhuotainum = null;// 桌台号标签
	private JLabel lb_guestname = null;// 顾客名
	private JLabel lb_zhangdandate = null;// 账单日期
	private JLabel lb_gsum = null;// 就餐人数
	private JLabel lb_wnum = null;// 服务员号
	private JLabel lb_beizhu = null;// 备注

	private JTextField tf_zhuotainame = null;// 桌台文本框
	private JTextField tf_guestname = null;
	private JTextField tf_zhangdandate = null;
	private JTextField tf_gnum = null;
	private JTextField tf_beizhu = null;

	private JButton btn_confirm = null;// 确定按钮
	private JButton btn_cancel = null;// 取消按钮

	private JComboBox<String> cb_wnum = null;// 服务员号下拉列表框
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public ZhuotaiBiz zhuotaiBizImpl=new ZhuotaiBizImpl();
	private Zhuotai zhuotai=null;
	private UserMainView u=null;
	
	public KaitaiView(Zhuotai zhuotai) {
		this.zhuotai=zhuotai;
		init();// 构造方法调用，当构造登录窗口对象时，初始化相应的控件，以达到显示界面的效果
		registerListener();
	}
	

	// 初始化窗体控件的方法
	private void init() {
		this.setSize(560, 280);// 设置窗体大小
		this.setResizable(false);// 不可拖动窗体大小
		// this.setClosable(true);//窗体可被关闭
		// this.setIconifiable(true);//JInternalFrame内嵌窗体，窗体可最小化
		// this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("开台窗口");// 设置标题
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 退出关闭窗体功能

		// 初始化面板
		panel_main = new JPanel(new GridLayout(1, 2));// 格局是一行两列的表格
		panel_left = new JPanel(new GridLayout(4, 2, 0, 10));
		panel_right = new JPanel(new GridLayout(4, 2, 0, 10));// 后两个参数表格水平垂直间距

		// 初始化控件
		tf_zhuotainame = new JTextField(zhuotai.getZhuotainum());// 长度8
		tf_zhuotainame.setEditable(false);
		tf_guestname = new JTextField(8);
		tf_zhangdandate = new JTextField(formatter.format(new Date()));
		tf_zhangdandate.setEditable(false);
		tf_gnum = new JTextField(8);
		cb_wnum = new JComboBox<String>(new String[] { "001", "002", "003", "004", "005", "006", "007" });
		tf_beizhu = new JTextField(8);

		btn_confirm = new JButton("确定");
		btn_cancel = new JButton("取消");

		lb_zhuotainum = new JLabel("桌台号", JLabel.CENTER);
		lb_guestname = new JLabel("顾客名", JLabel.CENTER);
		lb_zhangdandate = new JLabel("账单日期", JLabel.CENTER);
		lb_gsum = new JLabel("就餐人数", JLabel.CENTER);
		lb_wnum = new JLabel("服务员号", JLabel.CENTER);
		lb_beizhu = new JLabel("备 注", JLabel.CENTER);

		// 把相应的控件放到面板中去
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

		  
		// 主面板中放左右两个面板
		panel_main.add(panel_left);
		panel_main.add(panel_right);

		// 再把主面板放到窗体中
		this.getContentPane().add(panel_main);// 内容面板
		this.pack();// 收缩窗体
		this.setVisible(true);// 显示窗体
		
	}
	/**
	 * 关闭窗口 
	 * **/
	private void close(){
		this.dispose();
	}
	private void registerListener() {
		btn_confirm.addActionListener(new ActionListener() {
			@Override // 快捷重写
			public void actionPerformed(ActionEvent e) {
				// 获取用户名和密码
				String guestname = tf_guestname.getText();
				String zhangdandate = tf_zhangdandate.getText();
				String num = tf_gnum.getText().trim();
				int wnum = cb_wnum.getSelectedIndex();
				String zhuotaiBZ = tf_beizhu.getText();
				if (tf_guestname.equals("")) {
					JOptionPane.showMessageDialog(KaitaiView.this, "顾客名不能为空"); // JOptionPane消息框
																				// ,父容器LoginView
					return;
				}else if (lb_gsum.equals("")) {
					JOptionPane.showMessageDialog(KaitaiView.this, "就餐人数不能为空");
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
				// User user =new User(uname,upass,type);//封装成User对象 ？没有导入包
				// user = userBiz.login(user);//调用业务层方法 ,查看比对有没有此用户
			}
		});
		
		btn_cancel.addActionListener(new ActionListener() {
			@Override // 快捷重写
			public void actionPerformed(ActionEvent e) {
				UserMainView a=new UserMainView(null);
				close();
				a.shuaxin();
			}
			
		});
	}
	

}
