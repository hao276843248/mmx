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
	private JPanel panel=null;//面板
	private JPanel panel1=null;//面板
	private JPanel panel2=null;//面板
	
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private JButton btnShow;
	private JButton btn_add;//添加按钮
	private JButton btn_del;//删除按钮
	
	 public fff(){
//	    	init();
//	    	registerListener();
	    }
	 
	 private void init(){
		 setTitle("服务员管理界面");
		   	setBounds(200,120,880,500);//setBounds(x,y,width,height)
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭窗体功能  	   
			setLayout(null);
			
			scpDemo = new JScrollPane();
		    scpDemo.setBounds(10,50,300,270);
			btnShow = new JButton("查询");
			btnShow.setBounds(10,10,60,30);
			btn_add=new JButton("添加");//添加用户
			btn_add.setBounds(110,10,60,30);
			btn_del=new JButton("删除");//添加用户
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
		    
		 // 显示窗体
		    this.setVisible(true);
		    
		    
		    String sql = "select * from users";
		    
		    int count = 0;
		    
		    // 将查询获得的记录数据，转换成适合生成JTable的数据形式
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

