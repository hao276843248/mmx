package mmxresmis.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class HZhuotaiManagerView extends JInternalFrame {
	private static final long serialVersionUID = 3939275304556258785L;
	private JPanel paneltable = null;// ���
	private JPanel paneljiben = null;// ������Ϣ���
	private JPanel panelqita = null;// ������Ϣ���

	private JLabel lb_zhuotainum = null;
	private JLabel lb_zhuotaijc = null;
	private JLabel lb_zhuotaibjf = null;//
	private JLabel lb_zhuotaiwz = null;
	private JLabel lb_zhuotaizt = null;
	private JLabel lb_zhuotaitype = null;//
	private JLabel lb_zhuotaibz = null;
	private JLabel lb_zhuotaiqi = null;

	private JButton btn_xiugai;

	private JTextField textField1 = null;
	private JTextField textField2 = null;
	private JTextField textField3 = null;
	private JTextField textField4 = null;
	private JTextField textField5 = null;
	private JTextField textField6 = null;
	private JTextField textField7 = null;

	private JTextArea tf_beizhu = null;// ��ע�ı���
	private JTextArea tf_qita = null;// �����ı���

	public HZhuotaiManagerView() {
		init();
	}

	private void init() {
		setTitle("��̨������Ϣ");
		setBounds(200, 120, 560, 420);// setBounds(x,y,width,height)
		this.setIconifiable(true);
		this.setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);// �˳��رմ��幦��
		this.setLayout(new BorderLayout());

		paneltable = new JPanel(new BorderLayout());// �������
		// ��������ñ߿�
		Border btable = (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "��̨������Ϣ"));
		paneltable.setBorder(btable);
		this.add(paneltable, BorderLayout.CENTER);
		paneljiben = new JPanel(new GridLayout(8, 2, 10, 10));
		paneljiben.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "������Ϣ"));
		this.add(paneljiben, BorderLayout.EAST);
		lb_zhuotainum = new JLabel("��̨��");
		paneljiben.add(lb_zhuotainum);
		textField1 = new JTextField(5);
		paneljiben.add(textField1);
		lb_zhuotaijc = new JLabel("���");
		paneljiben.add(lb_zhuotaijc);
		textField2 = new JTextField(5);
		paneljiben.add(textField2);
		lb_zhuotaibjf = new JLabel("�����");
		paneljiben.add(lb_zhuotaibjf);
		textField3 = new JTextField(5);
		paneljiben.add(textField3);
		lb_zhuotaiwz = new JLabel("λ��");
		paneljiben.add(lb_zhuotaiwz);
		textField4 = new JTextField(5);
		paneljiben.add(textField4);
		lb_zhuotaizt = new JLabel("״̬");
		paneljiben.add(lb_zhuotaizt);
		textField5 = new JTextField(5);
		paneljiben.add(textField5);
		lb_zhuotaitype = new JLabel("����");
		paneljiben.add(lb_zhuotaitype);
		textField6 = new JTextField(5);
		paneljiben.add(textField6);
		lb_zhuotaibz = new JLabel("��ע");
		paneljiben.add(lb_zhuotaibz);
		textField7 = new JTextField(5);
		paneljiben.add(textField7);

		panelqita = new JPanel(new GridLayout(8, 2, 10, 10));
		panelqita.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null, null), "������Ϣ"));
		this.add(panelqita, BorderLayout.WEST);
		lb_zhuotaiqi = new JLabel("����");
		paneljiben.add(lb_zhuotaiqi);

		this.setVisible(true);

	}

}
