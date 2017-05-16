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
	private JPanel main_panel=null; //�����
	private JPanel panel1=null;
	private JPanel panel2=null;
	private JPanel panel3=null;
	private JPanel panel4=null;
	//private JPanel panel5=null;
	
	private JLabel lb_title=null;//�����ǩ
	private JLabel lb_allpingjia=null;//��������
	private JLabel lb_allfeeling=null;//�������
	private JLabel lb_tishi=null;//��ʾ

	private JTextArea tf_allfeeling=null;//��������ı���
	
	private JButton btn_submit=null;//�ύ��ť
	
	public PingjiaView(){
		init();
	}
	
	private void init(){
		this.setSize(640,300);//���ô����С
		this.setResizable(false);//�����϶������С
		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("���۴���");// ���ñ�ǩ
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳��رմ��幦��
		//this.pack();//��������
	    this.setVisible(true);//��ʾ����
		
		//��ʼ���ؼ�
				tf_allfeeling=new JTextArea("��������",5,25);
				tf_allfeeling.setText("jk");
				//contentTextArea.setText(updateRow.get(6).toString());
				
				
				btn_submit=new JButton("�ύ");
				//btn_submit.setBounds(10,80,80,25);		
				lb_title=new JLabel("2017.3.2017-3-15 11:45:07�Ķ���",SwingConstants.LEFT);//��ô��ȡ��ǰ���۵�ʱ�䣿
				//lb_title.setBounds(new Rectangle(0, 180, 100, 40));
				lb_allpingjia=new JLabel("��������",JLabel.LEFT);//��ô����
				lb_allpingjia.setBounds(0,0,12,12);
				 lb_allfeeling=new JLabel("�������",SwingConstants.LEFT);
				lb_tishi=new JLabel("*�ύ�����޸�");
		
		//��ʼ�����
		main_panel=new JPanel(new GridLayout(4,1));
		panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2=new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3=new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4=new JPanel();
		//panel5=new JPanel();
		
		
		
		//����Ӧ�Ŀؼ��ŵ������ȥ
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
	    this.setVisible(true);//��ʾ����

	}
}
