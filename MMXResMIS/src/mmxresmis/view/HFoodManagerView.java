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
import javax.swing.table.TableModel;

import mmxresmis.biz.FoodBiz;
import mmxresmis.biz.impl.FoodBizImpl;
import mmxresmis.entity.Food;

public class HFoodManagerView extends JInternalFrame {
	private static final long serialVersionUID = 4279455055264955621L;
	private JTable table = null;
	private JPanel panel = null;// 面板
	private JPanel panel1 = null;// 面板
	private JPanel panel2 = null;// 面板
	private JScrollPane scrollPane = null;

	private JLabel label2 = null;
	private JLabel label3 = null;
	private JLabel label4 = null;
	private JLabel label5 = null;

	private JTextField textField2 = null;
	private JTextField textField3 = null;
	private JTextField textField4 = null;
	private JTextField textField5 = null;

	private JButton btn_add = null;// 添加按钮
	private JButton btn_del = null;// 删除按钮
	private FoodBiz foootbiz = new FoodBizImpl();
	private List<Food> foods = new ArrayList<>();
	private FoodInfoTableModel infoTableModel = null;

	public HFoodManagerView() {
		init();
		registerListener();
	}

	private void init() {

		foods = foootbiz.findAllFood();
		table = new JTable();
		// 让JTable绑定数据模型呈现数据
		refreshTable(foods);
		scrollPane = new JScrollPane(table);// 创建显示表格的滚动面板
		scrollPane.setPreferredSize(new Dimension(200,200));
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		label2 = new JLabel("菜品类型");
		label3 = new JLabel("菜单号");
		label4 = new JLabel("菜名");
		label5 = new JLabel("菜价");

		textField2 = new JTextField(10);
		textField3 = new JTextField(10);
		textField4 = new JTextField(5);
		textField5 = new JTextField(5);

		btn_add = new JButton("添加新菜品");// 添加用户
		btn_del = new JButton("删除此菜品");// 添加用户

		panel = new JPanel(new GridLayout(2, 10, 0, 20));
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.add(label2);
		panel1.add(textField2);
		panel1.add(label3);
		panel1.add(textField3);
		panel1.add(label4);
		panel1.add(textField4);
		panel1.add(label5);
		panel1.add(textField5);
		panel2.add(btn_add);
		panel2.add(btn_del);
		panel.add(panel1);
		panel.add(panel2);
		getContentPane().add(panel, BorderLayout.SOUTH);

		setTitle("菜品管理界面");
		setBounds(200, 120, 880, 420);// setBounds(x,y,width,height)
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 退出关闭窗体功能
		this.setIconifiable(true);
		this.setClosable(true);
		this.setVisible(true);
	}

	private void registerListener() {
		btn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] seleteRows = table.getSelectedRows();
				List<Food> fd=new ArrayList<>();
				for (int row = 0; row < seleteRows.length; row++) {
					fd.add(foods.get(row));
				}
				for (Food food : fd) {
					foootbiz.delFood(food.getFid());
				}
				
				foods = foootbiz.findAllFood();
				refreshTable(foods);
			}
		});

		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = { "123", textField2.getText(), textField3.getText(), textField4.getText(),
						textField5.getText() };
				if (rowValues[0].equals("")) {
				} else if (rowValues[1].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "菜品类型不能为空"); // JOptionPane消息框
					return;
				} else if (rowValues[2].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "菜单号不能为空"); // JOptionPane消息框
					return;
				} else if (rowValues[3].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "菜名不能为空"); // JOptionPane消息框
					return;
				} else if (rowValues[4].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "菜价不能为空"); // JOptionPane消息框
					return;
				} else {
					Food f = new Food();
					f.setFoodtype(textField2.getText());
					f.setFoodnum(textField3.getText());
					f.setFoodname(textField4.getText());
					f.setFoodprice(new BigDecimal(textField5.getText()));
					foootbiz.addFood(f);
				}
				foods = foootbiz.findAllFood();
				refreshTable(foods);
			}
		});
	}

	private class FoodInfoTableModel implements TableModel {
		private List<Food> fList = null;

		public FoodInfoTableModel(List<Food> fList) {
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
			return 5;
		}

		// 设置JTable的显示的列名
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "菜品号";
			} else if (columnIndex == 1) {
				return "菜品类型";
			} else if (columnIndex == 2) {
				return "菜单号";
			} else if (columnIndex == 3) {
				return "菜名";
			} else if (columnIndex == 4) {
				return "菜价";
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
			Food food = fList.get(rowIndex);
			if (columnIndex == 0) {
				return food.getFid();
			} else if (columnIndex == 1) {
				return food.getFoodtype();
			} else if (columnIndex == 2) {
				return food.getFoodnum();
			} else if (columnIndex == 3) {
				return food.getFoodname();
			} else if (columnIndex == 4) {
				return food.getFoodprice();
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
	private void refreshTable(List<Food> uList) {
		infoTableModel = new FoodInfoTableModel(uList);
		table.setModel(infoTableModel);
	}

}
