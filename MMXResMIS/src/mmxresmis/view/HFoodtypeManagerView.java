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
	private DefaultTableModel tableModel = null;// ���ģ��
	private JTable table = null;// ������
	private JPanel panel = null;// ���
	private JPanel panel1 = null;// ���
	private JPanel panel2 = null;// ���
	private JScrollPane scrollPane = null;// �������

	private JLabel label2 = null;

	private JTextField textField2 = null;

	private JButton btn_add = null;// ��Ӱ�ť
	private JButton btn_del = null;// ɾ����ť
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
		// ��JTable������ģ�ͳ�������
		refreshTable(foods);
		scrollPane = new JScrollPane(table);// ������ʾ���Ĺ������
		scrollPane.setPreferredSize(new Dimension(200,200));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		label2 = new JLabel("��Ʒ��������");

		textField2 = new JTextField(5);

		btn_add = new JButton("����²�Ʒ����");// ����û�
		btn_del = new JButton("ɾ���˲�Ʒ����");// ����û�

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

		setTitle("��Ʒ���͹������");
//		setBounds(180, 200, 440, 400);// setBounds(x,y,width,height)
		
//		setBounds(200, 120, 200, 200);// setBounds(x,y,width,height)
		this.setIconifiable(true);
		this.setClosable(true);
		this.setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// �˳��رմ��幦��
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
//					JOptionPane.showInternalMessageDialog(HFoodtypeManagerView.this, "��Ʒ���Ͳ���Ϊ��"); // JOptionPane��Ϣ��
//					return;
				} else if (rowValues[1].equals("")) {
					JOptionPane.showInternalMessageDialog(HFoodtypeManagerView.this, "��Ʒ���Ͳ���Ϊ��"); // JOptionPane��Ϣ��
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

		// JTable��ʾ ����������
		@Override
		public int getRowCount() {
			return fList.size();
		}

		// JTable���ݵ�����
		@Override
		public int getColumnCount() {
			return 2;
		}

		// ����JTable����ʾ������
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "��Ʒ����id";
			} else if (columnIndex == 1) {
				return "��Ʒ��������";
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
			Foodtype food = fList.get(rowIndex);
			if (columnIndex == 0) {
				return food.getFtypeid();
			} else if (columnIndex == 1) {
				return food.getFoodtype();
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
	private void refreshTable(List<Foodtype> uList) {
		infoTableModel = new FoodTypeInfoTableModel(uList);
		table.setModel(infoTableModel);
	}
	
	

}
