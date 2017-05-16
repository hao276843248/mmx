package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
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

import mmxresmis.biz.FoodtypeBiz;
import mmxresmis.biz.impl.FoodtypeBizImpl;
import mmxresmis.entity.Food;
import mmxresmis.entity.Foodtype;
import mmxresmis.entity.User;

public class HFoodtypeManagerView extends JInternalFrame {
	private static final long serialVersionUID = -2189578035742248674L;
	private DefaultTableModel tableModel = null;// 表格模型
	private JTable table = null;// 表格对象
	private JPanel panel = null;// 面板
	private JPanel panel1 = null;// 面板
	private JPanel panel2 = null;// 面板
	private JScrollPane scrollPane = null;// 滚动面板

	private JLabel label2 = null;

	private JTextField textField2 = null;

	private JButton btn_add = null;// 添加按钮
	private JButton btn_del = null;// 删除按钮
	private FoodTypeInfoTableModel infoTableModel = null;
	private List<Foodtype> foods=null;
	private FoodtypeBiz fooottypebiz=new FoodtypeBizImpl();
			
	public HFoodtypeManagerView() {
		init();
		registerListener();
	}

	private void init() {
		foods = fooottypebiz.findallFoodtype();
		table = new JTable();
		// 让JTable绑定数据模型呈现数据
		refreshTable(foods);
		scrollPane = new JScrollPane(table);// 创建显示表格的滚动面板
		scrollPane.setPreferredSize(new Dimension(200,200));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		label2 = new JLabel("菜品类型名称");

		textField2 = new JTextField(5);

		btn_add = new JButton("添加新菜品类型");// 添加用户
		btn_del = new JButton("删除此菜品类型");// 添加用户

		panel = new JPanel(new GridLayout(2, 10, 0, 20));
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.add(label2);
		panel1.add(textField2);
		panel2.add(btn_add);
		panel2.add(btn_del);
		panel.add(panel1);
		panel.add(panel2);
		getContentPane().add(panel, BorderLayout.SOUTH);

		setTitle("菜品类型管理界面");
//		setBounds(180, 200, 440, 400);// setBounds(x,y,width,height)
		
//		setBounds(200, 120, 200, 200);// setBounds(x,y,width,height)
		this.setIconifiable(true);
		this.setClosable(true);
		this.setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 退出关闭窗体功能
	}

	private void registerListener() {
		btn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] seleteRows = table.getSelectedRows();
				List<Foodtype> fd=new ArrayList<>();
				
				for (int row = 0; row < seleteRows.length; row++) {
					fd.add(foods.get(seleteRows[row]));
				}
				for (Foodtype food : fd) {
					fooottypebiz.delFoodtype(food.getFtypeid());
				}
				
				foods = fooottypebiz.findallFoodtype();
				refreshTable(foods);
			}
		});

		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { "123", textField2.getText() };
				if (rowValues[0].equals("")) {
//					JOptionPane.showInternalMessageDialog(HFoodtypeManagerView.this, "菜品类型不能为空"); // JOptionPane消息框
//					return;
				} else if (rowValues[1].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodtypeManagerView.this, "菜品类型不能为空"); // JOptionPane消息框
					return;
				} else {
					Foodtype f = new Foodtype();
					f.setFoodtype(textField2.getText());
					fooottypebiz.addFoodtype(f);
				}
				foods = fooottypebiz.findallFoodtype();
				refreshTable(foods);
			}
		});
	}
	
	private class FoodTypeInfoTableModel implements TableModel {
		private List<Foodtype> fList = null;

		public FoodTypeInfoTableModel(List<Foodtype> fList) {
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
			return 2;
		}

		// 设置JTable的显示的列名
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "菜品类型id";
			} else if (columnIndex == 1) {
				return "菜品类型名称";
			} else {
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
			Foodtype food = fList.get(rowIndex);
			if (columnIndex == 0) {
				return food.getFtypeid();
			} else if (columnIndex == 1) {
				return food.getFoodtype();
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
	private void refreshTable(List<Foodtype> uList) {
		infoTableModel = new FoodTypeInfoTableModel(uList);
		table.setModel(infoTableModel);
	}
	
	

}
