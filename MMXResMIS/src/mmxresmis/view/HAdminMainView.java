package mmxresmis.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;

public class HAdminMainView extends JFrame {
	private static final long serialVersionUID = 7942766018128337161L;
	private JMenuBar mBar=null;//�˵���
	private JPanel panel_left=null;//���
	private JPanel panel_right=null;
	private JPanel panel1=null; 
    private JPanel panel2=null;
    private JPanel panel3=null;
    private JPanel panel4=null; 
    private JPanel panel5=null;
    private JPanel panel6=null;
    private JPanel panel7=null;
    private JPanel panel8=null; 
    private JPanel panel9=null;
    private JFrame frame=null;
    
    private JSplitPane splitPane=null;//�ָ�������
	 
    private JMenu syMenu=null;//ϵͳ��ҳ�˵�
	private JMenu xgMenu=null;//�޸���������˵�
	private JMenu ctMenu=null;//������Ϣ�����˵�
	private JMenu yhMenu=null;//�û���Ϣ�����˵�
	private JMenu cpMenu=null;//��Ʒ��Ϣ�����˵�
	private JMenu ddMenu=null;//������Ϣ����
	private JMenu tcMenu=null;//�˳�
	
	private JMenuItem syMenuItem=null;
	 private JMenuItem xgMenuItem=null;
	 private JMenuItem ctMenuItem=null;
	 private JMenuItem yhMenuItem=null;
	 private JMenuItem foodMenuItem=null;
	 private JMenuItem foodtypeMenuItem=null;
	 private JMenuItem ddMenuItem=null;
	 private JMenuItem tcMenuItem=null;
	 
	private JLabel lb_gonggao=null;
	private JLabel lb_lianxi=null;
	private JLabel lb_tel=null;
	private JLabel lb_addr=null;
	
    private JLabel deskLabel1=null;//���ͼƬ��Label
    private JLabel deskLabel2=null;
    private JLabel deskLabel3=null;
    private JLabel deskLabel4=null;
    private JLabel deskLabel5=null;//���ͼƬ��Label
    private JLabel deskLabel6=null;
    private JLabel deskLabel7=null;
    private JLabel deskLabel8=null;
    private JLabel deskLabel9=null;//���ͼƬ��Label
    private JLabel deskLabel10=null;
    private JLabel deskLabel11=null;
    private JLabel deskLabel12=null;
    private JLabel deskLabel13=null;//���ͼƬ��Label
    private JLabel deskLabel14=null;
    

    private JPopupMenu popupMenu1;
    private JPopupMenu popupMenu2;
    
    
	private JMenuItem jibenxinxi=null;//��̨������Ϣ
//	private JMenuItem xiugaiZT=null;//�޸���̨
	private JMenuItem deleteZT=null;//ɾ����̨
	private JMenuItem ztxiangqing=null;//״̬����
//	private JMenuItem kaitai=null;//��̨
//	private JMenuItem cancelkaitai=null;//ȡ����̨
//	private JMenuItem xiaofeichaxun=null;//���Ѳ�ѯ
//	private JMenuItem jiezhang=null;//����    
	private JMenuItem addZT=null;//������̨
	
	public HAdminMainView(){
	    init();
	    registerListener();
	}
	
	private void init(){
		//��ʼ���˵����
    	mBar=new JMenuBar();
    	panel_left=new JPanel(new  GridLayout(10,1,0,35));
    	panel_right=new JPanel();
    	panel1=new JPanel();
    	panel2=new JPanel();
    	panel3=new JPanel();
    	panel4=new JPanel();
    	panel5=new JPanel();
    	panel6=new JPanel();
    	panel7=new JPanel();
    	panel8=new JPanel();
    	panel9=new JPanel();
    	
    	ImageIcon image1=new ImageIcon("src/images/a_1.jpg");
    	deskLabel1=new JLabel(image1);
    	deskLabel1.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel2=new JLabel(image1);
    	deskLabel2.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel3=new JLabel(image1);
    	deskLabel3.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel4=new JLabel(image1);
    	deskLabel4.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel5=new JLabel(image1);
    	deskLabel5.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel6=new JLabel(image1);
    	deskLabel6.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	deskLabel7=new JLabel(image1);
    	deskLabel7.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());   	
    	deskLabel8=new JLabel(image1);
    	deskLabel8.setBounds(0,0,image1.getIconWidth(),image1.getIconHeight());
    	
