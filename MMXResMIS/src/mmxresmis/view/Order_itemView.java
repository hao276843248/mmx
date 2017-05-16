package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class Order_itemView extends JFrame	 {
	private static final long serialVersionUID = 2123698427305956225L;
//  private JPanel btn_panel=null;//按钮组面板
    private JPanel panel_left=null;
    private JPanel panel_right=null;
    private JPanel panel1=null;
    private JPanel panel2=null;
    private JPanel panel3=null;
    private JPanel panel4=null;
    private JPanel panel5=null;
  
    private JSplitPane splitPane=null;//分割容器类
    
    private JTree tree=null;//树
    private DefaultTreeModel treeModel=null;//树模型
    private DefaultMutableTreeNode root =null;//根节点
    private DefaultMutableTreeNode node1 =null;//子节点1
    private DefaultMutableTreeNode node2 =null;//子节点2
    private DefaultMutableTreeNode node3 =null;//子节点3
    private DefaultMutableTreeNode node4 =null;//子节点4
    private DefaultMutableTreeNode node5 =null;//子节点5
    
    
	private JLabel lb_foodnum;//菜号标签
	private JLabel lb_foodname;
	private JLabel lb_wnum;
	private JLabel lb_beizhu;
	private JLabel lb_foodprice;
	private JLabel lb_foodsum;
	private JLabel lb_foodallprice;
	
	private JTextField tf_foodnum=null;//菜号下拉列表框
	private JTextField tf_foodname=null;
	private JTextField tf_wnum=null; 
	private JTextField tf_beizhu=null;
	private JTextField tf_foodprice=null;
	private JTextField tf_foodsum=null;
	private JTextField tf_foodallprice=null;
	
	private JButton btn_equal=null;//等于按钮
	private JButton btn_insert=null;//新增按钮
	private JButton btn_delete=null;
	private JButton btn_submit=null;
	private JButton btn_exit=null;
	
	private DefaultTableModel tableModel =null;//表格模型
	private JTable table=null;//表格对象
	private JScrollPane scrollPane =null;//滚动面板
	
	//private JLabel deskLabel=null;
	
	public Order_itemView(){
		init();
//		registerListener();
	}
		
	private void init(){
		this.setSize(880,420);//设置窗体大小
		this.setResizable(false);//不可拖动窗体大小
//		this.setClosable(true);//窗体可被关闭
//		this.setIconifiable(true);//JInternalFrame内嵌窗体，窗体可最小化
//		this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("点/加菜窗口");// 设置标题
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出关闭窗体功能
		
		
		 //初始化根节点和子节点
        root = new DefaultMutableTreeNode("菜单");
        node1 = new DefaultMutableTreeNode("凉菜");
        node2 = new DefaultMutableTreeNode("烧菜");
        node3 = new DefaultMutableTreeNode("炒菜");
        node4 = new DefaultMutableTreeNode("素菜");
        node5 = new DefaultMutableTreeNode("汤");

        //利用根节点创建TreeModel
        treeModel = new DefaultTreeModel(root);
        //插入子节点node1,node2,node3,node4,node5
        treeModel.insertNodeInto(node1, root, root.getChildCount());
        treeModel.insertNodeInto(node2, root, root.getChildCount());
        treeModel.insertNodeInto(node3, root, root.getChildCount());
        treeModel.insertNodeInto(node4, root, root.getChildCount());
        treeModel.insertNodeInto(node5, root, root.getChildCount());
        
        //创建节点node1的子节点并插入
        DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("青椒皮蛋");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("爽口木耳");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("凉拌三丝");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("油酥花生米");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("红油耳片");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        
        //创建节点node2的子节点并插入 
        leafnode = new DefaultMutableTreeNode("土豆烧牛肉");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("干烧鱼");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("糖醋排骨");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("毛血旺");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("水煮肉片");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        
        leafnode = new DefaultMutableTreeNode("辣子鸡丁");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("白灼虾");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("甜椒肉丝");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("金沙玉米");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("京酱肉丝");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        
        leafnode = new DefaultMutableTreeNode("家常豆腐");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("番茄炒蛋");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("鱼香茄子");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("虎皮青椒");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("炝炒藕丁");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        
        leafnode = new DefaultMutableTreeNode("荤三鲜");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("酸菜粉丝汤");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("紫菜蛋花汤");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("冬瓜连锅汤");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("番茄煎蛋汤");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        
        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setRowHeight(20);
        
     //创建节点绘制对象
       DefaultTreeCellRenderer cellRenderer = 
       	                  (DefaultTreeCellRenderer)tree.getCellRenderer();
       //设置字体
       cellRenderer.setFont(new Font("Serif", Font.PLAIN, 14));
       cellRenderer.setBackgroundNonSelectionColor(Color.white);
       cellRenderer.setBackgroundSelectionColor(Color.yellow);
       cellRenderer.setBorderSelectionColor(Color.red);
       
       //设置选时或不选时，文字的变化颜色
       cellRenderer.setTextNonSelectionColor(Color.black);
       cellRenderer.setTextSelectionColor(Color.blue);
             
	    
	    //初始化面板
	    panel_left=new JPanel(new GridLayout(1,1,0,0));
		panel_right=new JPanel(new GridLayout(6,1,5,10));//后两个参数表格水平垂直间距
		panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2=new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3=new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4=new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5=new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//初始化分割线
    	splitPane=new JSplitPane();
    	splitPane.setDividerSize(10);//设置分隔线大小
		
		//初始化控件
		lb_foodnum=new JLabel("菜号");
		lb_foodname=new JLabel("菜名");
		lb_wnum=new JLabel("服务员号");
		lb_beizhu=new JLabel("备注");
		lb_foodprice=new JLabel("单价");
		lb_foodsum=new JLabel("*数量");
		lb_foodallprice=new JLabel("总价");
		
		tf_foodnum=new JTextField(8);
		tf_foodname=new JTextField(8);
		tf_wnum=new JTextField(8);
		tf_beizhu=new JTextField(8);
		tf_foodprice=new JTextField(8);
		tf_foodsum=new JTextField(8);
		tf_foodallprice=new JTextField(8);
		
		btn_equal=new JButton("=");
		btn_insert=new JButton("新增");
		btn_delete=new JButton("删除");
		btn_submit=new JButton("提交");
		btn_exit=new JButton("退出");
		
//		//分别设置水平和垂直滚动条自动出现  
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
        String[] columnNames = {"菜号","菜名","服务员号","单价","数量","总价"};//定义表格列名数组	       
        String[][] tableValues ={{"从","结束","点菜","的","点击","但V"},{"从","结束","点菜","的","点击","但V"},{"从","结束","点菜","的","点击","但V"}}; //表格单元值
        tableModel =new DefaultTableModel(tableValues,columnNames);//创建制定列名和数据的表格
	    table=new JTable(tableModel);
        scrollPane=new JScrollPane(table);//创建显示表格的滚动面板
        
	    //把空间驾到相应位置上
		panel1.add(lb_foodnum);
		panel1.add(tf_foodnum);
		panel1.add(lb_foodname);
		panel1.add(tf_foodname);
		panel2.add(lb_wnum);
		panel2.add(tf_wnum);
		panel2.add(lb_beizhu); 
		panel2.add(tf_beizhu);
		panel3.add(lb_foodprice);
		panel3.add(tf_foodprice);
		panel3.add(lb_foodsum);
		panel3.add(tf_foodsum);
		panel3.add(btn_equal);
		panel3.add(lb_foodallprice);
		panel3.add(tf_foodallprice);
		panel4.add(btn_insert);
		panel4.add(btn_delete);
		panel4.add(btn_submit);
		panel4.add(btn_exit);
		panel5.add(scrollPane,BorderLayout.CENTER);
		 
		 panel_left.add(tree);
		 panel_right.add(panel1);
		 panel_right.add(panel2);
		 panel_right.add(panel3);
		 panel_right.add(panel4);
		 panel_right.add(panel5);
		 
		 splitPane.setLeftComponent(panel_left);//将panel_left放到分割线左边，panel_right放到右边
	     splitPane.setRightComponent(panel_right);
		 this.getContentPane().add(splitPane);//内容面板		
		 this.setVisible(true);//显示窗体
		 
		 splitPane.setDividerLocation(0.3);//左右比例大小
//	     splitPane.setEnabled(false);//分割线不可左右移动
	}

	private void registerListener(){
				   btn_delete.addActionListener(new ActionListener(){ 	
						@Override
						public void actionPerformed(ActionEvent e) {
							int[] seleteRows=table.getSelectedRows();	
							for(int row=0;row<seleteRows.length;row++){
								tableModel.removeRow(seleteRows[row]- row);
						} 
						}
			   	});
				   
				   btn_submit.addActionListener(new ActionListener(){ 	
						@Override
						public void actionPerformed(ActionEvent e) {
							String[] rowValues={tf_foodnum.getText(),tf_foodname.getText(),tf_wnum.getText(),
									tf_foodprice.getText(),tf_foodsum.getText(),tf_foodallprice.getText()};
							tableModel.addRow(rowValues);
							tf_foodnum.setText(null);
							tf_foodname.setText(null);
							tf_wnum.setText(null);
							tf_foodprice.setText(null);
							tf_foodsum.setText(null);
							tf_foodallprice.setText(null);				
						} 			
			  	});
			   }	
	
}
