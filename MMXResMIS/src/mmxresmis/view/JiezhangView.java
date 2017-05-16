package mmxresmis.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JiezhangView extends JFrame {
	private static final long serialVersionUID = -1062640286971674349L;
	private JPanel panel_main=null;//�����
	private JPanel panel1=null;
	private JPanel panel2=null;
	private JPanel panel3=null;
	private JPanel panel4=null;
	private JPanel panel5=null;
	private JPanel panel6=null;
	
	
	private JTextArea ta_xianshi=null;
    private JScrollPane sp=null;//������
	
    private JLabel lb_roombjf;//����ѱ�ǩ
	private JLabel lb_yingshou;
	private JLabel lb_shishou;
	private JLabel lb_zhaoling;
	
	private JTextField tf_roombjf;//������ı���
	private JTextField tf_yingshou;
	private JTextField tf_shishou;
	private JTextField tf_zhaoling;
	
	private JButton btn_jiezhang=null;//���˰�ť
	private JButton btn_exit=null;
	
	public JiezhangView(){
		init();
	}
		
	private void init(){
		this.setSize(700,420);//���ô����С
		this.setResizable(false);//�������϶������С
//		this.setIconifiable(true);//JInternalFrame��Ƕ���壬�������С��
//		this.setClosable(true);//����ɱ��ر�
//		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("���˴���");// ���ñ���
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�˳��رմ��幦��
		//this.pack();//��������
	
		
		//��ʼ�����
	    panel_main=new JPanel(new GridLayout(6,1));//Ĭ����ʽ������
	    //panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
	    panel1=new JPanel();
	    panel2=new JPanel();
		//panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3=new JPanel();
		//panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4=new JPanel();
		//panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5=new JPanel();
		//panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel6=new JPanel();
		
		
		//��ʼ���ؼ�
		lb_roombjf=new JLabel("�����");
		lb_yingshou=new JLabel("Ӧ�տ�");
		lb_shishou=new JLabel("ʵ�տ�");
		lb_zhaoling=new JLabel("�� ��");
		
		tf_roombjf=new JTextField(8);
		tf_yingshou=new JTextField(8);
		tf_shishou=new JTextField(8);
		tf_zhaoling=new JTextField(8);
		
		btn_jiezhang=new JButton("����");
		btn_exit=new JButton("ȡ��");
		
		ta_xianshi=new JTextArea(5,50); 
		sp=new JScrollPane(ta_xianshi);
		
		
		panel1.add(sp);
		panel2.add(lb_roombjf);
		panel2.add(tf_roombjf);
		panel3.add(lb_yingshou);
		panel3.add(tf_yingshou);
		panel4.add(lb_shishou);
		panel4.add(tf_shishou);
		panel5.add(lb_zhaoling);
		panel5.add(tf_zhaoling);
		panel6.add(btn_jiezhang);
		panel6.add(btn_exit);
		
		
		panel_main.add(panel1);
	    panel_main.add(panel2);
	    panel_main.add(panel3);
		panel_main.add(panel4);
		panel_main.add(panel5);
		panel_main.add(panel6);
		 
		this.getContentPane().add(panel_main);//�������
		this.setVisible(true);//��ʾ����
		}
	
	
	
	
}