package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import mmxresmis.biz.WaiterBiz;
import mmxresmis.biz.impl.WaiterBizImpl1;
import mmxresmis.entity.Waiter;

public class HWaiterManagerView extends JInternalFrame {
	private static final long serialVersionUID = -3087334473783381282L;
	private JPanel paneltable=null;//面板
	private JPanel panelnr = null;// neirong面板11111111111
	private JPanel panelBtoon = null;// 按钮组面板
	private JScrollPane scrollPane =null;//滚动面板
	private JTable table=null;//表格对象
	private JButton btn_add=null;//添加按钮
	private JButton btn_del=null;//删除按钮
	private JLabel lb_wnum=null;//服务员号标签 
	private JLabel lb_wname=null;
	private JLabel lb_wsex=null;
	private JLabel lb_wage=null;
	private JLabel lb_wtel=null; 
	private JTextField tf_wnum=null;//服务员文本框  
	private JTextField tf_wname=null;
	private JTextField tf_wsex=null;
	private JTextField tf_wage=null;
	private JTextField tf_wtel=null;
	
	private WaiterBiz waiterbiz = new WaiterBizImpl1();
	private List<Waiter> waiter = new ArrayList<>();
//	private WaiterBiz waiterBiz = null;// 调用相关业务层
//	private List<Waiter> wList = null;
	private WaiterInfoTableModel infoTableModel = null;
		
    public HWaiterManagerView(){
//    	waiterBiz = new WaiterBizImpl1();// 产生对应用户业务层对象
    	init();
//    	registerListener();
    }
    
    private void init() {
        setTitle("服务员管理界面");
//	   	setBounds(200,120,880,500);//setBounds(x,y,width,height)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出关闭窗体功能  	   
		this.setIconifiable(true);
		this.setClosable(true);
		this.setLayout(new BorderLayout());
		waiter =waiterbiz.findallWaiter();

//		waiter = new ArrayList<Waiter>();
		table = new JTable();
		// 让JTable绑定数据模型呈现数据
		refreshTable(waiter);
		
		paneltable = new JPanel(new BorderLayout());// 创建面板
//		table = new JTable();
		// 给面板设置边框
		Border btable = (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "服务员信息"));
		paneltable.setBorder(btable);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200,200));
		paneltable.add(jsp);
		this.add(paneltable,BorderLayout.NORTH);
		
		panelBtoon = new JPanel(new GridLayout(1, 2, 10, 20));
		panelBtoon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "查询条件"));
		this.add(panelBtoon, BorderLayout.SOUTH);
		btn_add = new JButton("添加服务员");// 添加用户
		panelBtoon.add(btn_add);
		btn_del = new JButton("删除此服务员");// 添加用户
		panelBtoon.add(btn_del);
		
		panelnr = new JPanel(new GridLayout(1, 10, 0, 10));
		panelnr.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "内容"));
		this.add(panelnr, BorderLayout.CENTER);
		lb_wnum = new JLabel("服务员号");
		panelnr.add(lb_wnum);
		tf_wnum = new JTextField(5);
		panelnr.add(tf_wnum);
		lb_wname = new JLabel("服务员名");
		panelnr.add(lb_wname);
		tf_wname = new JTextField(5);
		panelnr.add(tf_wname);
		lb_wsex = new JLabel("性别");
		panelnr.add(lb_wsex);
		tf_wsex = new JTextField(5);
		panelnr.add(tf_wsex);	
		lb_wage = new JLabel("年龄");
		panelnr.add(lb_wage);
		tf_wage = new JTextField(5);
		panelnr.add(tf_wage);	
		lb_wtel = new JLabel("电话");
		panelnr.add(lb_wtel);
		tf_wtel = new JTextField(5);
		panelnr.add(tf_wtel);
		
		this.setVisible(true);	
    }
	
   private void registerListener(){
		btn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int wid = (Integer) table.getValueAt(row, 0);
				int flag = JOptionPane.showInternalConfirmDialog(HWaiterManagerView.this, "是否确定删除此服务员？", "确认信息",
						JOptionPane.YES_NO_OPTION);
				if (flag == JOptionPane.YES_OPTION) {
					boolean res = waiterbiz.delWaiter(wid);
					if (res) {
						JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, " 删除成功");
					} else {
						JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, " 删除失败");
					}
				}

			}
		}); 
		
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRow() != -1) {
					btn_del.setEnabled(true);
				}
				int row = table.getSelectedRow();// 得到你选中那行的下标
				String wnum = table.getValueAt(row, 1).toString();
				String wname = table.getValueAt(row, 2).toString();
				String wsex = table.getValueAt(row, 3).toString();
				String wage = table.getValueAt(row, 4).toString();
				String wtel = table.getValueAt(row, 5).toString();
				tf_wnum.setText(wnum);
				tf_wname.setText(wname);
				tf_wsex.setText(wsex);
				tf_wage.setText(wage);
				tf_wtel.setText(wtel);
				


			}

		});
		
		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { "12345", tf_wnum.getText() };
				if (rowValues[0].equals("")) {
//					JOptionPane.showInternalMessageDialog(HFoodtypeManagerView.this, "菜品类型不能为空"); // JOptionPane消息框
//					return;
				} else if (rowValues[1].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "服务员号不能为空"); // JOptionPane消息框
					return;
				}else if (rowValues[2].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "服务员名不能为空"); // JOptionPane消息框
					return;
				}else if (rowValues[3].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "性别不能为空"); // JOptionPane消息框
					return;
				}else if (rowValues[4].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "年龄不能为空"); // JOptionPane消息框
					return;
				}else if (rowValues[5].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "电话不能为空"); // JOptionPane消息框
					return;
				}
				else {
					Waiter w=new Waiter();
					w.setWnum(tf_wnum.getText());
					w.setWname(tf_wname.getText());
					w.setWsex(tf_wsex.getText());
					w.setWage(tf_wage.getText());
					w.setWtel(tf_wtel.getText());
					waiterbiz.addWaiter(w);
				
				}
				waiter=waiterbiz.findallWaiter();
				refreshTable(waiter);
				
			}
		});//				tf_wnum tf_wname tf_wsex tf_wage tf_wtel
		
	   
  }
	private class WaiterInfoTableModel implements TableModel {
		
		private List<Waiter> wlist = null;

		public WaiterInfoTableModel(List<Waiter> wlist) {
			this.wlist = wlist;
		}

		// JTable显示 的数据行数
		@Override
		public int getRowCount() {
			return wlist.size();
		}

		// JTable数据的列数
		@Override
		public int getColumnCount() {
			return 6;
		}

		// 设置JTable的显示的列名
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "服务员id";
			} else if (columnIndex == 1) {
				return "服务员号";
			} else if (columnIndex == 2) {
				return "服务员名";
			} else if (columnIndex == 3) {
				return "性别";
			} else if (columnIndex == 4) {
				return "年龄";
			} else if (columnIndex == 5) {
				return "电话";
			} 
			else {
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
			Waiter waiter = wlist.get(rowIndex);
			if (columnIndex == 0) {
				return waiter.getWid();
			} else if (columnIndex == 1) {
				return waiter.getWnum();
			} else if (columnIndex == 2) {
				return waiter.getWname();
			} else if (columnIndex == 3) {
				return waiter.getWsex();
			} else if (columnIndex == 4) {
				return waiter.getWage();
			} else if (columnIndex == 5) {
				return waiter.getWtel();
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
	private void refreshTable(List<Waiter> wList) {
		infoTableModel = new WaiterInfoTableModel(wList);
		table.setModel(infoTableModel);
	}

}

    






