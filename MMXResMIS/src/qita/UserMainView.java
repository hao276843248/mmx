//package qita;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.GridLayout;
//
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JDesktopPane;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//public class UserMainView extends JFrame {
//	private static final long serialVersionUID = -5812233118607554390L;
//    private JPanel main_panel=null; //主面板
//    private JPanel wel_panel=null;//欢迎面板
//    private JPanel btn_panel=null;//按钮组面板
//    private JDesktopPane funDesktop=null;//桌面面板或业务面板,里面可放内嵌的窗体，这里是功能面板
//    
//    private JButton btn_query_rent_dvd=null;//查询租赁按钮
//    private JButton btn_dvd_record=null;//查看租赁疾苦按钮
//    private JButton btn_exit=null;//退出按钮
//    private JLabel lb_welcome=null;//欢迎标题
//    private JLabel deskLabel=null;//存放图片的Label
//    public UserMainView(){
//    	init();
//    }
//    
//    private void init(){
//    	main_panel=new JPanel(new BorderLayout());//麻将桌布局管理器
//    	btn_panel=new JPanel(new GridLayout(7,1,0,35));//表格布局管理器
//    	btn_query_rent_dvd=new JButton("DVD查询租赁操作");
//    	btn_dvd_record =new JButton("DVD租赁记录查询");
//    	btn_exit=new  JButton("退出窗口");
//    	//用来填充的标签控件
//    	btn_panel.add(new JLabel());
//    	btn_panel.add(new JLabel());
//    	btn_panel.add(btn_query_rent_dvd);
//    	btn_panel.add(btn_dvd_record);
//    	btn_panel.add(btn_exit);
//    	btn_panel.add(new JLabel());
//    	btn_panel.add(new JLabel());
//        //设置面板的边框外观
//    	btn_panel.setBorder(BorderFactory.createTitledBorder(
//    			BorderFactory.createRaisedBevelBorder(),"快捷功能区"));//斜坡突起，标题
//    	
//    	//初始化欢迎面板
//    	wel_panel=new JPanel();
//    	lb_welcome=new JLabel("欢   迎   使  用  本  餐  饮  管  理  系  统");
//    	lb_welcome.setFont(new Font("宋体",Font.BOLD,23));//字体粗体字，23号
//    	lb_welcome.setForeground(Color.BLUE);
//    	wel_panel.add(lb_welcome);
//    	
//    	//初始化桌面面板
//    	funDesktop=new JDesktopPane();
//    	ImageIcon image=new ImageIcon("src/images/resmis.jpg");
//    	deskLabel=new JLabel(image);
//    	deskLabel.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
//    	funDesktop.add(deskLabel,new Integer(Integer.MIN_VALUE));//最小值，最底层
//    	
//    	main_panel.add(btn_panel,BorderLayout.EAST);
//    	main_panel.add(wel_panel,BorderLayout.NORTH);
//    	main_panel.add(funDesktop,BorderLayout.CENTER);
//    	//防止阻塞
//    	EventQueue.invokeLater(new Runnable(){
//
//			@Override
//			public void run() {
//				new Thread(new DynaminThread()).start();
//			}   		
//    	});
//    	
//    	//main_panel.add(btn_panel,BorderLayout.EAST);
//
//    	this.setTitle("餐饮管理系统");
//    	this.getContentPane().add(main_panel);
//    	this.setSize(1000, 650);
//    	this.setVisible(true);
//    	this.setResizable(false);//不可改变窗体大小
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
//        this.setLocationRelativeTo(null);//居中显示
//    	
//    }
//    
//    
// // 开启一个线程，让欢迎Label标签从右向左移动
//     
//    private class DynaminThread implements Runnable/*动态现场实、Runnable接口*/{
//    	 public void run(){
//    		while(true){
//    			for(int i=1000;i>-750;i--){
//    				try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//    				lb_welcome.setLocation(i,5)
//    				;
//    			}
//    		}
//    	}
//  } 
//    
//    
//    
//    
//    
//    
//    
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
