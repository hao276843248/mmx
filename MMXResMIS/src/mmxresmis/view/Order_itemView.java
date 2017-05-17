package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import mmxresmis.biz.FoodBiz;
import mmxresmis.biz.FoodtypeBiz;
import mmxresmis.biz.GuestfoodBiz;
import mmxresmis.biz.impl.FoodBizImpl;
import mmxresmis.biz.impl.FoodtypeBizImpl;
import mmxresmis.biz.impl.GuestfoodBizImpl;
import mmxresmis.entity.Food;
import mmxresmis.entity.Foodtype;
import mmxresmis.entity.Guestfood;
import mmxresmis.entity.Zhuotai;

public class Order_itemView extends JInternalFrame {
	private static final long serialVersionUID = 2123698427305956225L;
	private JPanel panel_left = null;//左面板
	private JPanel panel_right = null;
	private JPanel paneldiancai = null;
	private JPanel panelbutton = null;
	private JPanel panelxiangqing = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;

	private JSplitPane splitPane = null;// 分割容器类

	private JTree tree = null;// 树
	private DefaultTreeModel treeModel = null;// 树模型
	private DefaultMutableTreeNode root = null;// 根节点

	private JLabel lb_foodnum;// 菜号标签
	private JLabel lb_foodname;//菜名
	private JLabel lb_wnum;//服务员号
	private JLabel lb_beizhu;//备注
	private JLabel lb_foodprice;//菜品单价
	private JLabel lb_foodsum;//数量
	private JLabel lb_foodallprice;//总价

	private JTextField tf_foodnum = null;// 菜号文本框
	private JTextField tf_foodname = null;
	private JTextField tf_wnum = null;
	private JTextField tf_beizhu = null;
	private JTextField tf_foodprice = null;
	private JTextField tf_foodsum = null;
	private JTextField tf_foodallprice = null;

	private JButton btn_equal = null;// 等于按钮
	private JButton btn_insert = null;// 新增按钮
	private JButton btn_delete = null;//删除
	private JButton btn_submit = null;//确认
	private JButton btn_exit = null;//退出

	private DefaultTableModel tableModel = null;// 表格模型
	private JTable table = null;// 表格对象
	private JScrollPane scrollPane = null;// 滚动面板

	private List<Food> foods = null;
	private List<Foodtype> foodtypes = null;
	private FoodtypeBiz foodtypeBiz = new FoodtypeBizImpl();
	private FoodBiz foodBiz = new FoodBizImpl();
	private Zhuotai zhuotai=null;
	private UserFoodInfoTableModel infoTableModel=null;
	private GuestfoodBiz guestfoodBiz=new  GuestfoodBizImpl();
	private List<Guestfood> gfList=null;		
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取当前日期
	
	// private JLabel deskLabel=null;

	public Order_itemView(Zhuotai zhuotai) {
		this.zhuotai=zhuotai;
		init();
		registerListener();
	}

