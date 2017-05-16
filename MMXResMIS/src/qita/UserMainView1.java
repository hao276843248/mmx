package qita;



import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;

import mmxresmis.view.JiezhangView;
import mmxresmis.view.KaitaiView;
import mmxresmis.view.LoginView;
import mmxresmis.view.Order_itemView;
import mmxresmis.view.UserRegisterView;

public class UserMainView1 extends JFrame {
	private static final long serialVersionUID = -140364745910693543L;
	private JMenuBar menuBar=null;//菜单条
	
	private JPanel panel_left=null;//面板
	private JPanel panel_right=null;
	private JPanel panel1=null; 
    private JPanel panel2=null;
    private JPanel panel3=null;
    private JPanel panel4=null; 
    private JPanel panel5=null;
    private JPanel panel6=null;
    
    private JPanel panel7=null;
    private JPanel panel8=null; 
    private JPanel panel9=null;
    
    private JSplitPane splitPane=null;//分割容器类
     
    private JMenu yzMenu=null;//用户注册
    private JMenu ydMenu=null;//用户登录
 
    private JMenuItem yzMenuItem=null;//用户注册
    private JMenuItem ydMenuItem=null;//用户登录
    
    private JLabel lb_gonggao=null;
	private JLabel lb_lianxi=null;
	private JLabel lb_tel=null;
	private JLabel lb_addr=null;
	
    
    private JLabel deskLabel1=null;//存放图片的Label
    private JLabel deskLabel2=null;
    private JLabel deskLabel3=null;
    private JLabel deskLabel4=null;
    private JLabel deskLabel5=null;//存放图片的Label
    private JLabel deskLabel6=null;
    private JLabel deskLabel7=null;
    private JLabel deskLabel8=null;
    private JLabel deskLabel9=null;//存放图片的Label
    private JLabel deskLabel10=null;
    private JLabel deskLabel11=null;
    private JLabel deskLabel12=null;
    private JLabel deskLabel13=null;//存放图片的Label
    private JLabel deskLabel14=null;
    
    private JPopupMenu popupMenu;
	private JMenuItem kaitai=null;//开台
	private JMenuItem cancelkaitai=null;//取消开台
	private JMenuItem orderitem=null;//点菜/加菜
	private JMenuItem xiaofeichaxun=null;//消费查询
	private JMenuItem jiezhang=null;//结账
	
    public UserMainView1(){
    	init();
    	registerListener();
    }
    
    private void init(){
    	//初始化菜单,面板
    	menuBar=new JMenuBar();
    	
    	panel_left=new JPanel(new  GridLayout(10,1,0,35));
    	panel_right=new JPanel();
    	panel1=new JPanel();
    	panel2=new JPanel();
    	panel3=new JPanel();
    	panel4=new JPanel();
    	panel5=new JPanel();
    	panel6=new JPanel();
    	panel7=new JPanel();
    	panel8=new JPanel();
    	panel9=new JPanel();
    	
    	ImageIcon image1=new ImageIcon("src/images/a_1.jpg");
    	deskLabel1=new JLabel(image1);
    	deskLabel1.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel2=new JLabel(image1);
    	deskLabel2.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel3=new JLabel(image1);
    	deskLabel3.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel4=new JLabel(image1);
    	deskLabel4.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel5=new JLabel(image1);
    	deskLabel5.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel6=new JLabel(image1);
    	deskLabel6.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel7=new JLabel(image1);
    	deskLabel7.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());   	
    	deskLabel8=new JLabel(image1);
    	deskLabel8.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	
    	ImageIcon image2=new ImageIcon("src/images/a_3.jpg");
    	deskLabel9=new JLabel(image2);
    	deskLabel9.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel10=new JLabel(image2);
    	deskLabel10.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel11=new JLabel(image2);
    	deskLabel11.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel12=new JLabel(image2);
    	deskLabel12.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel13=new JLabel(image2);
    	deskLabel13.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel14=new JLabel(image2);
    	deskLabel14.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	
    
    	//初始化分割线
    	splitPane=new JSplitPane();
//    	splitPane.setOneTouchExpandable(true);//让分割线显示出箭头
//    	splitPane.setContinuousLayout(true);//当用户操作分割线时系统会重新绘图形???没有影响
    	splitPane.setDividerSize(10);//设置分隔线大小为10个单位     ？？？
    	
    	popupMenu = new JPopupMenu();
    	
		//初始化菜单
    	yzMenu=new JMenu("用户注册");
    	ydMenu=new JMenu("用户登录");
    	
    	yzMenuItem=new JMenuItem("用户注册");
    	ydMenuItem=new JMenuItem("用户登录");
    	
