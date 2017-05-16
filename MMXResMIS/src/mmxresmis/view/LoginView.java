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
	private JPanel panel_main=null;//�����
    private JPanel panel_left=null;//������
    private JPanel panel_right =null;//�Ҳ����
    
    private JLabel lb_uname=null;//�û���ǩ
    private JLabel lb_upass=null;//�����ǩ
    private JLabel lb_type=null;//��½���ͱ�ǩ
    
    private JTextField tf_uname=null;//�û��ı���
    private JPasswordField pf_upass=null;//�����ı���
    
    private JLabel lb_img=null;//��ʾͼƬ�ı�ǩ
    
    private JButton btn_login=null;//��¼��ť
    private JButton btn_register=null;//ע�ᰴť
    
    private JComboBox<String> cb_type=null;//��¼���������б�� 
    private UserBiz userBiz=null;//�������ҵ���
    
    public LoginView(){
    	userBiz=new UserBizImpl();//������Ӧ�û�ҵ������
    	init();//���췽�����ã��������¼���ڶ���ʱ����ʼ����Ӧ�Ŀؼ����Դﵽ��ʾ�����Ч��
    	registerListener();
    	
    }
    
    
    //��ʼ������ؼ��ķ���
    private void init(){
    	setBounds(200,120,660,320);//setBounds(x,y,width,height)
    	this.setResizable(false);//�����϶������С
    	
//    	this.setClosable(true);//����ɱ��ر�
//		this.setIconifiable(true);//JInternalFrame��Ƕ���壬�������С��
//    	this.setLocationRelativeTo(null);//���������ʾ
    	this.setTitle("��¼����");// ���ñ���
    	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�˳��رձ����幦��
    	
    	//��ʼ�����
    	panel_main=new JPanel(new GridLayout(1,2));//�����һ�����еı��
    	panel_left=new JPanel();//Ĭ����ʽ������
    	panel_right=new JPanel(new GridLayout(4,2,0,10));//�������������ˮƽ��ֱ���
    	
    	//��ʼ���ؼ�
    	 tf_uname=new JTextField(8);//����8
    	 pf_upass=new JPasswordField(8);
    	 cb_type=new JComboBox<String>(new String []{"��ͨ�û�","����Ա"});
    	 btn_login=new JButton("��¼");
    	 btn_register=new JButton("ע��");
    	 lb_uname=new JLabel("��  ��:",JLabel.CENTER);
    	 lb_upass=new JLabel("��  ��:",JLabel.CENTER);
    	 lb_type=new JLabel("��  ��:",JLabel.CENTER);
         lb_img=new JLabel(new ImageIcon(
        		 ClassLoader.getSystemResource("images/a_1.jpg")));//������������ҵ�src�ļ���

         
         //����Ӧ�Ŀؼ��ŵ������ȥ
         panel_left.add(lb_img);
         panel_right.add(lb_uname);
         panel_right.add(tf_uname);         
         panel_right.add(lb_upass);
         panel_right.add(pf_upass);
         panel_right.add(lb_type);
         panel_right.add(cb_type);
         panel_right.add(btn_login);
         panel_right.add(btn_register);
         
         
         //������з������������
         panel_main.add(panel_left);
         panel_main.add(panel_right);
         
         //�ٰ������ŵ�������
         this.getContentPane().add(panel_main);//�������         
         this.setVisible(true);//��ʾ����
    }
    
    

    private void registerListener(){
    	
    	btn_register.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e){
    			UserRegisterView urView=new UserRegisterView();//����ע�ᴰ��
//    			panel_main.add(urView);//��ָ������ͼ��ӵ�����������
//    			urView.toFront();//��ͼ��ʾ����ǰ��	
    			LoginView.this.dispose();
    		}
    		
    	});
    	
    	btn_login.addActionListener(new ActionListener() {
    		@Override//�����д
    		public void actionPerformed(ActionEvent e){
    			//��ȡ�û���������
    			String uname=tf_uname.getText().trim();//��ȡ�ı������ݣ�ȥ�������ո�
    			String upass=new String(pf_upass.getPassword());
    			int type=cb_type.getSelectedIndex()+1;//��ͨ�û�1����Ա2
    			if(uname.equals("")){
    				JOptionPane.showMessageDialog(LoginView.this,"�û�������Ϊ��"); //JOptionPane��Ϣ�� ,������LoginView               
    			    return;
    		    }else if(upass.equals("")){
    		    	JOptionPane.showMessageDialog(LoginView.this," ���벻��Ϊ��");               
    			    return;
    		    }
				
    			User user =new User(uname,upass,type);//��װ��User����    
    		    user = userBiz.login(user);//����ҵ��㷽�� ,�鿴�ȶ���û�д��û�
    			 if(user!=null){
    				//��ͨ�û�
    				if(user.getType()==1){
    					new UserMainView();
    				}else{
    					new HAdminMainView();//����Ա
    				}
    				LoginView.this.dispose();
    			}else{
    		    	JOptionPane.showMessageDialog(LoginView.this,"�û�������������ͳ���");               

    			}
    		}
    	});
    	
    }
    
    
    
}