	private void init() {
//		this.setSize(950, 600);// 设置窗体大小
		this.setResizable(false);// 不可拖动窗体大小
		this.setClosable(true);//窗体可被关闭
		this.setIconifiable(true);//JInternalFrame内嵌窗体，窗体可最小化
		// this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("点/加菜窗口");// 设置标题
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 退出关闭窗体功能

		foods = foodBiz.findAllFood();
		foodtypes = foodtypeBiz.findallFoodtype();
		// 初始化根节点和子节点
		root = new DefaultMutableTreeNode("菜单");
		// 利用根节点创建TreeModel
		treeModel = new DefaultTreeModel(root);

		for (Foodtype foodtype : foodtypes) {
			// 设置子节点
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(foodtype.getFoodtype());
			treeModel.insertNodeInto(node, root, root.getChildCount());
			for (Food food : foods) {
				// 如果菜品类型为子节点类型则添加菜品
				if (food.getFoodtype().equals(foodtype.getFoodtype())) {
					DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode(food.getFoodname());
					treeModel.insertNodeInto(leafnode, node, node.getChildCount());
				}
			}
		}

		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setRowHeight(20);
		tree.addTreeSelectionListener(treeSelect());

		// 创建节点绘制对象
		DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
		// 设置字体
		cellRenderer.setFont(new Font("Serif", Font.PLAIN, 14));
		cellRenderer.setBackgroundNonSelectionColor(Color.white);
		cellRenderer.setBackgroundSelectionColor(Color.yellow);
		cellRenderer.setBorderSelectionColor(Color.red);

		// 设置选时或不选时，文字的变化颜色
		cellRenderer.setTextNonSelectionColor(Color.black);
		cellRenderer.setTextSelectionColor(Color.blue);
		
		
		
		// 初始化面板
		panel_left = new JPanel(new GridLayout(1, 1, 0, 0));	
		panel_right =new JPanel(new BorderLayout());
		
		// 初始化分割线
		splitPane = new JSplitPane();
		splitPane.setDividerSize(10);// 设置分隔线大小

		// 初始化控件
		lb_foodnum = new JLabel("菜号");
		lb_foodname = new JLabel("菜名");
		lb_wnum = new JLabel("服务员号");
		lb_beizhu = new JLabel("备注");
		lb_foodprice = new JLabel("单价");
		lb_foodsum = new JLabel("*数量(默认为1)");
		lb_foodallprice = new JLabel("总价");

		tf_foodnum = new JTextField(8);
		tf_foodnum.setEditable(false);
		tf_foodname = new JTextField(8);
		tf_foodname.setEditable(false);
		tf_wnum = new JTextField(8);
		tf_wnum.setText(zhuotai.getWname());
		tf_wnum.setEditable(false);
				
		tf_beizhu = new JTextField(8);
		tf_foodprice = new JTextField(8);
		tf_foodprice.setEditable(false);
		tf_foodsum = new JTextField(8);
		tf_foodallprice = new JTextField(8);
		tf_foodallprice.setEditable(false);
		
		btn_equal = new JButton("=");
		btn_insert = new JButton("新增");
		btn_delete = new JButton("删除");
		btn_submit = new JButton("提交");
		btn_exit = new JButton("退出");

		// //分别设置水平和垂直滚动条自动出现
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

//		String[] columnNames = { "菜号", "菜名", "服务员号", "单价", "数量", "总价" };// 定义表格列名数组
//		String[][] tableValues = { { "从", "结束", "点菜", "的", "点击", "但V" }, { "从", "结束", "点菜", "的", "点击", "但V" },
//				{ "从", "结束", "点菜", "的", "点击", "但V" } }; // 表格单元值
//		tableModel = new DefaultTableModel(tableValues, columnNames);// 创建制定列名和数据的表格

		gfList=guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
		table = new JTable();
		// 让JTable绑定数据模型呈现数据
		refreshTable();
		scrollPane = new JScrollPane(table);// 创建显示表格的滚动面板
		scrollPane.setPreferredSize(new Dimension(400,200));
		
		paneldiancai = new JPanel(new GridLayout(3, 1, 5, 10));	
		panel_right.add(paneldiancai, BorderLayout.NORTH);
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel1.add(btn_insert);
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
		
		paneldiancai.add(panel1);
		paneldiancai.add(panel2);
		paneldiancai.add(panel3);
		
		panelbutton = new JPanel(new GridLayout(1, 4, 5, 10));	
		panel_right.add(panelbutton, BorderLayout.CENTER);
		panelbutton.add(btn_insert);
		panelbutton.add(btn_delete);
		panelbutton.add(btn_submit);
		panelbutton.add(btn_exit);
		
		panelxiangqing = new JPanel(new BorderLayout());
		panelxiangqing.add(scrollPane);
		panel_right.add(panelxiangqing,BorderLayout.SOUTH);
		
		panel_left.add(tree);
		tf_foodsum.addFocusListener(focus());
		
		splitPane.setLeftComponent(panel_left);// 将panel_left放到分割线左边，panel_right放到右边
		splitPane.setRightComponent(panel_right);
		this.getContentPane().add(splitPane);// 内容面板
		this.setVisible(true);// 显示窗体

		splitPane.setDividerLocation(0.2);// 左右比例大小
		// splitPane.setEnabled(false);//分割线不可左右移动
	}

