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
import javax.swing.JComboBox;
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

import mmxresmis.biz.UserBiz;
import mmxresmis.biz.impl.UserBizImpl;
import mmxresmis.entity.User;

public class HUserManagerView extends JInternalFrame {
	private static final long serialVersionUID = -4733113410758843245L;
	private JPanel panelnr = null;// neirong���
	private JPanel panelBtoon = null;// ��ť�����
	private JPanel paneltable = null;// ���
	private JTable table = null;
	private JButton btn_query = null;// ��ѯ��ť
	private JButton btn_add = null;// ��Ӱ�ť
	private JButton btn_del = null;// ɾ����ť
	private JComboBox<String> cb_query = null;
	private JTextField tf_query = null;

	private JLabel label1 = null;
	private JLabel label2 = null;
	private JLabel label3 = null;
	private JTextField textField1 = null;
	private JTextField textField2 = null;
	private JComboBox<String> cb_type = null;//

	private UserBiz userBiz = null;// �������ҵ���
	private List<User> uList = null;
	private UserInfoTableModel infoTableModel = null;

	public HUserManagerView() {
		userBiz = new UserBizImpl();// ������Ӧ�û�ҵ������
		init();
		registerListener();
	}
	private void init() {
		setTitle("��Ա�������");
		setBounds(200, 120, 560, 420);// setBounds(x,y,width,height)
		this.setIconifiable(true);
		this.setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// �˳��رմ��幦��
		this.setLayout(new BorderLayout());
		uList = new ArrayList<User>();
		table = new JTable();
		// ��JTable������ģ�ͳ�������
		refreshTable(uList);
		paneltable = new JPanel(new BorderLayout());// �������
//		table = new JTable();
		// ��������ñ߿�
		Border btable = (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "��ѯ��Ϣ"));
		paneltable.setBorder(btable);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200,200));
		paneltable.add(jsp);
		this.add(paneltable,BorderLayout.CENTER);

		panelBtoon = new JPanel(new GridLayout(5, 1, 10, 20));
		panelBtoon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "��ѯ����"));
		this.add(panelBtoon, BorderLayout.EAST);
		tf_query = new JTextField(5);
		panelBtoon.add(tf_query);
		cb_query = new JComboBox<String>(new String[] { "ȫ���û�", "ָ�������û�" });
		panelBtoon.add(cb_query);
		btn_query = new JButton("��ѯ���û�");
		panelBtoon.add(btn_query);
		btn_add = new JButton("������û�");// ����û�
		panelBtoon.add(btn_add);
		btn_del = new JButton("ɾ�����û�");// ����û�
		panelBtoon.add(btn_del);

		panelnr = new JPanel(new GridLayout(1, 6, 0, 10));
		panelnr.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "����"));
		this.add(panelnr, BorderLayout.SOUTH);
		label1 = new JLabel("uname");
		panelnr.add(label1);
		textField1 = new JTextField(5);
		panelnr.add(textField1);
		label2 = new JLabel("upass");
		panelnr.add(label2);
		textField2 = new JTextField(5);
		panelnr.add(textField2);
		label3 = new JLabel("type");
		panelnr.add(label3);
		cb_type = new JComboBox<String>(new String[] { "��ͨ�û�", "����Ա" });
		panelnr.add(cb_type);

		this.setVisible(true);
	}

	private void registerListener() {

		// btn_del.addActionListener(new ActionListener(){
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// int[] seleteRows=table.getSelectedRows();
		// for(int row=0;row<seleteRows.length;row++){
		// tableModel.removeRow(seleteRows[row]- row);
		// }
		// }
		// });

		// btn_del.addActionListener(new ActionListener(){
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// int[] seleteRows=table.getSelectedRows();
		// for(int row=0;row<seleteRows.length;row++){
		// tableModel.removeRow(seleteRows[row]- row);
		// }
		// }
		// });

		btn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int id = (Integer) table.getValueAt(row, 0);
				int flag = JOptionPane.showInternalConfirmDialog(HUserManagerView.this, "�Ƿ�ȷ��ɾ���û���", "ȷ����Ϣ",
						JOptionPane.YES_NO_OPTION);
				if (flag == JOptionPane.YES_OPTION) {
					boolean res = userBiz.delUser(id);
					if (res) {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " ɾ���ɹ�");
					} else {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " ɾ��ʧ��");
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
				int row = table.getSelectedRow();// �õ���ѡ�����е��±�
				String uname = table.getValueAt(row, 1).toString();
				String upass = table.getValueAt(row, 2).toString();
				String type = table.getValueAt(row, 3).toString();
				textField1.setText(uname);
				textField2.setText(upass);
				cb_type.setSelectedItem(type);

			}

		});

		btn_query.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = cb_query.getSelectedIndex();
				String content = tf_query.getText().trim();
				if (index != 0 && content.equals("")) {
					JOptionPane.showInternalMessageDialog(HUserManagerView.this, " ��ѯ���ݲ���Ϊ��");
					return;
				}
				// ��������ݣ���ֹ���ݵ��ۼ�
				if (uList != null) {
					uList.clear();
				}
				if (index == 0) {
					uList = userBiz.queryAllUser();
				} else {
					uList = userBiz.queryUserByName(content);
				}

				refreshTable(uList);
				btn_del.setEnabled(false);
				// if(uList.size() == 0){
				// JOptionPane.showInternalMessageDialog(HUserManagerView.this,"û����Ҫ��ѯ������");
				// }
			}
		});

		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String uname = textField1.getText().trim();// ��ȡ�ı������ݣ�ȥ�������ո�
				String upass = textField2.getText().trim();
				int type = cb_type.getSelectedIndex() + 1;// ��ͨ�û�1����Ա2

				if (uname.equals("")) {
					JOptionPane.showInternalMessageDialog(HUserManagerView.this, "�û�������Ϊ��"); // JOptionPane��Ϣ��
																								// ,������LoginView
					return;

				} else if (upass.equals("")) {
					JOptionPane.showInternalMessageDialog(HUserManagerView.this, " ���벻��Ϊ��");
					return;
				}
				int flag = JOptionPane.showInternalConfirmDialog(HUserManagerView.this, "�Ƿ�ȷ������û���", "ȷ����Ϣ",
						JOptionPane.YES_NO_OPTION);
				if (flag == JOptionPane.YES_OPTION) {
					boolean res = userBiz.addUser(new User(uname, upass, type));
					if (res) {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " ��ӳɹ�");
					} else {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " ���ʧ��");
					}
				}

			}
		});

	}

	private class UserInfoTableModel implements TableModel {
		private List<User> uList = null;

		public UserInfoTableModel(List<User> uList) {
			this.uList = uList;
		}

		// JTable��ʾ ����������
		@Override
		public int getRowCount() {
			return uList.size();
		}

		// JTable���ݵ�����
		@Override
		public int getColumnCount() {
			System.out.println("getColumnCount");
			return 4;
		}

		// ����JTable����ʾ������
		@Override
		public String getColumnName(int columnIndex) {
			System.out.println("getColumnName"+columnIndex);
			if (columnIndex == 0) {
				return "�û�id";
			} else if (columnIndex == 1) {
				return "�û���";
			} else if (columnIndex == 2) {
				return "����";
			} else if (columnIndex == 3) {
				return "����";
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
			User user = uList.get(rowIndex);
			if (columnIndex == 0) {
				return user.getId();
			} else if (columnIndex == 1) {
				return user.getUname();
			} else if (columnIndex == 2) {
				return user.getUpass();
			} else if (columnIndex == 3) {
				return user.getType();
				// return ""+ (user.getType()==1?"��ͨ�û�":"����Ա");
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
	private void refreshTable(List<User> uList) {
		infoTableModel = new UserInfoTableModel(uList);
		table.setModel(infoTableModel);
	}

}
