package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
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

public class HFoodManagerView extends JFrame {
	private static final long serialVersionUID = 4279455055264955621L;
	private JTable table = null;
	private JPanel panel = null;// ���
	private JPanel panel1 = null;// ���
	private JPanel panel2 = null;// ���
	private JScrollPane scrollPane = null;

	private JLabel label2 = null;
	private JLabel label3 = null;
	private JLabel label4 = null;
	private JLabel label5 = null;

	private JTextField textField2 = null;
	private JTextField textField3 = null;
	private JTextField textField4 = null;
	private JTextField textField5 = null;

	private JButton btn_add = null;// ��Ӱ�ť
	private JButton btn_del = null;// ɾ����ť
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
		// ��JTable������ģ�ͳ�������
		refreshTable(foods);
		scrollPane = new JScrollPane(table);// ������ʾ���Ĺ������
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		label2 = new JLabel("��Ʒ����");
		label3 = new JLabel("�˵���");
		label4 = new JLabel("����");
		label5 = new JLabel("�˼�");

		textField2 = new JTextField(10);
		textField3 = new JTextField(10);
		textField4 = new JTextField(5);
		textField5 = new JTextField(5);

		btn_add = new JButton("����²�Ʒ");// ����û�
		btn_del = new JButton("ɾ���˲�Ʒ");// ����û�

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

		setTitle("��Ʒ�������");
		setBounds(200, 120, 880, 420);// setBounds(x,y,width,height)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �˳��رմ��幦��
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
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "��Ʒ���Ͳ���Ϊ��"); // JOptionPane��Ϣ��
					return;
				} else if (rowValues[2].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "�˵��Ų���Ϊ��"); // JOptionPane��Ϣ��
					return;
				} else if (rowValues[3].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "��������Ϊ��"); // JOptionPane��Ϣ��
					return;
				} else if (rowValues[4].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodManagerView.this, "�˼۲���Ϊ��"); // JOptionPane��Ϣ��
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

		// JTable��ʾ ����������
		@Override
		public int getRowCount() {
			return fList.size();
		}

		// JTable���ݵ�����
		@Override
		public int getColumnCount() {
			return 5;
		}

		// ����JTable����ʾ������
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "��Ʒ��";
			} else if (columnIndex == 1) {
				return "��Ʒ����";
			} else if (columnIndex == 2) {
				return "�˵���";
			} else if (columnIndex == 3) {
				return "����";
			} else if (columnIndex == 4) {
				return "�˼�";
			} else {
				return "����";
			}
		}

		// JTable �е���������
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}

		// ���õ�Ԫ���Ƿ�ɱ༭
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}

		// ��ȡJTable���ƶ���Ԫ�������
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

	// ˢ��JTable����ʾ����
	private void refreshTable(List<Food> uList) {
		infoTableModel = new FoodInfoTableModel(uList);
		table.setModel(infoTableModel);
	}

}