	private void registerListener() {
		btn_delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] seleteRows = table.getSelectedRows();
				List<Guestfood> fd=new ArrayList<>();
				for (int row = 0; row < seleteRows.length; row++) {
					fd.add(gfList.get(seleteRows[row]));
				}
				for (Guestfood food : fd) {
					if(null==food.getGdatetime() || "".equals(food.getGdatetime())){
						guestfoodBiz.delGuestfood(food.getGid());
					}else{
						JOptionPane.showMessageDialog(null, "此条菜品已提交不可删除！", "警告",JOptionPane.WARNING_MESSAGE);  
					}
					
				}
				refreshTable();
			}
		});

		btn_insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if("".equals(tf_foodname.getText())){
					JOptionPane.showMessageDialog(null, "您未选菜品！");  
				}else{
					if("".equals(tf_foodsum.getText().trim())){
						tf_foodsum.setText("1");
					}
					int count=Integer.valueOf(tf_foodsum.getText().trim());
					int price=Integer.valueOf(tf_foodprice.getText().trim());
					tf_foodallprice.setText(count*price+"");
					Guestfood guestfood =new Guestfood();
					guestfood.setBeizhu(tf_beizhu.getText());
					guestfood.setFoodallprice(new BigDecimal(tf_foodallprice.getText()));;
					guestfood.setFoodname(tf_foodname.getText());
					guestfood.setFoodnum(tf_foodnum.getText());
					
					guestfood.setFoodprice(new BigDecimal(tf_foodprice.getText()));
					guestfood.setFoodsum(tf_foodsum.getText());
					guestfood.setZhuotainum(zhuotai.getZhuotainum());
					guestfood.setWname(tf_wnum.getText());
					guestfoodBiz.addGuestfood(guestfood);
					refreshTable();
				}
			}
		});
		
		btn_submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "确定提交此桌台订单?") == JOptionPane.YES_OPTION){
					for (Guestfood gf : gfList) {
						if(null==gf.getGdatetime()){
							gf.setGdatetime(formatter.format(new Date()));
							guestfoodBiz.updateGuestfood(gf);
							refreshTable();
						}
					}
				}
				
			}
		});
		btn_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flg=false;
				for (Guestfood gf : gfList) {
					if(null==gf.getGdatetime()){
						flg=true;
					}
				}
				if(flg){
					if(JOptionPane.showConfirmDialog(null, "还有未提交订单,确定退出菜单?") == JOptionPane.YES_OPTION){
						close();
					}
				}else{
					close();
				}
			}
		});
		
		
	}

	/**
	 * 选中的菜监听事件
	 * **/
	private TreeSelectionListener treeSelect(){
			return  new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				TreePath selectionPath = tree.getSelectionPath();
				for (Food food : foods) {
					if(food.getFoodname().equals(selectionPath.getLastPathComponent().toString())){
						tf_foodnum.setText(food.getFoodnum());
						tf_foodname.setText(food.getFoodname());
						tf_foodprice.setText(food.getFoodprice().toString());
						
					}
				}
				
			}
		};
	 }
	
	/**
	 * 计算每份菜总价钱
	 * **/
	public FocusListener focus(){
		return new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if("".equals(tf_foodsum.getText().trim())){
					tf_foodsum.setText("1");
				}
				int count=Integer.valueOf(tf_foodsum.getText().trim());
				int price=Integer.valueOf(tf_foodprice.getText().trim());
				tf_foodallprice.setText(count*price+"");
//				System.out.println("失去");
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
//				System.out.println("获得");
			}
		}; 
	}
	
	
	private class UserFoodInfoTableModel implements TableModel {
		private List<Guestfood> fList = null;

		public UserFoodInfoTableModel(List<Guestfood> fList) {
			this.fList = fList;
		}

		// JTable显示 的数据行数
		@Override
		public int getRowCount() {
			return fList.size();
		}

		// JTable数据的列数
		@Override
		public int getColumnCount() {
			return 7;
		}

		// 设置JTable的显示的列名 菜号", "菜名", "服务员号", "单价", "数量", "总价" 
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "菜号";
			} else if (columnIndex == 1) {
				return "菜名";
			} else if (columnIndex == 2) {
				return "服务员号";
			}else if (columnIndex == 3) {
				return "单价";
			}else if (columnIndex == 4) {
				return "数量";
			}else if (columnIndex == 5) {
				return "总价";
			}else if (columnIndex == 6) {
				return "提交时间";
			}else {
				return "出错";
			}
		}

		// JTable 列的数据类型
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		// 设置单元格是否可编辑
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		// 获取JTable中制定单元格的数据
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Guestfood food = fList.get(rowIndex);
			if (columnIndex == 0) {
				return food.getFoodnum();
			} else if (columnIndex == 1) {
				return food.getFoodname();
			} else if (columnIndex == 2) {
				return food.getWname();
			} else if (columnIndex == 3) {
				return food.getFoodprice();
			} else if (columnIndex == 4) {
				return food.getFoodsum();
			} else if (columnIndex == 5) {
				return food.getFoodallprice();
			} else if (columnIndex == 6) {
				return food.getGdatetime();
			} else {
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

	// 刷新JTable并显示数据
	private void refreshTable() {
		gfList=guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
		infoTableModel = new UserFoodInfoTableModel(gfList);
		table.setModel(infoTableModel);
	}
	/**
	 * 关闭窗口 
	 * **/
	private void close(){
		this.dispose();
	}
	
}
