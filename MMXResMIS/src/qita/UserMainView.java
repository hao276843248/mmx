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
//    private JPanel main_panel=null; //�����
//    private JPanel wel_panel=null;//��ӭ���
//    private JPanel btn_panel=null;//��ť�����
//    private JDesktopPane funDesktop=null;//��������ҵ�����,����ɷ���Ƕ�Ĵ��壬�����ǹ������
//    
//    private JButton btn_query_rent_dvd=null;//��ѯ���ް�ť
//    private JButton btn_dvd_record=null;//�鿴���޼��ఴť
//    private JButton btn_exit=null;//�˳���ť
//    private JLabel lb_welcome=null;//��ӭ����
//    private JLabel deskLabel=null;//���ͼƬ��Label
//    public UserMainView(){
//    	init();
//    }
//    
//    private void init(){
//    	main_panel=new JPanel(new BorderLayout());//�齫�����ֹ�����
//    	btn_panel=new JPanel(new GridLayout(7,1,0,35));//��񲼾ֹ�����
//    	btn_query_rent_dvd=new JButton("DVD��ѯ���޲���");
//    	btn_dvd_record =new JButton("DVD���޼�¼��ѯ");
//    	btn_exit=new  JButton("�˳�����");
//    	//�������ı�ǩ�ؼ�
//    	btn_panel.add(new JLabel());
//    	btn_panel.add(new JLabel());
//    	btn_panel.add(btn_query_rent_dvd);
//    	btn_panel.add(btn_dvd_record);
//    	btn_panel.add(btn_exit);
//    	btn_panel.add(new JLabel());
//    	btn_panel.add(new JLabel());
//        //�������ı߿����
//    	btn_panel.setBorder(BorderFactory.createTitledBorder(
//    			BorderFactory.createRaisedBevelBorder(),"��ݹ�����"));//б��ͻ�𣬱���
//    	
//    	//��ʼ����ӭ���
//    	wel_panel=new JPanel();
//    	lb_welcome=new JLabel("��   ӭ   ʹ  ��  ��  ��  ��  ��  ��  ϵ  ͳ");
//    	lb_welcome.setFont(new Font("����",Font.BOLD,23));//��������֣�23��
//    	lb_welcome.setForeground(Color.BLUE);
//    	wel_panel.add(lb_welcome);
//    	
//    	//��ʼ���������
//    	funDesktop=new JDesktopPane();
//    	ImageIcon image=new ImageIcon("src/images/resmis.jpg");
//    	deskLabel=new JLabel(image);
//    	deskLabel.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
//    	funDesktop.add(deskLabel,new Integer(Integer.MIN_VALUE));//��Сֵ����ײ�
//    	
//    	main_panel.add(btn_panel,BorderLayout.EAST);
//    	main_panel.add(wel_panel,BorderLayout.NORTH);
//    	main_panel.add(funDesktop,BorderLayout.CENTER);
//    	//��ֹ����
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
//    	this.setTitle("��������ϵͳ");
//    	this.getContentPane().add(main_panel);
//    	this.setSize(1000, 650);
//    	this.setVisible(true);
//    	this.setResizable(false);//���ɸı䴰���С
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
//        this.setLocationRelativeTo(null);//������ʾ
//    	
//    }
//    
//    
// // ����һ���̣߳��û�ӭLabel��ǩ���������ƶ�
//     
//    private class DynaminThread implements Runnable/*��̬�ֳ�ʵ��Runnable�ӿ�*/{
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
