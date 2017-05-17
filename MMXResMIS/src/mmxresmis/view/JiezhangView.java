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
	private JPanel panel_main = null;// 详情面板
	private JPanel panelxiangqing = null;// 详情面板
	private JPanel panelshoukuan = null;
	private JPanel panelbutton = null;
	private JPanel panel1 = null;
	private JPanel panel2 = null;
	private JPanel panel3 = null;
	private JPanel panel4 = null;

	private JScrollPane scrollPane = null;// 滚动面板
	
	private JTextArea ta_xianshi = null;
	private JScrollPane sp = null;// 滚动条

	private JLabel lb_roombjf;// 包间费标签
	private JLabel lb_yingshou;
	private JLabel lb_shishou;
	private JLabel lb_zhaoling;

	private JTextField tf_roombjf;// 包间费文本框
	private JTextField tf_yingshou;
	private JTextField tf_shishou;
	private JTextField tf_zhaoling;

	private JButton btn_jiezhang = null;// 结账按钮
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
//		this.setSize(700, 420);// 设置窗体大小
		this.setResizable(false);// ，不可拖动窗体大小
	    this.setIconifiable(true);//JInternalFrame内嵌窗体，窗体可最小化
		this.setClosable(true);//窗体可被关闭
		// this.setLocationRelativeTo(null);//窗体居中显示
		this.setTitle("结账窗口");// 设置标题
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 退出关闭窗体功能
		// this.pack();//收缩窗体
		
		// 初始化控件
		lb_roombjf = new JLabel("包间费");
		lb_yingshou = new JLabel("总消费");
		lb_shishou = new JLabel("实收款");
		lb_zhaoling = new JLabel("找 零");

		tf_roombjf = new JTextField(8);
		tf_roombjf.setText(zhuotai.getZhuotaibjf());
		tf_roombjf.setEditable(false);
		tf_yingshou = new JTextField(8);
	
		
		

		

		btn_jiezhang = new JButton("结账");
		btn_exit = new JButton("取消");

		gfList = guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
		
		
		
		
		panel_main =new JPanel(new BorderLayout());
		table = new JTable();
		scrollPane = new JScrollPane(table);// 创建显示表格的滚动面板
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
	
		
		
		
		

//		// 初始化面板
//		panelxiangqing = new JPanel(new GridLayout(6, 1));// 默认流式管理器
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
		// 让JTable绑定数据模型呈现数据
//		refreshTable();
//		JScrollPane scrollPane = new JScrollPane(table);// 创建显示表格的滚动面板
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

		this.getContentPane().add(panel_main);// 内容面板
		this.setVisible(true);// 显示窗体
	}

	/**
	 * 计算每份菜总价钱
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
//				// System.out.println("失去");
//			}
//
//			@Override
//			public void focusGained(FocusEvent arg0) {
//				// TODO Auto-generated method stub
//				// System.out.println("获得");
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
//		// JTable显示 的数据行数
//		@Override
//		public int getRowCount() {
//			return fList.size();
//		}
//
//		// JTable数据的列数
//		@Override
//		public int getColumnCount() {
//			return 7;
//		}
//
//		// 设置JTable的显示的列名 菜号", "菜名", "服务员号", "单价", "数量", "总价"
//		@Override
//		public String getColumnName(int columnIndex) {
//			if (columnIndex == 0) {
//				return "菜号";
//			} else if (columnIndex == 1) {
//				return "菜名";
//			} else if (columnIndex == 2) {
//				return "服务员号";
//			} else if (columnIndex == 3) {
//				return "单价";
//			} else if (columnIndex == 4) {
//				return "数量";
//			} else if (columnIndex == 5) {
//				return "总价";
//			} else if (columnIndex == 6) {
//				return "提交时间";
//			} else {
//				return "出错";
//			}
//		}
//
//		// JTable 列的数据类型
//		@Override
//		public Class<?> getColumnClass(int columnIndex) {
//			return String.class;
//		}
//
//		// 设置单元格是否可编辑
//		@Override
//		public boolean isCellEditable(int rowIndex, int columnIndex) {
//			return false;
//		}
//
//		// 获取JTable中制定单元格的数据
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
//				return "出错";
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
//	// 刷新JTable并显示数据
//	private void refreshTable() {
//		gfList = guestfoodBiz.queryGuestfood(zhuotai.getZhuotainum());
//		infoTableModel = new JiezhangInfoTableModel(gfList);
//		table.setModel(infoTableModel);
//	}
//
//	/**
//	 * 关闭窗口
//	 **/
//	private void close() {
//		this.dispose();
//	}

}