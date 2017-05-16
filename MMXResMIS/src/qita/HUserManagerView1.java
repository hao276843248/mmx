package qita;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import mmxresmis.biz.UserBiz;
import mmxresmis.biz.impl.UserBizImpl;
import mmxresmis.entity.User;

public class HUserManagerView1 extends JInternalFrame {
	private static final long serialVersionUID = -4733113410758843245L;
//    private DefaultTableModel tableModel =null;//���ģ��
    private JTable table=null;
    private JPanel panel=null;//���
	private JPanel panel1=null;//���
	private JPanel panel2=null;//���
	private JPanel panel3=null;//���
    private JScrollPane scrollPane=null;
	
    private JLabel label1=null;
	private JLabel label2=null;
	private JLabel label3=null;
	
	private JTextField textField1=null;
	private JTextField textField2=null;

	private JComboBox<String> cb_type=null;//��¼���������б�� 

	private JButton btn_query=null;//��ѯ��ť
	private JButton btn_add=null;//��Ӱ�ť
	private JButton btn_del=null;//ɾ����ť
	private UserBiz userBiz=null;//�������ҵ���
	private List<User> uList=null;
	private UserInfoTableModel infoTableModel=null;
	
public HUserManagerView1(){	
	    userBiz=new UserBizImpl();//������Ӧ�û�ҵ������
	    init();
	    registerListener();
	    }
	
private void init(){
//	    Vector<Vector<Object>> dataVector=new Vector<Vector<Object>>();
//	    String[] columnNames = {"�� ��(uname)","�� ��(upass)","����(type)"};//��������������
//	    String[][] tableValues ={{"sss","111","1",}};
//        tableModel =new DefaultTableModel(tableValues,columnNames);//�����ƶ����������ݵı��
//	    table=new JTable(tableModel);
//        scrollPane=new JScrollPane(table);//������ʾ���Ĺ������
//        getContentPane().add(scrollPane,BorderLayout.CENTER);
	
	
	    table=new JTable();
	    uList=new ArrayList<User>();
        //��JTable������ģ�ͳ�������
	    refreshTable(uList);
        label1=new JLabel("uname"); 
        label2=new JLabel("upass"); 
        label3=new JLabel("type"); 
        
        
        textField1=new JTextField(5);
        textField2=new JTextField(5);
        
        cb_type=new JComboBox<String>(new String []{"��ͨ�û�","����Ա"});
        
        btn_query=new JButton("��ѯ���û�");
        btn_add=new JButton("������û�");//����û�
        btn_del=new JButton("ɾ�����û�");//����û�
        
        panel=new  JPanel(new  GridLayout(3,10,0,20));
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();

        panel1 .add(table);
        panel2 .add(label1);
        panel2 .add(textField1);
        panel2 .add(label2);
        panel2 .add(textField2);
        panel2 .add(label3);
        panel2 .add(cb_type);
        panel3 .add(btn_query);
        panel3 .add(btn_add);
        panel3 .add(btn_del);
	    panel.add(panel1);
	    panel.add(panel2);
	    panel.add(panel3);
	    getContentPane().add(panel,BorderLayout.CENTER);
	    
    	setTitle("��Ա�������");
    	setBounds(200,120,560,420);//setBounds(x,y,width,height)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳��رմ��幦��
        this.setVisible(true);
    }
private void registerListener(){
//	btn_query.addActionListener(new ActionListener(){ 	
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String uname=textField1.getText().trim();//��ȡ�ı������ݣ�ȥ�������ո�
//			String upass=textField2.getText().trim();
//			int type=cb_type.getSelectedIndex()+1;//��ͨ�û�1����Ա2
//			
//			int flag=JOptionPane.showInternalConfirmDialog(HUserManagerView.this,"�Ƿ�ȷ������û���",
//					"ȷ����Ϣ",JOptionPane.YES_NO_OPTION);
//			if(flag==JOptionPane.YES_OPTION){
//				User user =new User(uname,upass,type);//��װ��User����    
//    		    user = userBiz.queryUser2();//����ҵ��㷽�� ,�鿴�ȶ���û�д��û�
//				if(res){
//					JOptionPane.showInternalMessageDialog(HUserManagerView.this," ��ӳɹ�"); 
//				}else{
//					JOptionPane.showInternalMessageDialog(HUserManagerView.this," ���ʧ��"); 
//				}
//			}
//		} 
//		
//	});
//	   btn_del.addActionListener(new ActionListener(){ 	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int[] seleteRows=table.getSelectedRows();	
//				for(int row=0;row<seleteRows.length;row++){
//					tableModel.removeRow(seleteRows[row]- row);
//			} 
//			}
// 	});
	
	
//	btn_del.addActionListener(new ActionListener(){ 	
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			int[] seleteRows=table.getSelectedRows();	
//			for(int row=0;row<seleteRows.length;row++){
//				tableModel.removeRow(seleteRows[row]- row);
//		} 
//		}
//	});
	
	btn_query.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				uList=userBiz.queryAllUser();
				refreshTable(uList);
				btn_del.setEnabled(false);
				if(uList.size()==0){
    		    	JOptionPane.showInternalMessageDialog(HUserManagerView1.this," û�����ѯ������");               

				}
			}
	});
	   
	   btn_add.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uname=textField1.getText().trim();//��ȡ�ı������ݣ�ȥ�������ո�
    			String upass=textField2.getText().trim();
    			int type=cb_type.getSelectedIndex()+1;//��ͨ�û�1����Ա2
    			
    			if(uname.equals("")){
    				JOptionPane.showInternalMessageDialog(HUserManagerView1.this,"�û�������Ϊ��"); //JOptionPane��Ϣ�� ,������LoginView               
    			    return;
    		    }else if(upass.equals("")){
    		    	JOptionPane.showInternalMessageDialog(HUserManagerView1.this," ���벻��Ϊ��");               
    			    return;
    		    }
    			int flag=JOptionPane.showInternalConfirmDialog(HUserManagerView1.this,"�Ƿ�ȷ������û���",
    					"ȷ����Ϣ",JOptionPane.YES_NO_OPTION);
    			if(flag==JOptionPane.YES_OPTION){
    				boolean res=userBiz.addUser(new User(uname,upass,type));
    				if(res){
    					JOptionPane.showInternalMessageDialog(HUserManagerView1.this," ��ӳɹ�"); 
    				}else{
    					JOptionPane.showInternalMessageDialog(HUserManagerView1.this," ���ʧ��"); 
    				}
    			}
    			
			} 			
	});
	
  }	
     
