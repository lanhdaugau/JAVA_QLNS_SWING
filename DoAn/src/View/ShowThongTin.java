package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowThongTin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private View view;
	private JTextField text_ma;
	private JTextField text_gioi_tinh;
	private JTextField text_sdt;
	private JTextField text_email;
	private JTextField text_hoten;
	private JTextField text_que_quan;
	private JTextField text_chuc_vu;
	private JTextField text_phong;
	private JLabel lb_anh;
	
	public ShowThongTin(JFrame parent) {
		super(parent);
		view= (View) parent;
		setBounds(100, 50, 610, 463);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(228, 11, 134, 156);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lb_anh = new JLabel("");
		lb_anh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_anh.setBounds(10, 11, 114, 134);
		panel.add(lb_anh);
		lb_anh.setIcon(new ImageIcon(view.linkanhcanhan));
		
		JLabel lblNewLabel_1 = new JLabel("Mã :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(51, 180, 66, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(38, 221, 66, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(321, 180, 66, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quê quán:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(321, 221, 66, 14);
		contentPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số điện thoại:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(10, 268, 91, 14);
		contentPanel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Email:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(38, 317, 66, 14);
		contentPanel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Mã chức vụ:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(307, 268, 80, 14);
		contentPanel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Mã phòng:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(307, 317, 80, 14);
		contentPanel.add(lblNewLabel_1_7);
		
		text_ma = new JTextField();
		text_ma.setEditable(false);
		text_ma.setBounds(96, 179, 134, 20);
		contentPanel.add(text_ma);
		text_ma.setColumns(10);
		text_ma.setText(view.ma);
		
		text_gioi_tinh = new JTextField();
		text_gioi_tinh.setEditable(false);
		text_gioi_tinh.setColumns(10);
		text_gioi_tinh.setBounds(96, 218, 134, 20);
		contentPanel.add(text_gioi_tinh);
		text_gioi_tinh.setText(view.gioitinh);
		
		text_sdt = new JTextField();
		text_sdt.setEditable(false);
		text_sdt.setColumns(10);
		text_sdt.setBounds(96, 265, 134, 20);
		contentPanel.add(text_sdt);
		text_sdt.setText(view.sodienthoai);
		
		text_email = new JTextField();
		text_email.setEditable(false);
		text_email.setColumns(10);
		text_email.setBounds(96, 314, 134, 20);
		contentPanel.add(text_email);
		text_email.setText(view.email);
		
		text_hoten = new JTextField();
		text_hoten.setEditable(false);
		text_hoten.setColumns(10);
		text_hoten.setBounds(397, 179, 134, 20);
		contentPanel.add(text_hoten);
		text_hoten.setText(view.hoten);
		
		text_que_quan = new JTextField();
		text_que_quan.setEditable(false);
		text_que_quan.setColumns(10);
		text_que_quan.setBounds(397, 218, 134, 20);
		contentPanel.add(text_que_quan);
		text_que_quan.setText(view.quequan);
		
		text_chuc_vu = new JTextField();
		text_chuc_vu.setEditable(false);
		text_chuc_vu.setColumns(10);
		text_chuc_vu.setBounds(397, 265, 134, 20);
		contentPanel.add(text_chuc_vu);
		text_chuc_vu.setText(view.chucvu);
		
		text_phong = new JTextField();
		text_phong.setEditable(false);
		text_phong.setColumns(10);
		text_phong.setBounds(397, 314, 134, 20);
		contentPanel.add(text_phong);
		text_phong.setText(view.phong);
		
		JButton bt_ok = new JButton("OK");
		bt_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		bt_ok.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_ok.setBounds(245, 374, 89, 23);
		contentPanel.add(bt_ok);
	}
}