    	ImageIcon image2=new ImageIcon("src/images/a_3.jpg");
    	deskLabel9=new JLabel(image2);
    	deskLabel9.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel10=new JLabel(image2);
    	deskLabel10.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel11=new JLabel(image2);
    	deskLabel11.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel12=new JLabel(image2);
    	deskLabel12.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel13=new JLabel(image2);
    	deskLabel13.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());
    	deskLabel14=new JLabel(image2);
    	deskLabel14.setBounds(0,0,image2.getIconWidth(),image2.getIconHeight());

    	//��ʼ��������
		splitPane=new JSplitPane();
//    	splitPane.setOneTouchExpandable(true);//�÷ָ�����ʾ����ͷ
//    	splitPane.setContinuousLayout(true);//���û������ָ���ʱϵͳ�����»�ͼ��???û��Ӱ��
    	splitPane.setDividerSize(10);//���÷ָ��ߴ�СΪ10����λ     ������
    	
    	popupMenu1 = new JPopupMenu();
    	popupMenu2 = new JPopupMenu();
    	
    	//��ʼ���˵�
    	syMenu=new JMenu("ϵͳ��ҳ");
    	xgMenu=new JMenu("�޸��������");
    	ctMenu=new JMenu("������Ϣ����");
    	yhMenu=new JMenu("�û���Ϣ����");
    	cpMenu=new JMenu("��Ʒ��Ϣ����");
    	ddMenu=new JMenu("������Ϣ����");
    	tcMenu=new JMenu("�˳�");
	    
    	syMenuItem=new JMenuItem("ϵͳ��ҳ");
    	xgMenuItem=new JMenuItem("�޸��������");
    	ctMenuItem=new JMenuItem("������Ϣ����");
    	yhMenuItem=new JMenuItem("�û���Ϣ����");
    	foodMenuItem=new JMenuItem("��Ʒ��Ϣ����");
    	foodtypeMenuItem=new JMenuItem("��Ʒ������Ϣ����");
    	ddMenuItem=new JMenuItem("������Ϣ����");
    	tcMenuItem=new JMenuItem("�˳�ϵͳ");
    	
	    //��ʼ����ǩ
	  	lb_gonggao=new JLabel("����");
	  	lb_lianxi=new JLabel("��ϵ����");
	  	lb_lianxi.setFont(new Font("����",Font.BOLD,20));//��������
		lb_lianxi.setForeground(Color.red);//������ɫ
		lb_tel=new JLabel("�绰:15612494925");
		lb_tel.setFont(new Font("����",Font.BOLD,15));
		lb_addr=new JLabel("��ַ:�ӱ����ʴ�ѧ");
		lb_addr.setFont(new Font("����",Font.BOLD,15));
		
		jibenxinxi = new JMenuItem("��̨������Ϣ");
		ztxiangqing = new JMenuItem("��̨״̬");
		deleteZT = new JMenuItem("ɾ����̨");
//		kaitai = new JMenuItem("��̨");
//		cancelkaitai = new JMenuItem("ȡ����̨");
//		xiaofeichaxun = new JMenuItem("���Ѳ�ѯ");
//		jiezhang = new JMenuItem("����");
		addZT = new JMenuItem("������̨");
		
		//�ѿؼ��ӵ���Ӧ��λ����
	  	syMenu.add(syMenuItem);
	  	xgMenu.add(xgMenuItem);
	  	ctMenu.add(ctMenuItem);
	  	yhMenu.add(yhMenuItem);
	  	cpMenu.add(foodMenuItem);
	  	cpMenu.add(foodtypeMenuItem);
	  	ddMenu.add(ddMenuItem);
	  	tcMenu.add(tcMenuItem);
	  	
	    mBar.add(syMenu);
	    mBar.add(xgMenu);
	    mBar.add(ctMenu);
	    mBar.add(yhMenu);
	    mBar.add(cpMenu);
	    mBar.add(ddMenu);	    
	    mBar.add(tcMenu);
	    
	    panel2.add(lb_gonggao);
    	panel4.add(lb_lianxi);
    	panel5.add(lb_tel);
    	panel6.add(lb_addr);
    	panel7.add(deskLabel1);
    	panel7.add(deskLabel2);
    	panel7.add(deskLabel3);
    	panel7.add(deskLabel4);
    	panel7.add(deskLabel5);
    	panel7.add(deskLabel6);
    	panel7.add(deskLabel7);
    	panel7.add(deskLabel8);
    	panel9.add(deskLabel9);
    	panel9.add(deskLabel10);
    	panel9.add(deskLabel11);
    	panel9.add(deskLabel12);
    	panel9.add(deskLabel13);
    	panel9.add(deskLabel14);
    	
    	panel_left.add(panel1);
     	panel_left.add(panel2);
     	panel_left.add(panel3);
     	panel_left.add(panel4);
     	panel_left.add(panel5);
     	panel_left.add(panel6);
    	panel_right.add(panel7);
    	panel_right.add(panel8);
    	panel_right.add(panel9);
    	
    	popupMenu1.add(jibenxinxi);
    	popupMenu1.add(ztxiangqing);
    	popupMenu1.add(deleteZT);
