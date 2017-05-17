package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import mmxresmis.biz.GuestfoodBiz;
import mmxresmis.biz.impl.GuestfoodBizImpl;
import mmxresmis.entity.Guestfood;
import mmxresmis.entity.Zhuotai;

public class JiezhangView extends JInternalFrame {
	private static final long serialVersionUID = -1062640286971674349L;
	private JPanel panel_main = null;// �������
	private JPanel panelxiangqing = null;// �������
	private JPanel panelshoukuan = null;
	private JPanel panelbutton = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;

	private JScrollPane scrollPane = null;// �������
	
	private JTextArea ta_xianshi = null;
	private JScrollPane sp = null;// ������

	private JLabel lb_roombjf;// ����ѱ�ǩ
	private JLabel lb_yingshou;
	private JLabel lb_shishou;
	private JLabel lb_zhaoling;

	private JTextField tf_roombjf;// ������ı���
	private JTextField tf_yingshou;
	private JTextField tf_shishou;
	private JTextField tf_zhaoling;

	private JButton btn_jiezhang = null;// ���˰�ť
	private JButton btn_exit = null;
	private List<Guestfood> gfList = null;
	private GuestfoodBiz guestfoodBiz = new GuestfoodBizImpl();
	private Zhuotai zhuotai;
//	private JiezhangInfoTableModel infoTableModel = null;
	private JTable table;

	public JiezhangView(Zhuotai zhuotai) {
		this.zhuotai = zhuotai;
		init();
	}

	private void init() {
//		this.setSize(700, 420);// ���ô����С
		this.setResizable(false);// �������϶������С
	    this.setIconifiable(true);//JInternalFrame��Ƕ���壬�������С��
		this.setClosable(true);//����ɱ��ر�
		// this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("���˴���");// ���ñ���
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �˳��رմ��幦��
		// this.pack();//��������
		
		// ��ʼ���ؼ�
		lb_roombjf = new JLabel("�����");
		lb_yingshou = new JLabel("������");
		lb_shishou = new JLabel("ʵ�տ�");
		lb_zhaoling = new JLabel("�� ��");

		tf_roombjf = new JTextField(8);
		tf_roombjf.setText(zhuotai.getZhuotaibjf());
		tf_roombjf.setEditable(false);
		tf_yingshou = new JTextField(8);
	
		
		

		

		btn_jiezhang = new JButton("����");
		btn_exit = new JButton("ȡ��");

		gfList = guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
		
		
		
		
		panel_main =new JPanel(new BorderLayout());
		table = new JTable();
		scrollPane = new JScrollPane(table);// ������ʾ���Ĺ������
		scrollPane.setPreferredSize(new Dimension(400,200));
		
		panelxiangqing = new JPanel(new BorderLayout());
		panelxiangqing.add(scrollPane);
		this.add(panelxiangqing,BorderLayout.NORTH);
		
		panelshoukuan = new JPanel(new GridLayout(3, 1, 5, 10));	
		this.add(panelshoukuan, BorderLayout.CENTER);
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1.add(lb_yingshou);
		panel1.add(tf_yingshou);
		panel2.add(lb_shishou);
		panel2.add(tf_shishou);
		panel3.add(lb_zhaoling);
		panel3.add(tf_zhaoling);
		panel4.add(btn_jiezhang);
		panel4.add(btn_exit);
		panelshoukuan.add(panel1);
		panelshoukuan.add(panel2);
		panelshoukuan.add(panel3);
		panelshoukuan.add(panel4);
		
		panelbutton = new JPanel(new GridLayout(1, 2, 5, 10));	
		this.add(panelbutton, BorderLayout.CENTER);
		panelbutton.add(btn_jiezhang);
		panelbutton.add(btn_exit);
	
		
		
		
		

//		// ��ʼ�����
//		panelxiangqing = new JPanel(new GridLayout(6, 1));// Ĭ����ʽ������
//		// panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panelshoukuan = new JPanel();
//		panelbutton = new JPanel();
//		// panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel1 = new JPanel();
//		// panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel2 = new JPanel();
//		// panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel3 = new JPanel();
//		// panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panel4 = new JPanel();

		BigDecimal a = new BigDecimal("0");
		for (Guestfood guestfood : gfList) {
			a = a.add(guestfood.getFoodallprice());
		}
		System.out.println(a);
		tf_yingshou.setText(a.toString());
		tf_yingshou.setEditable(false);
		tf_shishou = new JTextField(8);
		tf_zhaoling = new JTextField(8);

		
		
		
		ta_xianshi = new JTextArea(5, 50);
		sp = new JScrollPane(ta_xianshi);

		gfList = guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
		table = new JTable();
		// ��JTable������ģ�ͳ�������
//		refreshTable();
//		JScrollPane scrollPane = new JScrollPane(table);// ������ʾ���Ĺ������
//		scrollPane.setPreferredSize(new Dimension(650, 800));
//		getContentPane().add(scrollPane, BorderLayout.CENTER);

		// panel1.add(sp);
//		panelshoukuan.add(scrollPane, BorderLayout.CENTER);
//		panelbutton.add(lb_roombjf);
//		panelbutton.add(tf_roombjf);
//		panel1.add(lb_yingshou);
//		panel1.add(tf_yingshou);
//		panel2.add(lb_shishou);
//		panel2.add(tf_shishou);
//		panel3.add(lb_zhaoling);
//		panel3.add(tf_zhaoling);
//		panel4.add(btn_jiezhang);
//		panel4.add(btn_exit);
//
//		panelxiangqing.add(panelshoukuan);
//		panelxiangqing.add(panelbutton);
//		panelxiangqing.add(panel1);
//		panelxiangqing.add(panel2);
//		panelxiangqing.add(panel3);
//		panelxiangqing.add(panel4);

		this.getContentPane().add(panel_main);// �������
		this.setVisible(true);// ��ʾ����
	}

