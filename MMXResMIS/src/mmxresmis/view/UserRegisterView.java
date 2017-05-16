package mmxresmis.view;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mmxresmis.biz.UserBiz;
import mmxresmis.biz.impl.UserBizImpl;
import mmxresmis.dao.UserDao;
import mmxresmis.dao.impl.UserDaoImpl;
import mmxresmis.entity.User;

public class UserRegisterView extends JFrame {
	private static final long serialVersionUID = -7833876902065687456L;
	private JFrame frame=null;
	private JPanel panel_main=null;//主面板
	private JPanel panel1=null;
	private JPanel panel2=null;
	private JPanel panel3=null;
	private JPanel panel4=null;
	private JPanel panel5=null;
	private JPanel panel6=null;
	
	private JLabel lb_name=null;
	private JLabel lb_init_pass=null;
	private JLabel lb_confirm_pass=null;
	private JLabel lb_type=null;//登陆类型标签
	
	private JTextField tf_uname=null;
	private JPasswordField userPsssInit=null;
	private JPasswordField userPassConfirm=null;
	private JTextField tf_type=null;
	
	private JButton btn_confirm=null;//确认按钮
	private JButton btn_back=null;//返回按钮
	private UserBiz userBiz=null;//调用相关业务层
	private UserDao userDao=null;
	
	public UserRegisterView(){
		userDao=new UserDaoImpl();
    	userBiz=new UserBizImpl();//产生对应用户业务层对象
		init();
		registerListener();
	}
	
	private void init(){
		tf_uname=new JTextField(15);
		userPsssInit=new JPasswordField(15);
		userPassConfirm=new JPasswordField(15);
		tf_type=new JTextField(15);	
		
		btn_confirm=new JButton("确认提交");
		btn_back=new JButton("返回");
		
		lb_name=new JLabel("用户名");
		lb_name.setFont(new Font("宋体",Font.BOLD,15));//设置字体
		lb_init_pass=new JLabel("初始化密码");
		lb_init_pass.setFont(new Font("宋体",Font.BOLD,15));//设置字体
		lb_confirm_pass=new JLabel("确认密码");
		lb_confirm_pass.setFont(new Font("宋体",Font.BOLD,15));//设置字体
		lb_type=new JLabel("类型");
		
		panel_main=new JPanel(new GridLayout(6,1));//主面板
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
	    
		panel2.add(lb_name);
		panel2.add(tf_uname);
		panel3.add(lb_init_pass);
		panel3.add(userPsssInit);
		panel4.add(lb_confirm_pass);
		panel4.add(userPassConfirm);
		panel5.add(lb_type);
		panel5.add(tf_type);
		panel6.add(btn_confirm);
		panel6.add(btn_back);
	 
		panel_main.add(panel1);
		panel_main.add(panel2);
		panel_main.add(panel3);
		panel_main.add(panel4);
		panel_main.add(panel5);
		panel_main.add(panel6);
		
		this.getContentPane().add(panel_main);
		this.setTitle("用户注册窗口");
		setBounds(300,120,600,220);//setBounds(x,y,width,height)
//		this.setClosable(true);//窗体可被关闭
//		this.setIconifiable(true);//JInternalFrame内嵌窗体，窗体可最小化
		this.setResizable(false);//不可改变窗体大小
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;//点击关闭按钮，本窗体退出
//		this.getRootPane().setDefaultButton(btn_back);//默认获得焦点的按钮
		
//		table=new JTable();
//		paneltable=new JPanel(new BorderLayout());
//		paneltable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null,null)));
//		paneltable.add(table);
//		this.add(paneltable,BorderLayout.CENTER);
		
		
		
		this.setVisible(true);
		
	}
	
