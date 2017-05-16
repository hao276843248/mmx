 package mmxresmis.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mmxresmis.biz.UserBiz;
import mmxresmis.biz.impl.UserBizImpl;
import mmxresmis.entity.User;

public class LoginView extends JFrame {
	private static final long serialVersionUID = -7787622459818833617L;
	private JPanel panel_main=null;//主面板
    private JPanel panel_left=null;//左侧面板
    private JPanel panel_right =null;//右侧面板
    
    private JLabel lb_uname=null;//用户标签
    private JLabel lb_upass=null;//密码标签
    private JLabel lb_type=null;//登陆类型标签
    
    private JTextField tf_uname=null;//用户文本框
    private JPasswordField pf_upass=null;//密码文本框
    
    private JLabel lb_img=null;//显示图片的标签
    
    private JButton btn_login=null;//登录按钮
    private JButton btn_register=null;//注册按钮
    
    private JComboBox<String> cb_type=null;//登录类型下拉列表框 
    private UserBiz userBiz=null;//调用相关业务层
    
    public LoginView(){
    	userBiz=new UserBizImpl();//产生对应用户业务层对象
    	init();//构造方法调用，当构造登录窗口对象时，初始化相应的控件，以达到显示界面的效果
    	registerListener();
    	
    }
    
    
    //初始化窗体控件的方法
    private void init(){
    	setBounds(200,120,660,320);//setBounds(x,y,width,height)
    	this.setResizable(false);//不可拖动窗体大小
    	
//    	this.setClosable(true);//窗体可被关闭
//		this.setIconifiable(true);//JInternalFrame内嵌窗体，窗体可最小化
//    	this.setLocationRelativeTo(null);//窗体居中显示
    	this.setTitle("登录窗口");// 设置标题
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出关闭本窗体功能
    	
    	//初始化面板
    	panel_main=new JPanel(new GridLayout(1,2));//格局是一行两列的表格
    	panel_left=new JPanel();//默认流式管理器
    	panel_right=new JPanel(new GridLayout(4,2,0,10));//后两个参数表格水平垂直间距
    	
    	//初始化控件
    	 tf_uname=new JTextField(8);//长度8
    	 pf_upass=new JPasswordField(8);
    	 cb_type=new JComboBox<String>(new String []{"普通用户","管理员"});
    	 btn_login=new JButton("登录");
    	 btn_register=new JButton("注册");
    	 lb_uname=new JLabel("用  户:",JLabel.CENTER);
    	 lb_upass=new JLabel("密  码:",JLabel.CENTER);
    	 lb_type=new JLabel("类  型:",JLabel.CENTER);
         lb_img=new JLabel(new ImageIcon(
        		 ClassLoader.getSystemResource("images/a_1.jpg")));//类加载器对象，找到src文件夹

         
         //把相应的控件放到面板中去
         panel_left.add(lb_img);
         panel_right.add(lb_uname);
         panel_right.add(tf_uname);         
         panel_right.add(lb_upass);
         panel_right.add(pf_upass);
         panel_right.add(lb_type);
         panel_right.add(cb_type);
         panel_right.add(btn_login);
         panel_right.add(btn_register);
         
         
         //主面板中放左右两个面板
         panel_main.add(panel_left);
         panel_main.add(panel_right);
         
         //再把主面板放到窗体中
         this.getContentPane().add(panel_main);//内容面板         
         this.setVisible(true);//显示窗体
    }
    
    

    private void registerListener(){
    	
    	btn_register.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e){
    			UserRegisterView urView=new UserRegisterView();//弹出注册窗口
//    			panel_main.add(urView);//把指定的视图添加到桌面容器中
//    			urView.toFront();//视图显示在最前面	
    			LoginView.this.dispose();
    		}
    		
    	});
    	
    	btn_login.addActionListener(new ActionListener() {
    		@Override//快捷重写
    		public void actionPerformed(ActionEvent e){
    			//获取用户名和密码
    			String uname=tf_uname.getText().trim();//获取文本框内容，去掉两个空格
    			String upass=new String(pf_upass.getPassword());
    			int type=cb_type.getSelectedIndex()+1;//普通用户1管理员2
    			if(uname.equals("")){
    				JOptionPane.showMessageDialog(LoginView.this,"用户名不能为空"); //JOptionPane消息框 ,父容器LoginView               
    			    return;
    		    }else if(upass.equals("")){
    		    	JOptionPane.showMessageDialog(LoginView.this," 密码不能为空");               
    			    return;
    		    }
				
    			User user =new User(uname,upass,type);//封装成User对象    
    		    user = userBiz.login(user);//调用业务层方法 ,查看比对有没有此用户
    			 if(user!=null){
    				//普通用户
    				if(user.getType()==1){
    					new UserMainView();
    				}else{
    					new HAdminMainView();//管理员
    				}
    				LoginView.this.dispose();
    			}else{
    		    	JOptionPane.showMessageDialog(LoginView.this,"用户名或密码或类型出错");               

    			}
    		}
    	});
    	
    }
    
    
    
}