//    	popupMenu1.add(cancelkaitai);
//    	popupMenu1.add(orderitem);
//    	popupMenu1.add(xiaofeichaxun);
//    	popupMenu1.add(jiezhang);
    	
    	popupMenu2.add(addZT);
  	
    	splitPane.setLeftComponent(panel_left);//��panel_left�ŵ��ָ�����ߣ�panel_right�ŵ��ұ�
    	splitPane.setRightComponent(panel_right);

    	this.getContentPane().add(splitPane);
	    this.setJMenuBar(mBar);
	    this.setSize(1000, 650);
	    this.setTitle("��С�Ͳ�������ϵͳ��̨");
	    this.setVisible(true);
	    this.setResizable(false);//���ɸı䴰���С
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
	    this.setLocationRelativeTo(null);//������ʾ
	    	
	    splitPane.setDividerLocation(0.3);//���ұ�����С
    	splitPane.setEnabled(false);//�ָ��߲��������ƶ�	
	    }
	
    private void registerListener(){
    	yhMenuItem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				HUserManagerView Huserv=new HUserManagerView();
				panel_right.add(Huserv);//��ָ������ͼ���ӵ�����������
				Huserv.toFront();//��ͼ��ʾ����ǰ��				
			}   		
    	});
    	
    	foodMenuItem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				HFoodManagerView hfview=new HFoodManagerView();
				panel_right.add(hfview);//��ָ������ͼ���ӵ�����������
				hfview.toFront();//��ͼ��ʾ����ǰ��				
			}   		
    	});
    	
    	foodtypeMenuItem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {
				HFoodtypeManagerView hftview=new HFoodtypeManagerView();
				panel_right.add(hftview);//��ָ������ͼ���ӵ�����������
				hftview.toFront();//��ͼ��ʾ����ǰ��				
			}   		
    	});
    	


    	
    	tcMenuItem.addActionListener(new ActionListener(){ 	
			@Override
			public void actionPerformed(ActionEvent e) {	
				if (JOptionPane.showConfirmDialog(frame,"ȷ���˳�?") == JOptionPane.YES_OPTION)
		        {
					System.exit(0);	
		        }

			}   		
    	});
    	
    	panel_right.addMouseListener(new MouseAdapter(){   		
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu2.show(e.getComponent(), p.x, p.y);
    				
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu2.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel1.addMouseListener(new MouseAdapter(){   		
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    				
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel2.addMouseListener(new MouseAdapter(){    		
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}   			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel3.addMouseListener(new MouseAdapter(){    		
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel4.addMouseListener(new MouseAdapter(){  		
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}   			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel5.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel6.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();   				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel7.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}   			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel8.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();   				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}   			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel9.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel10.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel11.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel12.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel13.addMouseListener(new MouseAdapter(){
    		@Override
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}   			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    	deskLabel14.addMouseListener(new MouseAdapter(){
    		public void mouseClicked(MouseEvent e){
    			//�������Ҽ�  ��ʾ�Ӳ˵�
    			if(e.getButton() == MouseEvent.BUTTON3){
    				//��ȡ����ڴ��ڵ��߼�λ��
    				Point p = e.getPoint();    				
    				popupMenu1.show(e.getComponent(), p.x, p.y);
    			}    			
    			//������ʾ�Ӳ˵�
    			else{
    				popupMenu1.setVisible(false);
    			}
    		}
    	});
    	
    deleteZT.addActionListener(new ActionListener(){ 	
		@Override
		public void actionPerformed(ActionEvent e) {	
			if (JOptionPane.showConfirmDialog(frame,"ȷ��ɾ������̨?") == JOptionPane.YES_OPTION)
	        {
//				System.exit(0);	//��������������������������������������
//				int[] seleteRows=deleteZT.getSelectedRows();
	        }

		}   		
	});
    	


	}
	
}
	
	
