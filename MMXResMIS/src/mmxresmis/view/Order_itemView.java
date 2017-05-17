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
	private JPanel panel_left = null;//�����
	private JPanel panel_right = null;
	private JPanel paneldiancai = null;
	private JPanel panelbutton = null;
	private JPanel panelxiangqing = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;

	private JSplitPane splitPane = null;// �ָ�������

	private JTree tree = null;// ��
	private DefaultTreeModel treeModel = null;// ��ģ��
	private DefaultMutableTreeNode root = null;// ���ڵ�

	private JLabel lb_foodnum;// �˺ű�ǩ
	private JLabel lb_foodname;//����
	private JLabel lb_wnum;//����Ա��
	private JLabel lb_beizhu;//��ע
	private JLabel lb_foodprice;//��Ʒ����
	private JLabel lb_foodsum;//����
	private JLabel lb_foodallprice;//�ܼ�

	private JTextField tf_foodnum = null;// �˺��ı���
	private JTextField tf_foodname = null;
	private JTextField tf_wnum = null;
	private JTextField tf_beizhu = null;
	private JTextField tf_foodprice = null;
	private JTextField tf_foodsum = null;
	private JTextField tf_foodallprice = null;

	private JButton btn_equal = null;// ���ڰ�ť
	private JButton btn_insert = null;// ������ť
	private JButton btn_delete = null;//ɾ��
	private JButton btn_submit = null;//ȷ��
	private JButton btn_exit = null;//�˳�

	private DefaultTableModel tableModel = null;// ���ģ��
	private JTable table = null;// ������
	private JScrollPane scrollPane = null;// �������

	private List<Food> foods = null;
	private List<Foodtype> foodtypes = null;
	private FoodtypeBiz foodtypeBiz = new FoodtypeBizImpl();
	private FoodBiz foodBiz = new FoodBizImpl();
	private Zhuotai zhuotai=null;
	private UserFoodInfoTableModel infoTableModel=null;
	private GuestfoodBiz guestfoodBiz=new  GuestfoodBizImpl();
	private List<Guestfood> gfList=null;		
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//��ȡ��ǰ����
	
	// private JLabel deskLabel=null;

	public Order_itemView(Zhuotai zhuotai) {
		this.zhuotai=zhuotai;
		init();
		registerListener();
	}

	private void init() {
//		this.setSize(950, 600);// ���ô����С
		this.setResizable(false);// �����϶������С
		this.setClosable(true);//����ɱ��ر�
		this.setIconifiable(true);//JInternalFrame��Ƕ���壬�������С��
		// this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("��/�Ӳ˴���");// ���ñ���
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �˳��رմ��幦��

		foods = foodBiz.findAllFood();
		foodtypes = foodtypeBiz.findallFoodtype();
		// ��ʼ�����ڵ���ӽڵ�
		root = new DefaultMutableTreeNode("�˵�");
		// ���ø��ڵ㴴��TreeModel
		treeModel = new DefaultTreeModel(root);

		for (Foodtype foodtype : foodtypes) {
			// �����ӽڵ�
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(foodtype.getFoodtype());
			treeModel.insertNodeInto(node, root, root.getChildCount());
			for (Food food : foods) {
				// �����Ʒ����Ϊ�ӽڵ���������Ӳ�Ʒ
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

		// �����ڵ���ƶ���
		DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
		// ��������
		cellRenderer.setFont(new Font("Serif", Font.PLAIN, 14));
		cellRenderer.setBackgroundNonSelectionColor(Color.white);
		cellRenderer.setBackgroundSelectionColor(Color.yellow);
		cellRenderer.setBorderSelectionColor(Color.red);

		// ����ѡʱ��ѡʱ�����ֵı仯��ɫ
		cellRenderer.setTextNonSelectionColor(Color.black);
		cellRenderer.setTextSelectionColor(Color.blue);
		
		
		
		// ��ʼ�����
		panel_left = new JPanel(new GridLayout(1, 1, 0, 0));	
		panel_right =new JPanel(new BorderLayout());
		
		// ��ʼ���ָ���
		splitPane = new JSplitPane();
		splitPane.setDividerSize(10);// ���÷ָ��ߴ�С

		// ��ʼ���ؼ�
		lb_foodnum = new JLabel("�˺�");
		lb_foodname = new JLabel("����");
		lb_wnum = new JLabel("����Ա��");
		lb_beizhu = new JLabel("��ע");
		lb_foodprice = new JLabel("����");
		lb_foodsum = new JLabel("*����(Ĭ��Ϊ1)");
		lb_foodallprice = new JLabel("�ܼ�");

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
		btn_insert = new JButton("����");
		btn_delete = new JButton("ɾ��");
		btn_submit = new JButton("�ύ");
		btn_exit = new JButton("�˳�");

		// //�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

//		String[] columnNames = { "�˺�", "����", "����Ա��", "����", "����", "�ܼ�" };// ��������������
//		String[][] tableValues = { { "��", "����", "���", "��", "���", "��V" }, { "��", "����", "���", "��", "���", "��V" },
//				{ "��", "����", "���", "��", "���", "��V" } }; // ���Ԫֵ
//		tableModel = new DefaultTableModel(tableValues, columnNames);// �����ƶ����������ݵı��

		gfList=guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
		table = new JTable();
		// ��JTable������ģ�ͳ�������
		refreshTable();
		scrollPane = new JScrollPane(table);// ������ʾ���Ĺ������
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
		
		splitPane.setLeftComponent(panel_left);// ��panel_left�ŵ��ָ�����ߣ�panel_right�ŵ��ұ�
		splitPane.setRightComponent(panel_right);
		this.getContentPane().add(splitPane);// �������
		this.setVisible(true);// ��ʾ����

		splitPane.setDividerLocation(0.2);// ���ұ�����С
		// splitPane.setEnabled(false);//�ָ��߲��������ƶ�
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
						JOptionPane.showMessageDialog(null, "������Ʒ���ύ����ɾ����", "����",JOptionPane.WARNING_MESSAGE);  
					}
					
				}
				refreshTable();
			}
		});

		btn_insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if("".equals(tf_foodname.getText())){
					JOptionPane.showMessageDialog(null, "��δѡ��Ʒ��");  
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
				if(JOptionPane.showConfirmDialog(null, "ȷ���ύ����̨����?") == JOptionPane.YES_OPTION){
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
					if(JOptionPane.showConfirmDialog(null, "����δ�ύ����,ȷ���˳��˵�?") == JOptionPane.YES_OPTION){
						close();
					}
				}else{
					close();
				}
			}
		});
		
		
	}

	/**
	 * ѡ�еĲ˼����¼�
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
	 * ����ÿ�ݲ��ܼ�Ǯ
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
//				System.out.println("ʧȥ");
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
//				System.out.println("���");
			}
		}; 
	}
	
	
	private class UserFoodInfoTableModel implements TableModel {
		private List<Guestfood> fList = null;

		public UserFoodInfoTableModel(List<Guestfood> fList) {
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
			return 7;
		}

		// ����JTable����ʾ������ �˺�", "����", "����Ա��", "����", "����", "�ܼ�" 
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "�˺�";
			} else if (columnIndex == 1) {
				return "����";
			} else if (columnIndex == 2) {
				return "����Ա��";
			}else if (columnIndex == 3) {
				return "����";
			}else if (columnIndex == 4) {
				return "����";
			}else if (columnIndex == 5) {
				return "�ܼ�";
			}else if (columnIndex == 6) {
				return "�ύʱ��";
			}else {
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
	private void refreshTable() {
		gfList=guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
		infoTableModel = new UserFoodInfoTableModel(gfList);
		table.setModel(infoTableModel);
	}
	/**
	 * �رմ��� 
	 * **/
	private void close(){
		this.dispose();
	}
	
}
