

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
import mmxresmis.view.LoginView;

public class UserRegisterView extends JFrame {
	private static final long serialVersionUID = -7833876902065687456L;
	private JFrame frame=null;
	private JPanel panel_main=null;//�����
	private JPanel panel1=null;
	private JPanel panel2=null;
	private JPanel panel3=null;
	private JPanel panel4=null;
	private JPanel panel5=null;
	private JPanel panel6=null;
	
	private JLabel lb_name=null;
	private JLabel lb_init_pass=null;
	private JLabel lb_confirm_pass=null;
	private JLabel lb_type=null;//��½���ͱ�ǩ
	
	private JTextField tf_uname=null;
	private JPasswordField userPsssInit=null;
	private JPasswordField userPassConfirm=null;
	private JTextField tf_type=null;
	
	private JButton btn_confirm=null;//ȷ�ϰ�ť
	private JButton btn_back=null;//���ذ�ť
	private UserBiz userBiz=null;//�������ҵ���
	private UserDao userDao=null;
	
	register_db regist;
	
	public UserRegisterView(){
		userDao=new UserDaoImpl();
    	userBiz=new UserBizImpl();//������Ӧ�û�ҵ������
		init();
//		registerListener();
	}
	
	private void init(){
		regist = new register_db();
		
		
		tf_uname=new JTextField(15);
		userPsssInit=new JPasswordField(15);
		userPassConfirm=new JPasswordField(15);
		tf_type=new JTextField(15);	
		
		btn_confirm=new JButton("ȷ���ύ");
		btn_back=new JButton("����");
		
		lb_name=new JLabel("�û���");
		lb_name.setFont(new Font("����",Font.BOLD,15));//��������
		lb_init_pass=new JLabel("��ʼ������");
		lb_init_pass.setFont(new Font("����",Font.BOLD,15));//��������
		lb_confirm_pass=new JLabel("ȷ������");
		lb_confirm_pass.setFont(new Font("����",Font.BOLD,15));//��������
		lb_type=new JLabel("����");
		
		panel_main=new JPanel(new GridLayout(6,1));//�����
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
		
		btn_confirm.addActionListener(regist);
		btn_back.addActionListener(regist);
		
		
		regist.setaccountField(tf_uname);
		regist.setnameField(userPsssInit);
		regist.setaccountField(userPassConfirm);
		regist.setnameField(tf_type);	
		regist.setokButton(btn_confirm);
		regist.setresetButton(btn_back);
		
		this.getContentPane().add(panel_main);
		this.setTitle("�û�ע�ᴰ��");
		setBounds(300,120,600,220);//setBounds(x,y,width,height)
//		this.setClosable(true);//����ɱ��ر�
//		this.setIconifiable(true);//JInternalFrame��Ƕ���壬�������С��
		this.setResizable(false);//���ɸı䴰���С
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);;//����رհ�ť���������˳�
//		this.getRootPane().setDefaultButton(btn_back);//Ĭ�ϻ�ý���İ�ť
		
//		table=new JTable();
//		paneltable=new JPanel(new BorderLayout());
//		paneltable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null,null)));
//		paneltable.add(table);
//		this.add(paneltable,BorderLayout.CENTER);
		
		
		
		this.setVisible(true);
		
	}
	
	 
	 
}





