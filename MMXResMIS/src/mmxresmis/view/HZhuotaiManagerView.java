package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class HZhuotaiManagerView extends JInternalFrame {
	private static final long serialVersionUID = 3939275304556258785L;
	private JPanel paneltable = null;// 面板
	private JPanel paneljiben = null;// 基本信息面板
	private JPanel panelqita = null;// 其他信息面板

	private JLabel lb_zhuotainum = null;
	private JLabel lb_zhuotaijc = null;
	private JLabel lb_zhuotaibjf = null;//
	private JLabel lb_zhuotaiwz = null;
	private JLabel lb_zhuotaizt = null;
	private JLabel lb_zhuotaitype = null;//
	private JLabel lb_zhuotaibz = null;
	private JLabel lb_zhuotaiqi = null;

	private JButton btn_xiugai;

	private JTextField textField1 = null;
	private JTextField textField2 = null;
	private JTextField textField3 = null;
	private JTextField textField4 = null;
	private JTextField textField5 = null;
	private JTextField textField6 = null;
	private JTextField textField7 = null;

	private JTextArea tf_beizhu = null;// 备注文本框
	private JTextArea tf_qita = null;// 其他文本框

	public HZhuotaiManagerView() {
		init();
	}

	private void init() {
		setTitle("桌台基本信息");
		setBounds(200, 120, 560, 420);// setBounds(x,y,width,height)
		this.setIconifiable(true);
		this.setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 退出关闭窗体功能
		this.setLayout(new BorderLayout());

		paneltable = new JPanel(new BorderLayout());// 创建面板
		// 给面板设置边框
		Border btable = (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "桌台基本信息"));
		paneltable.setBorder(btable);
		this.add(paneltable, BorderLayout.CENTER);
		paneljiben = new JPanel(new GridLayout(8, 2, 10, 10));
		paneljiben.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "基本信息"));
		this.add(paneljiben, BorderLayout.EAST);
		lb_zhuotainum = new JLabel("桌台号");
		paneljiben.add(lb_zhuotainum);
		textField1 = new JTextField(5);
		paneljiben.add(textField1);
		lb_zhuotaijc = new JLabel("简称");
		paneljiben.add(lb_zhuotaijc);
		textField2 = new JTextField(5);
		paneljiben.add(textField2);
		lb_zhuotaibjf = new JLabel("包间费");
		paneljiben.add(lb_zhuotaibjf);
		textField3 = new JTextField(5);
		paneljiben.add(textField3);
		lb_zhuotaiwz = new JLabel("位置");
		paneljiben.add(lb_zhuotaiwz);
		textField4 = new JTextField(5);
		paneljiben.add(textField4);
		lb_zhuotaizt = new JLabel("状态");
		paneljiben.add(lb_zhuotaizt);
		textField5 = new JTextField(5);
		paneljiben.add(textField5);
		lb_zhuotaitype = new JLabel("类型");
		paneljiben.add(lb_zhuotaitype);
		textField6 = new JTextField(5);
		paneljiben.add(textField6);
		lb_zhuotaibz = new JLabel("备注");
		paneljiben.add(lb_zhuotaibz);
		textField7 = new JTextField(5);
		paneljiben.add(textField7);

		panelqita = new JPanel(new GridLayout(8, 2, 10, 10));
		panelqita.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "基本信息"));
		this.add(panelqita, BorderLayout.WEST);
		lb_zhuotaiqi = new JLabel("其他");
		paneljiben.add(lb_zhuotaiqi);

		this.setVisible(true);

	}

}
