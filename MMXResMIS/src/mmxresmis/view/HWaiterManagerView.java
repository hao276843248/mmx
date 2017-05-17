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
	private JPanel paneltable=null;//���
	private JPanel panelnr = null;// neirong���11111111111
	private JPanel panelBtoon = null;// ��ť�����
	private JScrollPane scrollPane =null;//�������
	private JTable table=null;//������
	private JButton btn_add=null;//��Ӱ�ť
	private JButton btn_del=null;//ɾ����ť
	private JLabel lb_wnum=null;//����Ա�ű�ǩ 
	private JLabel lb_wname=null;
	private JLabel lb_wsex=null;
	private JLabel lb_wage=null;
	private JLabel lb_wtel=null; 
	private JTextField tf_wnum=null;//����Ա�ı���  
	private JTextField tf_wname=null;
	private JTextField tf_wsex=null;
	private JTextField tf_wage=null;
	private JTextField tf_wtel=null;
	
	private WaiterBiz waiterbiz = new WaiterBizImpl1();
	private List<Waiter> waiter = new ArrayList<>();
//	private WaiterBiz waiterBiz = null;// �������ҵ���
//	private List<Waiter> wList = null;
	private WaiterInfoTableModel infoTableModel = null;
		
    public HWaiterManagerView(){
//    	waiterBiz = new WaiterBizImpl1();// ������Ӧ�û�ҵ������
    	init();
//    	registerListener();
    }
    
    private void init() {
        setTitle("����Ա�������");
//	   	setBounds(200,120,880,500);//setBounds(x,y,width,height)
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�˳��رմ��幦��  	   
		this.setIconifiable(true);
		this.setClosable(true);
		this.setLayout(new BorderLayout());
		waiter =waiterbiz.findallWaiter();

//		waiter = new ArrayList<Waiter>();
		table = new JTable();
		// ��JTable������ģ�ͳ�������
		refreshTable(waiter);
		
		paneltable = new JPanel(new BorderLayout());// �������
//		table = new JTable();
		// ��������ñ߿�
		Border btable = (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "����Ա��Ϣ"));
		paneltable.setBorder(btable);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setPreferredSize(new Dimension(200,200));
		paneltable.add(jsp);
		this.add(paneltable,BorderLayout.NORTH);
		
		panelBtoon = new JPanel(new GridLayout(1, 2, 10, 20));
		panelBtoon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "��ѯ����"));
		this.add(panelBtoon, BorderLayout.SOUTH);
		btn_add = new JButton("��ӷ���Ա");// ����û�
		panelBtoon.add(btn_add);
		btn_del = new JButton("ɾ���˷���Ա");// ����û�
		panelBtoon.add(btn_del);
		
		panelnr = new JPanel(new GridLayout(1, 10, 0, 10));
		panelnr.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "����"));
		this.add(panelnr, BorderLayout.CENTER);
		lb_wnum = new JLabel("����Ա��");
		panelnr.add(lb_wnum);
		tf_wnum = new JTextField(5);
		panelnr.add(tf_wnum);
		lb_wname = new JLabel("����Ա��");
		panelnr.add(lb_wname);
		tf_wname = new JTextField(5);
		panelnr.add(tf_wname);
		lb_wsex = new JLabel("�Ա�");
		panelnr.add(lb_wsex);
		tf_wsex = new JTextField(5);
		panelnr.add(tf_wsex);	
		lb_wage = new JLabel("����");
		panelnr.add(lb_wage);
		tf_wage = new JTextField(5);
		panelnr.add(tf_wage);	
		lb_wtel = new JLabel("�绰");
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
				int flag = JOptionPane.showInternalConfirmDialog(HWaiterManagerView.this, "�Ƿ�ȷ��ɾ���˷���Ա��", "ȷ����Ϣ",
						JOptionPane.YES_NO_OPTION);
				if (flag == JOptionPane.YES_OPTION) {
					boolean res = waiterbiz.delWaiter(wid);
					if (res) {
						JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, " ɾ���ɹ�");
					} else {
						JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, " ɾ��ʧ��");
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
//					JOptionPane.showInternalMessageDialog(HFoodtypeManagerView.this, "��Ʒ���Ͳ���Ϊ��"); // JOptionPane��Ϣ��
//					return;
				} else if (rowValues[1].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "����Ա�Ų���Ϊ��"); // JOptionPane��Ϣ��
					return;
				}else if (rowValues[2].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "����Ա������Ϊ��"); // JOptionPane��Ϣ��
					return;
				}else if (rowValues[3].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "�Ա���Ϊ��"); // JOptionPane��Ϣ��
					return;
				}else if (rowValues[4].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "���䲻��Ϊ��"); // JOptionPane��Ϣ��
					return;
				}else if (rowValues[5].equals("")) {
					JOptionPane.showInternalMessageDialog(HWaiterManagerView.this, "�绰����Ϊ��"); // JOptionPane��Ϣ��
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

		// JTable��ʾ ����������
		@Override
		public int getRowCount() {
			return wlist.size();
		}

		// JTable���ݵ�����
		@Override
		public int getColumnCount() {
			return 6;
		}

		// ����JTable����ʾ������
		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "����Աid";
			} else if (columnIndex == 1) {
				return "����Ա��";
			} else if (columnIndex == 2) {
				return "����Ա��";
			} else if (columnIndex == 3) {
				return "�Ա�";
			} else if (columnIndex == 4) {
				return "����";
			} else if (columnIndex == 5) {
				return "�绰";
			} 
			else {
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
	private void refreshTable(List<Waiter> wList) {
		infoTableModel = new WaiterInfoTableModel(wList);
		table.setModel(infoTableModel);
	}

}

    






