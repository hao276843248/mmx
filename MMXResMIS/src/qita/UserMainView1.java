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
	private JMenuBar menuBar=null;//�˵���
	
	private JPanel panel_left=null;//���
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
    
    private JSplitPane splitPane=null;//�ָ�������
     
    private JMenu yzMenu=null;//�û�ע��
    private JMenu ydMenu=null;//�û���¼
 
    private JMenuItem yzMenuItem=null;//�û�ע��
    private JMenuItem ydMenuItem=null;//�û���¼
    
    private JLabel lb_gonggao=null;
	private JLabel lb_lianxi=null;
	private JLabel lb_tel=null;
	private JLabel lb_addr=null;
	
    
    private JLabel deskLabel1=null;//���ͼƬ��Label
    private JLabel deskLabel2=null;
    private JLabel deskLabel3=null;
    private JLabel deskLabel4=null;
    private JLabel deskLabel5=null;//���ͼƬ��Label
    private JLabel deskLabel6=null;
    private JLabel deskLabel7=null;
    private JLabel deskLabel8=null;
    private JLabel deskLabel9=null;//���ͼƬ��Label
    private JLabel deskLabel10=null;
    private JLabel deskLabel11=null;
    private JLabel deskLabel12=null;
    private JLabel deskLabel13=null;//���ͼƬ��Label
    private JLabel deskLabel14=null;
    
    private JPopupMenu popupMenu;
	private JMenuItem kaitai=null;//��̨
	private JMenuItem cancelkaitai=null;//ȡ����̨
	private JMenuItem orderitem=null;//���/�Ӳ�
	private JMenuItem xiaofeichaxun=null;//���Ѳ�ѯ
	private JMenuItem jiezhang=null;//����
	
    public UserMainView1(){
    	init();
    	registerListener();
    }
    
    private void init(){
    	//��ʼ���˵�,���
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
    	
    
    	//��ʼ���ָ���
    	splitPane=new JSplitPane();
//    	splitPane.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
//    	splitPane.setContinuousLayout(true);//���û������ָ���ʱϵͳ�����»�ͼ��???û��Ӱ��
    	splitPane.setDividerSize(10);//���÷ָ��ߴ�СΪ10����λ     ������
    	
    	popupMenu = new JPopupMenu();
    	
		//��ʼ���˵�
    	yzMenu=new JMenu("�û�ע��");
    	ydMenu=new JMenu("�û���¼");
    	
    	yzMenuItem=new JMenuItem("�û�ע��");
    	ydMenuItem=new JMenuItem("�û���¼");
    	
    	//��ʼ����ǩ
		lb_gonggao=new JLabel("����");
		lb_lianxi=new JLabel("��ϵ����");
		lb_lianxi.setFont(new Font("����",Font.BOLD,20));//��������
		lb_lianxi.setForeground(Color.red);//������ɫ
		lb_tel=new JLabel("�绰:15612494925");
		lb_tel.setFont(new Font("����",Font.BOLD,15));
		lb_addr=new JLabel("��ַ:�ӱ����ʴ�ѧ");
		lb_addr.setFont(new Font("����",Font.BOLD,15));
		
		 kaitai = new JMenuItem("��̨");
		 cancelkaitai = new JMenuItem("ȡ����̨");
		 orderitem = new JMenuItem("��/�Ӳ�");
		 xiaofeichaxun = new JMenuItem("���Ѳ�ѯ");
		 jiezhang = new JMenuItem("����");
		
		//�ѿؼ��ӵ���Ӧ��λ����
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
    	
		splitPane.setLeftComponent(panel_left);//��panel_left�ŵ��ָ�����ߣ�panel_right�ŵ��ұ�
    	splitPane.setRightComponent(panel_right);

    	this.getContentPane().add(splitPane);
    	this.setJMenuBar(menuBar);
    	setBounds(800,120,880,420);//setBounds(x,y,width,height)
     	this.setTitle("��С�Ͳ�������ϵͳ");
    	this.setResizable(false);//���ɸı䴰���С
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);//������ʾ
        this.setVisible(true);
    	
    	splitPane.setDividerLocation(0.3);//���ұ�����С
    	splitPane.setEnabled(false);//�ָ��߲��������ƶ�
    }

 
    private void registerListener(){
    	yzMenuItem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				UserRegisterView urv=new UserRegisterView();
				panel_right.add(urv);//��ָ������ͼ��ӵ�����������
				urv.toFront();//��ͼ��ʾ����ǰ��				
			}   		
    	});
    	
    	ydMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginView lView=new LoginView();
				panel_right.add(lView);//��ָ������ͼ��ӵ�����������
				lView.toFront();//��ͼ��ʾ����ǰ��				
			}    		
    	});
 
    	kaitai.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				KaitaiView ktv=new KaitaiView();
				panel_right.add(ktv);//��ָ������ͼ��ӵ�����������
				ktv.toFront();//��ͼ��ʾ����ǰ��				
			}   		
    	});
    	
//    	cancelkaitai.addActionListener(new ActionListener(){ 	
//    			@Override
//    			public void actionPerformed(ActionEvent e) {
//    				KaitaiView ktv=new KaitaiView();
//    				panel_right.add(ktv);//��ָ������ͼ��ӵ�����������
//    				ktv.toFront();//��ͼ��ʾ����ǰ��				
//    			}   		
//        	});
    	
    	orderitem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				Order_itemView oim=new Order_itemView();
				panel_right.add(oim);//��ָ������ͼ��ӵ�����������
				oim.toFront();//��ͼ��ʾ����ǰ��				
			}   		
    	});
    	
//    	xiaofeichaxun.addActionListener(new ActionListener(){ 	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Order_itemView oim=new Order_itemView();
//				panel_right.add(oim);//��ָ������ͼ��ӵ�����������
//				oim.toFront();//��ͼ��ʾ����ǰ��				
//			}   		
//    	});
    	
    	jiezhang.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				JiezhangView jzv=new JiezhangView();
				panel_right.add(jzv);//��ָ������ͼ��ӵ�����������
				jzv.toFront();//��ͼ��ʾ����ǰ��				
			}   		
    	});
    	
    	
    }

    
    
}