    	//初始化标签
		lb_gonggao=new JLabel("公告");
		lb_lianxi=new JLabel("联系我们");
		lb_lianxi.setFont(new Font("宋体",Font.BOLD,20));//设置字体
		lb_lianxi.setForeground(Color.red);//设置颜色
		lb_tel=new JLabel("电话:15612494925");
		lb_tel.setFont(new Font("宋体",Font.BOLD,15));
		lb_addr=new JLabel("地址:河北地质大学");
		lb_addr.setFont(new Font("宋体",Font.BOLD,15));
		
		 kaitai = new JMenuItem("开台");
		 cancelkaitai = new JMenuItem("取消开台");
		 orderitem = new JMenuItem("点/加菜");
		 xiaofeichaxun = new JMenuItem("消费查询");
		 jiezhang = new JMenuItem("结账");
		
		//把控件加到相应的位置上
    	yzMenu.add(yzMenuItem);
    	ydMenu.add(ydMenuItem);
    	
    	menuBar.add(yzMenu);
    	menuBar.add(ydMenu);
	
    	panel2.add(lb_gonggao);
    	panel4.add(lb_lianxi);
    	panel5.add(lb_tel);
    	panel6.add(lb_addr);
    	panel7.add(deskLabel1);
    	panel7.add(deskLabel2);
    	panel7.add(deskLabel3);
    	panel7.add(deskLabel4);
    	panel7.add(deskLabel5);
    	panel7.add(deskLabel6);
    	panel7.add(deskLabel7);
    	panel7.add(deskLabel8);
    	panel9.add(deskLabel9);
    	panel9.add(deskLabel10);
    	panel9.add(deskLabel11);
    	panel9.add(deskLabel12);
    	panel9.add(deskLabel13);
    	panel9.add(deskLabel14);
    	
    	panel_left.add(panel1);
    	panel_left.add(panel2);
    	panel_left.add(panel3);
    	panel_left.add(panel4);
    	panel_left.add(panel5);
    	panel_left.add(panel6);
    	panel_right.add(panel7);
    	panel_right.add(panel8);
    	panel_right.add(panel9);

    	popupMenu.add(kaitai);
    	popupMenu.add(cancelkaitai);
    	popupMenu.add(orderitem);
    	popupMenu.add(xiaofeichaxun);
    	popupMenu.add(jiezhang);
    	
		splitPane.setLeftComponent(panel_left);//将panel_left放到分割线左边，panel_right放到右边
    	splitPane.setRightComponent(panel_right);

    	this.getContentPane().add(splitPane);
    	this.setJMenuBar(menuBar);
    	setBounds(800,120,880,420);//setBounds(x,y,width,height)
     	this.setTitle("中小型餐饮管理系统");
    	this.setResizable(false);//不可改变窗体大小
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);//居中显示
        this.setVisible(true);
    	
    	splitPane.setDividerLocation(0.3);//左右比例大小
    	splitPane.setEnabled(false);//分割线不可左右移动
    }

 
    private void registerListener(){
    	yzMenuItem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRegisterView urv=new UserRegisterView();
				panel_right.add(urv);//把指定的视图添加到桌面容器中
				urv.toFront();//视图显示在最前面				
			}   		
    	});
    	
    	ydMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView lView=new LoginView();
				panel_right.add(lView);//把指定的视图添加到桌面容器中
				lView.toFront();//视图显示在最前面				
			}    		
    	});
 
    	kaitai.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				KaitaiView ktv=new KaitaiView();
				panel_right.add(ktv);//把指定的视图添加到桌面容器中
				ktv.toFront();//视图显示在最前面				
			}   		
    	});
    	
//    	cancelkaitai.addActionListener(new ActionListener(){ 	
//    			@Override
//    			public void actionPerformed(ActionEvent e) {
//    				KaitaiView ktv=new KaitaiView();
//    				panel_right.add(ktv);//把指定的视图添加到桌面容器中
//    				ktv.toFront();//视图显示在最前面				
//    			}   		
//        	});
    	
    	orderitem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				Order_itemView oim=new Order_itemView();
				panel_right.add(oim);//把指定的视图添加到桌面容器中
				oim.toFront();//视图显示在最前面				
			}   		
    	});
    	
//    	xiaofeichaxun.addActionListener(new ActionListener(){ 	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Order_itemView oim=new Order_itemView();
//				panel_right.add(oim);//把指定的视图添加到桌面容器中
//				oim.toFront();//视图显示在最前面				
//			}   		
//    	});
    	
    	jiezhang.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				JiezhangView jzv=new JiezhangView();
				panel_right.add(jzv);//把指定的视图添加到桌面容器中
				jzv.toFront();//视图显示在最前面				
			}   		
    	});
    	
    	
    }

    
    
}
