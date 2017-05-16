package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class Order_itemView extends JFrame	 {
	private static final long serialVersionUID = 2123698427305956225L;
//  private JPanel btn_panel=null;//��ť�����
    private JPanel panel_left=null;
    private JPanel panel_right=null;
    private JPanel panel1=null;
    private JPanel panel2=null;
    private JPanel panel3=null;
    private JPanel panel4=null;
    private JPanel panel5=null;
  
    private JSplitPane splitPane=null;//�ָ�������
    
    private JTree tree=null;//��
    private DefaultTreeModel treeModel=null;//��ģ��
    private DefaultMutableTreeNode root =null;//���ڵ�
    private DefaultMutableTreeNode node1 =null;//�ӽڵ�1
    private DefaultMutableTreeNode node2 =null;//�ӽڵ�2
    private DefaultMutableTreeNode node3 =null;//�ӽڵ�3
    private DefaultMutableTreeNode node4 =null;//�ӽڵ�4
    private DefaultMutableTreeNode node5 =null;//�ӽڵ�5
    
    
	private JLabel lb_foodnum;//�˺ű�ǩ
	private JLabel lb_foodname;
	private JLabel lb_wnum;
	private JLabel lb_beizhu;
	private JLabel lb_foodprice;
	private JLabel lb_foodsum;
	private JLabel lb_foodallprice;
	
	private JTextField tf_foodnum=null;//�˺������б��
	private JTextField tf_foodname=null;
	private JTextField tf_wnum=null; 
	private JTextField tf_beizhu=null;
	private JTextField tf_foodprice=null;
	private JTextField tf_foodsum=null;
	private JTextField tf_foodallprice=null;
	
	private JButton btn_equal=null;//���ڰ�ť
	private JButton btn_insert=null;//������ť
	private JButton btn_delete=null;
	private JButton btn_submit=null;
	private JButton btn_exit=null;
	
	private DefaultTableModel tableModel =null;//���ģ��
	private JTable table=null;//������
	private JScrollPane scrollPane =null;//�������
	
	//private JLabel deskLabel=null;
	
	public Order_itemView(){
		init();
//		registerListener();
	}
		
	private void init(){
		this.setSize(880,420);//���ô����С
		this.setResizable(false);//�����϶������С
//		this.setClosable(true);//����ɱ��ر�
//		this.setIconifiable(true);//JInternalFrame��Ƕ���壬�������С��
//		this.setLocationRelativeTo(null);//���������ʾ
		this.setTitle("��/�Ӳ˴���");// ���ñ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�˳��رմ��幦��
		
		
		 //��ʼ�����ڵ���ӽڵ�
        root = new DefaultMutableTreeNode("�˵�");
        node1 = new DefaultMutableTreeNode("����");
        node2 = new DefaultMutableTreeNode("�ղ�");
        node3 = new DefaultMutableTreeNode("����");
        node4 = new DefaultMutableTreeNode("�ز�");
        node5 = new DefaultMutableTreeNode("��");

        //���ø��ڵ㴴��TreeModel
        treeModel = new DefaultTreeModel(root);
        //�����ӽڵ�node1,node2,node3,node4,node5
        treeModel.insertNodeInto(node1, root, root.getChildCount());
        treeModel.insertNodeInto(node2, root, root.getChildCount());
        treeModel.insertNodeInto(node3, root, root.getChildCount());
        treeModel.insertNodeInto(node4, root, root.getChildCount());
        treeModel.insertNodeInto(node5, root, root.getChildCount());
        
        //�����ڵ�node1���ӽڵ㲢����
        DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("�ཷƤ��");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("ˬ��ľ��");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("������˿");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("���ֻ�����");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        leafnode = new DefaultMutableTreeNode("���Ͷ�Ƭ");
        treeModel.insertNodeInto(leafnode, node1, node1.getChildCount());
        
        //�����ڵ�node2���ӽڵ㲢���� 
        leafnode = new DefaultMutableTreeNode("������ţ��");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("������");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
		leafnode = new DefaultMutableTreeNode("�Ǵ��Ź�");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("ëѪ��");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        leafnode = new DefaultMutableTreeNode("ˮ����Ƭ");
        treeModel.insertNodeInto(leafnode, node2, node2.getChildCount());
        
        leafnode = new DefaultMutableTreeNode("���Ӽ���");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("����Ϻ");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("����˿");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("��ɳ����");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        leafnode = new DefaultMutableTreeNode("������˿");
        treeModel.insertNodeInto(leafnode, node3, node3.getChildCount());
        
        leafnode = new DefaultMutableTreeNode("�ҳ�����");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("���ѳ���");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("��������");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("��Ƥ�ཷ");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        leafnode = new DefaultMutableTreeNode("����ź��");
        treeModel.insertNodeInto(leafnode, node4, node4.getChildCount());
        
        leafnode = new DefaultMutableTreeNode("������");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("��˷�˿��");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("�ϲ˵�����");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("����������");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        leafnode = new DefaultMutableTreeNode("���Ѽ嵰��");
        treeModel.insertNodeInto(leafnode, node5, node5.getChildCount());
        
        tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setRowHeight(20);
        
     //�����ڵ���ƶ���
       DefaultTreeCellRenderer cellRenderer = 
       	                  (DefaultTreeCellRenderer)tree.getCellRenderer();
       //��������
       cellRenderer.setFont(new Font("Serif", Font.PLAIN, 14));
       cellRenderer.setBackgroundNonSelectionColor(Color.white);
       cellRenderer.setBackgroundSelectionColor(Color.yellow);
       cellRenderer.setBorderSelectionColor(Color.red);
       
       //����ѡʱ��ѡʱ�����ֵı仯��ɫ
       cellRenderer.setTextNonSelectionColor(Color.black);
       cellRenderer.setTextSelectionColor(Color.blue);
             
	    
	    //��ʼ�����
	    panel_left=new JPanel(new GridLayout(1,1,0,0));
		panel_right=new JPanel(new GridLayout(6,1,5,10));//�������������ˮƽ��ֱ���
		panel1=new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2=new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3=new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4=new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5=new JPanel();
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//��ʼ���ָ���
    	splitPane=new JSplitPane();
    	splitPane.setDividerSize(10);//���÷ָ��ߴ�С
		
		//��ʼ���ؼ�
		lb_foodnum=new JLabel("�˺�");
		lb_foodname=new JLabel("����");
		lb_wnum=new JLabel("����Ա��");
		lb_beizhu=new JLabel("��ע");
		lb_foodprice=new JLabel("����");
		lb_foodsum=new JLabel("*����");
		lb_foodallprice=new JLabel("�ܼ�");
		
		tf_foodnum=new JTextField(8);
		tf_foodname=new JTextField(8);
		tf_wnum=new JTextField(8);
		tf_beizhu=new JTextField(8);
		tf_foodprice=new JTextField(8);
		tf_foodsum=new JTextField(8);
		tf_foodallprice=new JTextField(8);
		
		btn_equal=new JButton("=");
		btn_insert=new JButton("����");
		btn_delete=new JButton("ɾ��");
		btn_submit=new JButton("�ύ");
		btn_exit=new JButton("�˳�");
		
//		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����  
//		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
        String[] columnNames = {"�˺�","����","����Ա��","����","����","�ܼ�"};//��������������	       
        String[][] tableValues ={{"��","����","���","��","���","��V"},{"��","����","���","��","���","��V"},{"��","����","���","��","���","��V"}}; //���Ԫֵ
        tableModel =new DefaultTableModel(tableValues,columnNames);//�����ƶ����������ݵı��
	    table=new JTable(tableModel);
        scrollPane=new JScrollPane(table);//������ʾ���Ĺ������
        
	    //�ѿռ�ݵ���Ӧλ����
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
		panel4.add(btn_insert);
		panel4.add(btn_delete);
		panel4.add(btn_submit);
		panel4.add(btn_exit);
		panel5.add(scrollPane,BorderLayout.CENTER);
		 
		 panel_left.add(tree);
		 panel_right.add(panel1);
		 panel_right.add(panel2);
		 panel_right.add(panel3);
		 panel_right.add(panel4);
		 panel_right.add(panel5);
		 
		 splitPane.setLeftComponent(panel_left);//��panel_left�ŵ��ָ�����ߣ�panel_right�ŵ��ұ�
	     splitPane.setRightComponent(panel_right);
		 this.getContentPane().add(splitPane);//�������		
		 this.setVisible(true);//��ʾ����
		 
		 splitPane.setDividerLocation(0.3);//���ұ�����С
//	     splitPane.setEnabled(false);//�ָ��߲��������ƶ�
	}

	private void registerListener(){
				   btn_delete.addActionListener(new ActionListener(){ 	
						@Override
						public void actionPerformed(ActionEvent e) {
							int[] seleteRows=table.getSelectedRows();	
							for(int row=0;row<seleteRows.length;row++){
								tableModel.removeRow(seleteRows[row]- row);
						} 
						}
			   	});
				   
				   btn_submit.addActionListener(new ActionListener(){ 	
						@Override
						public void actionPerformed(ActionEvent e) {
							String[] rowValues={tf_foodnum.getText(),tf_foodname.getText(),tf_wnum.getText(),
									tf_foodprice.getText(),tf_foodsum.getText(),tf_foodallprice.getText()};
							tableModel.addRow(rowValues);
							tf_foodnum.setText(null);
							tf_foodname.setText(null);
							tf_wnum.setText(null);
							tf_foodprice.setText(null);
							tf_foodsum.setText(null);
							tf_foodallprice.setText(null);				
						} 			
			  	});
			   }	
	
}
