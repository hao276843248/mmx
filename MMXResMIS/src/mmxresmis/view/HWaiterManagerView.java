package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class HWaiterManagerView extends JFrame {
	private static final long serialVersionUID = -3087334473783381282L;
	private DefaultTableModel tableModel =null;//���ģ��
	private JTable table=null;//������
	private JPanel panel=null;//���
	private JPanel panel1=null;//���
	private JPanel panel2=null;//���
	private JScrollPane scrollPane =null;//�������
	
	private JLabel label1=null;
	private JLabel label2=null;
	private JLabel label3=null;
	private JLabel label4=null;
	private JLabel label5=null;
	private JLabel label6=null;
	
	
	private JTextField textField1=null;
	private JTextField textField2=null;
	private JTextField textField3=null;
	private JTextField textField4=null;
	private JTextField textField5=null;
	private JTextField textField6=null;
	
	private JButton btn_add=null;//��Ӱ�ť
	private JButton btn_del=null;//ɾ����ť
		
    public HWaiterManagerView(){
    	init();
    	registerListener();
    }
	
    private void init(){
        String[] columnNames = {"����Ա��(wid)","����(wnum)","�� ��(wname)","�Ա�(wsex)","����(wage)","�绰(wtel)"};//��������������	       
        String[][] tableValues ={{"��","����","���","��","���","��V"}}; //���Ԫֵ
        tableModel =new DefaultTableModel(tableValues,columnNames);//�����ƶ����������ݵı��
	    table=new JTable(tableModel);
        scrollPane=new JScrollPane(table);//������ʾ���Ĺ������
        getContentPane().add(scrollPane,BorderLayout.CENTER);
        
        label1=new JLabel("wid"); 
        label2=new JLabel("wnum"); 
        label3=new JLabel("wname"); 
        label4=new JLabel("wsex"); 
        label5=new JLabel("wage"); 
        label6=new JLabel("wtel");      
        
        textField1=new JTextField(5);
        textField2=new JTextField(5);
        textField3=new JTextField(10);
        textField4=new JTextField(5);
        textField5=new JTextField(5);
        textField6=new JTextField(10);
        
        btn_add=new JButton("����·���Ա");//����û�
        btn_del=new JButton("ɾ���˷���Ա");//����û�
        
        panel=new  JPanel(new  GridLayout(2,10,0,20));
        panel1=new JPanel();
        panel2=new JPanel();
        panel1 .add(label1);
        panel1 .add(textField1);
        panel1 .add(label2);
        panel1 .add(textField2);
        panel1 .add(label3);
        panel1 .add(textField3);
        panel1 .add(label4);
        panel1 .add(textField4);
        panel1 .add(label5);
        panel1 .add(textField5);
        panel1 .add(label6);
        panel1 .add(textField6);
        panel2 .add(btn_add);
        panel2 .add(btn_del);
	    panel.add(panel1);
	    panel.add(panel2);
	    getContentPane().add(panel,BorderLayout.SOUTH);
	    
	    setTitle("����Ա�������");
	   	setBounds(200,120,880,500);//setBounds(x,y,width,height)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳��رմ��幦��  	   
	    this.setVisible(true);
    }    
	
   private void registerListener(){
	   btn_del.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] seleteRows=table.getSelectedRows();	
				for(int row=0;row<seleteRows.length;row++){
					tableModel.removeRow(seleteRows[row]- row);
					
					
			} 
			}
   	});
	   
	   btn_add.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] rowValues={textField1.getText(),textField2.getText(),textField3.getText(),
						textField4.getText(),textField5.getText(),textField6.getText()};
				tableModel.addRow(rowValues);
				textField1.setText(null);
				textField2.setText(null);
				textField3.setText(null);
				textField4.setText(null);
				textField5.setText(null);
				textField6.setText(null);				
			} 			
  	});
	   
  }
    
}


//   ������������β������´��ڴ�����β���������,û�к����ݿ����ӣ����ʱ����ÿ����������


