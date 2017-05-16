package mmxresmis.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JiezhangView extends JFrame {
	private static final long serialVersionUID = -1062640286971674349L;
	private JPanel panel_main=null;//主面板
	private JPanel panel1=null;
	private JPanel panel2=null;
	private JPanel panel3=null;
	private JPanel panel4=null;
	private JPanel panel5=null;
	private JPanel panel6=null;
	
	
	private JTextArea ta_xianshi=null;
    private JScrollPane sp=null;//滚动条
	
    private JLabel lb_roombjf;//包间费标签
	private JLabel lb_yingshou;
	private JLabel lb_shishou;
	private JLabel lb_zhaoling;
	
	private JTextField tf_roombjf;//包间费文本框
	private JTextField tf_yingshou;
	private JTextField tf_shishou;
	private JTextField tf_zhaoling;
	
	private JButton btn_jiezhang=null;//结账按钮
	private JButton btn_exit=null;
	
	public JiezhangView(){
		init();
	}
		
	private void init(){
		this.setSize(700,420);//设置窗体大小
		this.setResizable(false);//，不可拖动窗体大小
//		this.setIconifiable(true);//JInternalFrame内嵌窗体，窗体可最小化
//		this.setClosable(true);//窗体可被关闭
//		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("结账窗口");// 设置标题
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出关闭窗体功能
		//this.pack();//收缩窗体
	
		
		//初始化面板
	    panel_main=new JPanel(new GridLayout(6,1));//默认流式管理器
	    //panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
	    panel1=new JPanel();
	    panel2=new JPanel();
		//panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3=new JPanel();
		//panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4=new JPanel();
		//panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5=new JPanel();
		//panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel6=new JPanel();
		
		
		//初始化控件
		lb_roombjf=new JLabel("包间费");
		lb_yingshou=new JLabel("应收款");
		lb_shishou=new JLabel("实收款");
		lb_zhaoling=new JLabel("找 零");
		
		tf_roombjf=new JTextField(8);
		tf_yingshou=new JTextField(8);
		tf_shishou=new JTextField(8);
		tf_zhaoling=new JTextField(8);
		
		btn_jiezhang=new JButton("结账");
		btn_exit=new JButton("取消");
		
		ta_xianshi=new JTextArea(5,50); 
		sp=new JScrollPane(ta_xianshi);
		
		
		panel1.add(sp);
		panel2.add(lb_roombjf);
		panel2.add(tf_roombjf);
		panel3.add(lb_yingshou);
		panel3.add(tf_yingshou);
		panel4.add(lb_shishou);
		panel4.add(tf_shishou);
		panel5.add(lb_zhaoling);
		panel5.add(tf_zhaoling);
		panel6.add(btn_jiezhang);
		panel6.add(btn_exit);
		
		
		panel_main.add(panel1);
	    panel_main.add(panel2);
	    panel_main.add(panel3);
		panel_main.add(panel4);
		panel_main.add(panel5);
		panel_main.add(panel6);
		 
		this.getContentPane().add(panel_main);//内容面板
		this.setVisible(true);//显示窗体
		}
	
	
	
	
}