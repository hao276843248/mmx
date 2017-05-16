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
//    private DefaultTableModel tableModel =null;//表格模型
    private JTable table=null;
    private JPanel panel=null;//面板
	private JPanel panel1=null;//面板
	private JPanel panel2=null;//面板
	private JPanel panel3=null;//面板
    private JScrollPane scrollPane=null;
	
    private JLabel label1=null;
	private JLabel label2=null;
	private JLabel label3=null;
	
	private JTextField textField1=null;
	private JTextField textField2=null;

	private JComboBox<String> cb_type=null;//登录类型下拉列表框 

	private JButton btn_query=null;//查询按钮
	private JButton btn_add=null;//添加按钮
	private JButton btn_del=null;//删除按钮
	private UserBiz userBiz=null;//调用相关业务层
	private List<User> uList=null;
	private UserInfoTableModel infoTableModel=null;
	
public HUserManagerView1(){	
	    userBiz=new UserBizImpl();//产生对应用户业务层对象
	    init();
	    registerListener();
	    }
	
private void init(){
//	    Vector<Vector<Object>> dataVector=new Vector<Vector<Object>>();
//	    String[] columnNames = {"姓 名(uname)","密 码(upass)","类型(type)"};//定义表格列名数组
//	    String[][] tableValues ={{"sss","111","1",}};
//        tableModel =new DefaultTableModel(tableValues,columnNames);//创建制定列名和数据的表格
//	    table=new JTable(tableModel);
//        scrollPane=new JScrollPane(table);//创建显示表格的滚动面板
//        getContentPane().add(scrollPane,BorderLayout.CENTER);
	
	
	    table=new JTable();
	    uList=new ArrayList<User>();
        //让JTable绑定数据模型呈现数据
	    refreshTable(uList);
        label1=new JLabel("uname"); 
        label2=new JLabel("upass"); 
        label3=new JLabel("type"); 
        
        
        textField1=new JTextField(5);
        textField2=new JTextField(5);
        
        cb_type=new JComboBox<String>(new String []{"普通用户","管理员"});
        
        btn_query=new JButton("查询新用户");
        btn_add=new JButton("添加新用户");//添加用户
        btn_del=new JButton("删除此用户");//添加用户
        
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
	    
    	setTitle("会员管理界面");
    	setBounds(200,120,560,420);//setBounds(x,y,width,height)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭窗体功能
        this.setVisible(true);
    }
private void registerListener(){
//	btn_query.addActionListener(new ActionListener(){ 	
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String uname=textField1.getText().trim();//获取文本框内容，去掉两个空格
//			String upass=textField2.getText().trim();
//			int type=cb_type.getSelectedIndex()+1;//普通用户1管理员2
//			
//			int flag=JOptionPane.showInternalConfirmDialog(HUserManagerView.this,"是否确认添加用户？",
//					"确认信息",JOptionPane.YES_NO_OPTION);
//			if(flag==JOptionPane.YES_OPTION){
//				User user =new User(uname,upass,type);//封装成User对象    
//    		    user = userBiz.queryUser2();//调用业务层方法 ,查看比对有没有此用户
//				if(res){
//					JOptionPane.showInternalMessageDialog(HUserManagerView.this," 添加成功"); 
//				}else{
//					JOptionPane.showInternalMessageDialog(HUserManagerView.this," 添加失败"); 
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
    		    	JOptionPane.showInternalMessageDialog(HUserManagerView1.this," 没有你查询的内容");               

				}
			}
	});
	   
	   btn_add.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String uname=textField1.getText().trim();//获取文本框内容，去掉两个空格
    			String upass=textField2.getText().trim();
    			int type=cb_type.getSelectedIndex()+1;//普通用户1管理员2
    			
    			if(uname.equals("")){
    				JOptionPane.showInternalMessageDialog(HUserManagerView1.this,"用户名不能为空"); //JOptionPane消息框 ,父容器LoginView               
    			    return;
    		    }else if(upass.equals("")){
    		    	JOptionPane.showInternalMessageDialog(HUserManagerView1.this," 密码不能为空");               
    			    return;
    		    }
    			int flag=JOptionPane.showInternalConfirmDialog(HUserManagerView1.this,"是否确定添加用户？",
    					"确认信息",JOptionPane.YES_NO_OPTION);
    			if(flag==JOptionPane.YES_OPTION){
    				boolean res=userBiz.addUser(new User(uname,upass,type));
    				if(res){
    					JOptionPane.showInternalMessageDialog(HUserManagerView1.this," 添加成功"); 
    				}else{
    					JOptionPane.showInternalMessageDialog(HUserManagerView1.this," 添加失败"); 
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
	
	//JTable显示 行数
	@Override
	public int getRowCount() {
		return uList.size();
	}

	//JTable数据的列数
	@Override
	public int getColumnCount() {
		return 4;
	}

	//设置JTable的显示的列名
	@Override
	public String getColumnName(int columnIndex) {
		if(columnIndex==0){
			return "用户id";
		}else if(columnIndex==1){
			return "用户名";
		}else if(columnIndex==2){
			return "密码";
		}else if(columnIndex==3){
			return "类型";
		}else{
			return "出错";
		}				
	}

	
	//JTable 列的数据类型
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	//设置单元格是否可编辑
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	//获取JTable中制定单元格的数据
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
//			return  ""+ (user.getType()==1?"普通用户":"管理员");
		}else{
		    return "出错";
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
