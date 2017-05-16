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
	private JPanel panelnr = null;// neirong面板11111111111
	private JPanel panelBtoon = null;// 按钮组面板
	private JPanel paneltable = null;// 面板
	private JTable table = null;
	private JButton btn_query = null;// 查询按钮
	private JButton btn_add = null;// 添加按钮
	private JButton btn_del = null;// 删除按钮
	private JComboBox<String> cb_query = null;
	private JTextField tf_query = null;

	private JLabel label1 = null;
	private JLabel label2 = null;
	private JLabel label3 = null;
	private JTextField textField1 = null;
	private JTextField textField2 = null;
	private JComboBox<String> cb_type = null;//

	private UserBiz userBiz = null;// 调用相关业务层
	private List<User> uList = null;
	private UserInfoTableModel infoTableModel = null;

	public HUserManagerView() {
		userBiz = new UserBizImpl();// 产生对应用户业务层对象
		init();
		registerListener();
	}
	private void init() {
		setTitle("会员管理界面");
//		setBounds(200, 120, 560, 420);// setBounds(x,y,width,height)
		this.setIconifiable(true);
		this.setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 退出关闭窗体功能
		this.setLayout(new BorderLayout());
		uList = new ArrayList<User>();
		table = new JTable();
		// 让JTable绑定数据模型呈现数据
		refreshTable(uList);
		paneltable = new JPanel(new BorderLayout());// 创建面板
//		table = new JTable();
		// 给面板设置边框
		Border btable = (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "查询信息"));
		paneltable.setBorder(btable);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200,200));
		paneltable.add(jsp);
		this.add(paneltable,BorderLayout.CENTER);

		panelBtoon = new JPanel(new GridLayout(5, 1, 10, 20));
		panelBtoon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "查询条件"));
		this.add(panelBtoon, BorderLayout.EAST);
		tf_query = new JTextField(5);
		panelBtoon.add(tf_query);
		cb_query = new JComboBox<String>(new String[] { "全部用户", "指定名字用户" });
		panelBtoon.add(cb_query);
		btn_query = new JButton("查询新用户");
		panelBtoon.add(btn_query);
		btn_add = new JButton("添加新用户");// 添加用户
		panelBtoon.add(btn_add);
		btn_del = new JButton("删除此用户");// 添加用户
		panelBtoon.add(btn_del);

		panelnr = new JPanel(new GridLayout(1, 6, 0, 10));
		panelnr.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "内容"));
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
		cb_type = new JComboBox<String>(new String[] { "普通用户", "管理员" });
		panelnr.add(cb_type);

		this.setVisible(true);
	}

	private void registerListener() {

		btn_del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int id = (Integer) table.getValueAt(row, 0);
				int flag = JOptionPane.showInternalConfirmDialog(HUserManagerView.this, "是否确定删除用户？", "确认信息",
						JOptionPane.YES_NO_OPTION);
				if (flag == JOptionPane.YES_OPTION) {
					boolean res = userBiz.delUser(id);
					if (res) {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " 删除成功");
					} else {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " 删除失败");
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
					JOptionPane.showInternalMessageDialog(HUserManagerView.this, " 查询内容不能为空");
					return;
				}
				// 先清除数据，防止数据的累加
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
				// JOptionPane.showInternalMessageDialog(HUserManagerView.this,"没有你要查询的内容");
				// }
			}
		});

		btn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String uname = textField1.getText().trim();// 获取文本框内容，去掉两个空格
				String upass = textField2.getText().trim();
				int type = cb_type.getSelectedIndex() + 1;// 普通用户1管理员2

				if (uname.equals("")) {
					JOptionPane.showInternalMessageDialog(HUserManagerView.this, "用户名不能为空"); // JOptionPane消息框
																								// ,父容器LoginView
					return;

				} else if (upass.equals("")) {
					JOptionPane.showInternalMessageDialog(HUserManagerView.this, " 密码不能为空");
					return;
				}
				int flag = JOptionPane.showInternalConfirmDialog(HUserManagerView.this, "是否确定添加用户？", "确认信息",
						JOptionPane.YES_NO_OPTION);
				if (flag == JOptionPane.YES_OPTION) {
					boolean res = userBiz.addUser(new User(uname, upass, type));
					if (res) {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " 添加成功");
					} else {
						JOptionPane.showInternalMessageDialog(HUserManagerView.this, " 添加失败");
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

		// JTable显示 的数据行数
		@Override
		public int getRowCount() {
			return uList.size();
		}

		// JTable数据的列数
		@Override
		public int getColumnCount() {
			return 4;
		}

		// 设置JTable的显示的列名
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "用户id";
			} else if (columnIndex == 1) {
				return "用户名";
			} else if (columnIndex == 2) {
				return "密码";
			} else if (columnIndex == 3) {
				return "类型";
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
			User user = uList.get(rowIndex);
			if (columnIndex == 0) {
				return user.getId();
			} else if (columnIndex == 1) {
				return user.getUname();
			} else if (columnIndex == 2) {
				return user.getUpass();
			} else if (columnIndex == 3) {
				return user.getType();
				// return ""+ (user.getType()==1?"普通用户":"管理员");
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
	private void refreshTable(List<User> uList) {
		infoTableModel = new UserInfoTableModel(uList);
		table.setModel(infoTableModel);
	}

}