private class UserInfoTableModel implements TableModel{
	private List<User> uList=null;
	public UserInfoTableModel(List<User> uList){
		this.uList=uList;
	}
	
	//JTable��ʾ ����
	@Override
	public int getRowCount() {
		return uList.size();
	}

	//JTable���ݵ�����
	@Override
	public int getColumnCount() {
		return 4;
	}

	//����JTable����ʾ������
	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex==0){
			return "�û�id";
		}else if(columnIndex==1){
			return "�û���";
		}else if(columnIndex==2){
			return "����";
		}else if(columnIndex==3){
			return "����";
		}else{
			return "����";
		}				
	}

	
	//JTable �е���������
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	//���õ�Ԫ���Ƿ�ɱ༭
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	//��ȡJTable���ƶ���Ԫ�������
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user=uList.get(rowIndex);
		if(columnIndex==0){
			return user.getId();
		}else if(columnIndex==1){
			return user.getUname();
		}else if(columnIndex==2){
			return user.getUpass();
		}else if(columnIndex==3){
			return user.getType();
//			return  ""+ (user.getType()==1?"��ͨ�û�":"����Ա");
		}else{
		    return "����";
		}
	}

	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
}


private void refreshTable(List<User> uList){
	infoTableModel=new UserInfoTableModel(uList);
	table.setModel(infoTableModel);
	
}








}
