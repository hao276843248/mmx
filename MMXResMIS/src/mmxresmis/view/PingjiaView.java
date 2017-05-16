package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class PingjiaView extends JFrame {
	private static final long serialVersionUID = -5091520751041153452L;
	private JPanel main_panel=null; //主面板
	private JPanel panel1=null;
	private JPanel panel2=null;
	private JPanel panel3=null;
	private JPanel panel4=null;
	//private JPanel panel5=null;
	
	private JLabel lb_title=null;//标题标签
	private JLabel lb_allpingjia=null;//总体评价
	private JLabel lb_allfeeling=null;//总体感受
	private JLabel lb_tishi=null;//提示

	private JTextArea tf_allfeeling=null;//总体感受文本框
	
	private JButton btn_submit=null;//提交按钮
	
	public PingjiaView(){
		init();
	}
	
	private void init(){
		this.setSize(640,300);//设置窗体大小
		this.setResizable(false);//不可拖动窗体大小
		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("评价窗口");// 设置标签
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭窗体功能
		//this.pack();//收缩窗体
	    this.setVisible(true);//显示窗体
		
		//初始化控件
				tf_allfeeling=new JTextArea("您的评价",5,25);
				tf_allfeeling.setText("jk");
				//contentTextArea.setText(updateRow.get(6).toString());
				
				
				btn_submit=new JButton("提交");
				//btn_submit.setBounds(10,80,80,25);		
				lb_title=new JLabel("2017.3.2017-3-15 11:45:07的订单",SwingConstants.LEFT);//怎么获取当前评价的时间？
				//lb_title.setBounds(new Rectangle(0, 180, 100, 40));
				lb_allpingjia=new JLabel("总体评价",JLabel.LEFT);//怎么靠左
				lb_allpingjia.setBounds(0,0,12,12);
				 lb_allfeeling=new JLabel("总体感受",SwingConstants.LEFT);
				lb_tishi=new JLabel("*提交后不能修改");
		
		//初始化面板
		main_panel=new JPanel(new GridLayout(4,1));
		panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2=new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3=new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4=new JPanel();
		//panel5=new JPanel();
		
		
		
		//把相应的控件放到面板中去
		panel1.add(lb_title);
		panel2.add(lb_allpingjia);
		panel3.add(lb_allfeeling);
		panel3.add(new JScrollPane(tf_allfeeling));
		//panel4.add(new JScrollPane(tf_allfeeling));
		panel4.add(btn_submit);
		panel4.add(lb_tishi);
		
		main_panel.add(panel1,BorderLayout.WEST);
		main_panel.add(panel2,BorderLayout.WEST);
		main_panel.add(panel3,BorderLayout.WEST);
		main_panel.add(panel4);
		//main_panel.add(panel5);
  
//		main_panel.add(lb_title);
//		main_panel.add(lb_allpingjia);
//		main_panel.add(lb_allfeeling);
//		main_panel.add(new JScrollPane(tf_allfeeling));
//		main_panel.add(btn_submit);
//		main_panel.add(lb_tishi);
		
		this.getContentPane().add(main_panel);
	    this.setVisible(true);//显示窗体

	}
}