	 private void registerListener(){
		 btn_confirm.addActionListener(new ActionListener() {
	    		@Override//快捷重写
	    		public void actionPerformed(ActionEvent e){
	    			String uname=tf_uname.getText();
	    			String upass=new String(userPsssInit.getPassword());
	    			userPassConfirm.getPassword();
	    			int type=tf_type.getSelectionEnd();//普通用户1管理员2  ?leixing 
	    			if(uname.equals("")){
	    				JOptionPane.showMessageDialog(UserRegisterView.this,"用户名不能为空"); //JOptionPane消息框 ,父容器LoginView               
	    			    return;
	    		    }else if(upass.equals("")){
	    		    	JOptionPane.showMessageDialog(UserRegisterView.this," 密码不能为空");               
	    			    return;
	    		    }else if(userPassConfirm.equals("")){
	    		    	JOptionPane.showMessageDialog(UserRegisterView.this," 确认密码不能为空");               
	    			    return;
	    		    }
//	    		    else if(type.equ("")){
//	    		    	JOptionPane.showMessageDialog(UserRegisterView.this," 类型不能为空");               
//	    			    return;
//	    		    }
	    			User  user =new User();
	    			user = userDao.queryUser1(null);
	    			user.setUname(uname);
	    	    	user.setUpass(new String(upass));
	    	    	user.setType(type);
//	    	    	Arrays.fill(lb_confirm_pass, '0');
//	    	    	Arrays.fill(btn_confirm, '0');
	    			if(userDao.queryUser1(user)!=null){
	    	    		JOptionPane.showMessageDialog(UserRegisterView.this,"用户注册成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
	    	    		return;
	    	    	}else{
	    	    		JOptionPane.showMessageDialog(UserRegisterView.this,"用户注册失败","警告信息",JOptionPane.INFORMATION_MESSAGE);
	    	    		return;
	    	    	}
	    			
////	    			User user =new User(uname,upass,type);//封装成User对象    
//	    			    User  user =new User();
//		    	    	user.setUname(uname);
//		    	    	user.setUpass(new String());
//		    	    	user.setType(type);
//		    	    	Arrays.fill(lb_confirm_pass, '0');
//		    	    	Arrays.fill(btn_confirm, '0');
//		    	    	if(UserDao.saveUser(user)){
//		    	    		JOptionPane.showMessageDialog(UserRegisterView.this,"用户注册成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
//		    	    		return;
//		    	    	}else{
//		    	    		JOptionPane.showMessageDialog(UserRegisterView.this,"用户注册成功","警告信息",JOptionPane.INFORMATION_MESSAGE);
//		    	    		return;
//		    	    	}
	    			
//	    		    user = userBiz.r(user);//调用业务层方法 ,查看比对有没有此用户
//	    		    else if(userPsssInit!=userPassConfirm){
//	    				JOptionPane.showMessageDialog(UserRegisterView.this,"初始密码和确认密码不一致");
//	    				return;
//	    			}
//	    			//User user =new User(uname,upass,type);//封装成User对象    ？没有导入包	    			
//	    			if(uname==null){
//	    				uname=tf_uname.getText();
//	    				
//		    	    	
//	    			}
	    			
//	    			 btn_add.addActionListener(new ActionListener(){ 	
//	    					@Override
//	    					public void actionPerformed(ActionEvent e) {
//	    						String[] rowValues={textField1.getText(),textField2.getText(),
//	    							textField3.getText(),textField4.getText(),textField5.getText()};
//	    						tableModel.addRow(rowValues);
//	    						textField1.setText(null);
			
//	    					} 	
		 
		 
	    					
//	    		    user =new User();
//	    	    	user.setUname(uname);
//	    	    	user.setUpass(new String(lb_confirm_pass));
//	    	    	user.setType(type);
//	    	    	Arrays.fill(lb_confirm_pass, '0');
//	    	    	Arrays.fill(btn_confirm, '0');
//	    	    	if(DBHelper.save(user)){
//	    	    		JOptionPane.showMessageDialog(UserRegisterView.this,"用户注册成功","提示信息",JOptionPane.INFORMATION_MESSAGE);
//	    	    		return;
//	    	    	}else{
//	    	    		JOptionPane.showMessageDialog(UserRegisterView.this,"用户注册成功","警告信息",JOptionPane.INFORMATION_MESSAGE);
//	    	    		return;
//	    	    	}
//	    		    
	    		    
	    		    
	    		}
	    	});
		 
		 btn_back.addActionListener(new ActionListener() {
	    		@Override
	    		public void actionPerformed(ActionEvent e){
			        	LoginView lView=new LoginView();
			        	UserRegisterView.this.dispose();
			        }
    		
	    	});
		 
	 }
}





