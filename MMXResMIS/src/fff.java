import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import mmxresmis.dao.impl.BaseDao;


public class fff  extends JFrame {
	private BaseDao basedao;
	private JPanel panel=null;//���
	private JPanel panel1=null;//���
	private JPanel panel2=null;//���
	
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;
	private JButton btn_add;//��Ӱ�ť
	private JButton btn_del;//ɾ����ť
	
	 public fff(){
//	    	init();
//	    	registerListener();
	    }
	 
	 private void init(){
		 setTitle("����Ա�������");
		   	setBounds(200,120,880,500);//setBounds(x,y,width,height)
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳��رմ��幦��  	   
			setLayout(null);
			
			scpDemo = new JScrollPane();
		    scpDemo.setBounds(10,50,300,270);
			btnShow = new JButton("��ѯ");
			btnShow.setBounds(10,10,60,30);
			btn_add=new JButton("���");//����û�
			btn_add.setBounds(110,10,60,30);
			btn_del=new JButton("ɾ��");//����û�
			btn_del.setBounds(200,10,60,30);
			
			
			panel=new  JPanel(new  GridLayout(2,10,0,20));
	        panel1=new JPanel();
	        panel2=new JPanel();
	        panel1 .add(scpDemo);
	        panel1 .add(btnShow);
	        panel2 .add(btn_add);
	        panel2 .add(btn_del);
		    panel.add(panel1);
		    panel.add(panel2);
		    getContentPane().add(panel,BorderLayout.SOUTH);
		    
		 // ��ʾ����
		    this.setVisible(true);
		    
		    
		    String sql = "select * from users";
		    
		    int count = 0;
		    
		    // ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		    Object[][] info = new Object[count][4];
		    count = 0;
		    while(rs.next()){
		    info[count][0] = Integer.valueOf( rs.getInt("id"));
		    info[count][1] = rs.getString("Uname");
		    info[count][2] = Integer.valueOf( rs.getInt("upass") );
		    info[count][3] = rs.getString("type");
		    count++;
		    }
	 
//	 private void registerListener(){
//		 btn_del.addActionListener(new ActionListener(){ 	
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					int[] seleteRows=table.getSelectedRows();	
//					for(int row=0;row<seleteRows.length;row++){
//						tableModel.removeRow(seleteRows[row]- row);
//				} 
//				}
//	   	});
//	 }
	 
	 }	 	