	/**
	 * ����ÿ�ݲ��ܼ�Ǯ
	 **/
//	public FocusListener focus() {
//		return new FocusListener() {
//
//			@Override
//			public void focusLost(FocusEvent arg0) {
//				if ("".equals(tf_foodsum.getText().trim())) {
//					tf_foodsum.setText("1");
//				}
//				int count = Integer.valueOf(tf_foodsum.getText().trim());
//				int price = Integer.valueOf(tf_foodprice.getText().trim());
//				tf_foodallprice.setText(count * price + "");
//				// System.out.println("ʧȥ");
//			}
//
//			@Override
//			public void focusGained(FocusEvent arg0) {
//				// TODO Auto-generated method stub
//				// System.out.println("���");
//			}
//		};
//	}
//
//	private class JiezhangInfoTableModel implements TableModel {
//		private List<Guestfood> fList = null;
//
//		public JiezhangInfoTableModel(List<Guestfood> fList) {
//			this.fList = fList;
//		}
//
//		// JTable��ʾ ����������
//		@Override
//		public int getRowCount() {
//			return fList.size();
//		}
//
//		// JTable���ݵ�����
//		@Override
//		public int getColumnCount() {
//			return 7;
//		}
//
//		// ����JTable����ʾ������ �˺�", "����", "����Ա��", "����", "����", "�ܼ�"
//		@Override
//		public String getColumnName(int columnIndex) {
//			if (columnIndex == 0) {
//				return "�˺�";
//			} else if (columnIndex == 1) {
//				return "����";
//			} else if (columnIndex == 2) {
//				return "����Ա��";
//			} else if (columnIndex == 3) {
//				return "����";
//			} else if (columnIndex == 4) {
//				return "����";
//			} else if (columnIndex == 5) {
//				return "�ܼ�";
//			} else if (columnIndex == 6) {
//				return "�ύʱ��";
//			} else {
//				return "����";
//			}
//		}
//
//		// JTable �е���������
//		@Override
//		public Class<?> getColumnClass(int columnIndex) {
//			return String.class;
//		}
//
//		// ���õ�Ԫ���Ƿ�ɱ༭
//		@Override
//		public boolean isCellEditable(int rowIndex, int columnIndex) {
//			return false;
//		}
//
//		// ��ȡJTable���ƶ���Ԫ�������
//		@Override
//		public Object getValueAt(int rowIndex, int columnIndex) {
//			Guestfood food = fList.get(rowIndex);
//			if (columnIndex == 0) {
//				return food.getFoodnum();
//			} else if (columnIndex == 1) {
//				return food.getFoodname();
//			} else if (columnIndex == 2) {
//				return food.getWname();
//			} else if (columnIndex == 3) {
//				return food.getFoodprice();
//			} else if (columnIndex == 4) {
//				return food.getFoodsum();
//			} else if (columnIndex == 5) {
//				return food.getFoodallprice();
//			} else if (columnIndex == 6) {
//				return food.getGdatetime();
//			} else {
//				return "����";
//			}
//		}
//
//		@Override
//		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void addTableModelListener(TableModelListener l) {
//			// TODO Auto-generated method stub
//
//		}
//
//		@Override
//		public void removeTableModelListener(TableModelListener l) {
//			// TODO Auto-generated method stub
//		}
//	}
//
//	// ˢ��JTable����ʾ����
//	private void refreshTable() {
//		gfList = guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
//		infoTableModel = new JiezhangInfoTableModel(gfList);
//		table.setModel(infoTableModel);
//	}
//
//	/**
//	 * �رմ���
//	 **/
//	private void close() {
//		this.dispose();
//	}

}