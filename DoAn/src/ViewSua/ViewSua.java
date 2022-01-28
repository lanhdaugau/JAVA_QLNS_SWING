package ViewSua;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import View.View;
import ViewNhap.ViewNhap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeEvent;

public class ViewSua extends JDialog  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] tinh= {"","Tuyên Quang","Hà Giang","Cao Bằng","Lạng Sơn","Bắc Giang","Hạ Long",
			"Bắc Kạn","Thái Nguyên","Việt Trì","Hoà Bình","Sơn La","Điện Biên","Lai Châu","Lào Cai",
			"Yên Bái","Hà Nội","Bắc Ninh","Hà Nam","Hải Dương","Hải Phòng","Hưng Yên","Nam Định",
			"Thái Bình","Vĩnh Phúc","Ninh Bình","Thanh Hoá","Nghệ An","Hà Tĩnh","Quảng Bình"
			,"Quảng Trị","Thừa Thiên Huế","Đà Nẵng","Quảng Nam","Quảng Ngãi","Bình Định","Phú Yên"
			,"Khánh Hoà","Ninh Thuận","Bình Thuận","Kon Tum","Gia Lai","Đắk Lắk","Đắk Nông","Lâm Đồng",
			"TP Hồ Chí Minh","Bà Rịa - Vũng Tàu","Bình Dương","Bình Phước","Đồng Nai","Tây Ninh",
			"An Giang","Cà Mau","Bạc Liêu","Sóc Trăng","Tiền Giang",
			"Kiên Giang","Bến Tre","Long An","Đồng Tháp","Cần Thơ","Trà Vinh","Vĩnh Long"};
	private int []bacluong= {1,2,3,4,5,6,7,8};
	private JPanel contentPane;
	private JTextField text_ho_ten;
	private JDateChooser text_ngay_sinh;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField text_sdt;
	private JTextField text_dan_toc;
	private JTextField text_soCMND;
	private JDateChooser text_ngay_cap;
	private JTextField text_email;
	private JDateChooser text_ngay_vaocty;
	private JTextField text_ma;
	private JLabel lb_anh;
	private JComboBox<Object> cbb_chuc_vu;
	private JComboBox<Object> cbb_phong_ban;
	private String link="";
	//	private String maTimKiem="";
	private JRadioButton rdnam;
	private JRadioButton rdnu;
	private JComboBox<Object> cbb_tinh;
	private JComboBox<Object> cbb_noi_cap;
	private JButton bt_luu;
	private JButton bt_nhap_lai;
	private JButton bt_thoat;
	private JButton bt_cap_nhat;
	private JComboBox<Integer> cbb_bac_luong;
	private String phong;
	private View view;
	private boolean checkToanCuc=true;
	private String hoten;


	public ViewSua(JFrame parent,boolean modal) {
		super(parent,modal);
		view= (View) parent;
		
		setIconImage(Toolkit.getDefaultToolkit().createImage(ViewSua.class.getResource("edit.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 50, 996, 643);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cập nhật nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(196, 19, 360, 44);
		panel.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(26, 139, 691, 4);
		panel.add(separator);

		JLabel lblNewLabel_2 = new JLabel("Họ và Tên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(38, 168, 68, 17);
		panel.add(lblNewLabel_2);

		text_ho_ten = new JTextField();
		text_ho_ten.setBounds(146, 168, 264, 20);
		panel.add(text_ho_ten);
		text_ho_ten.setColumns(10);

		text_ngay_sinh = new JDateChooser();
		text_ngay_sinh.setBounds(146, 246, 115, 20);
		panel.add(text_ngay_sinh);


		JLabel lblNewLabel_2_1 = new JLabel("Số Điện Thoại:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(25, 379, 96, 17);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Giới tính:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(460, 168, 68, 17);
		panel.add(lblNewLabel_2_2);

		rdnam = new JRadioButton("Nam");
		buttonGroup.add(rdnam);
		rdnam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdnam.setBounds(570, 165, 75, 23);
		panel.add(rdnam);

		rdnu = new JRadioButton("Nữ");
		buttonGroup.add(rdnu);
		rdnu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdnu.setBounds(649, 165, 68, 23);
		panel.add(rdnu);

		JLabel lblNewLabel_3 = new JLabel("Quê quán:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(279, 246, 81, 17);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Ngày sinh:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(25, 246, 81, 17);
		panel.add(lblNewLabel_3_1);

		text_sdt = new JTextField();
		text_sdt.setBounds(146, 379, 105, 20);
		panel.add(text_sdt);


		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(25, 216, 249, 4);
		panel.add(separator_1_1);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(25, 288, 249, 4);
		panel.add(separator_1_2);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(25, 353, 249, 4);
		panel.add(separator_1_3);

		cbb_tinh = new JComboBox<Object>();
		cbb_tinh.setBounds(361, 245, 96, 22);
		panel.add(cbb_tinh);

		JLabel lblNewLabel_3_2 = new JLabel("Dân tộc:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(475, 246, 81, 17);
		panel.add(lblNewLabel_3_2);

		text_dan_toc = new JTextField();
		text_dan_toc.setAlignmentX(Component.LEFT_ALIGNMENT);
		text_dan_toc.setBounds(581, 246, 115, 20);
		panel.add(text_dan_toc);
		text_dan_toc.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Số CMND/CCCD:\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(25, 309, 105, 14);
		panel.add(lblNewLabel_4);

		text_soCMND = new JTextField();
		text_soCMND.setBounds(146, 308, 105, 20);
		panel.add(text_soCMND);
		text_soCMND.setColumns(10);

		JLabel lblNewLabel_3_1_1 = new JLabel("Nơi Cấp:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(279, 308, 81, 17);
		panel.add(lblNewLabel_3_1_1);

		cbb_noi_cap = new JComboBox<Object>();
		cbb_noi_cap.setBounds(361, 307, 96, 22);
		panel.add(cbb_noi_cap);

		JLabel lblNewLabel_3_1_2 = new JLabel("Ngày Cấp:");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(475, 312, 81, 17);
		panel.add(lblNewLabel_3_1_2);

		text_ngay_cap = new JDateChooser();

		text_ngay_cap.setBounds(581, 308, 115, 20);
		panel.add(text_ngay_cap);

		JLabel label = new JLabel("New label");
		label.setBounds(245, 382, -300, -92);
		panel.add(label);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Email:");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(279, 379, 81, 17);
		panel.add(lblNewLabel_3_1_1_1);

		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(361, 379, 105, 20);
		panel.add(text_email);

		JLabel lblNewLabel_3_1_2_1 = new JLabel("Ngày vào cty:");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1.setBounds(475, 379, 96, 17);
		panel.add(lblNewLabel_3_1_2_1);

		text_ngay_vaocty = new JDateChooser();

		text_ngay_vaocty.setBounds(581, 379, 115, 20);
		panel.add(text_ngay_vaocty);

		JLabel lblNewLabel_2_1_1 = new JLabel("Xưởng/phòng ban:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(25, 441, 129, 17);
		panel.add(lblNewLabel_2_1_1);

		cbb_phong_ban = new JComboBox<Object>();
		cbb_phong_ban.setBounds(146, 440, 105, 22);
		panel.add(cbb_phong_ban);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1_1.setBounds(279, 444, 81, 17);
		panel.add(lblNewLabel_3_1_1_1_1);

		cbb_chuc_vu = new JComboBox<Object>();
		cbb_chuc_vu.setBounds(359, 440, 105, 22);
		panel.add(cbb_chuc_vu);

		bt_luu = new JButton("Lưu lại");
		bt_luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhat(text_ma.getText());


				DefaultTableModel model = (DefaultTableModel) view.table.getModel();
				model.setRowCount(0);
				view.showUser();

			}
		});
		try {
			bt_luu.setIcon(new ImageIcon(ImageIO.read(ViewSua.class.getResourceAsStream("save_icon.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bt_luu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_luu.setBounds(404, 525, 105, 33);
		panel.add(bt_luu);

		bt_nhap_lai = new JButton("Nhập lại");
		try {
			bt_nhap_lai.setIcon(new ImageIcon(ImageIO.read(ViewSua.class.getResourceAsStream("reload_con.png")) ));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bt_nhap_lai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		bt_nhap_lai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_nhap_lai.setBounds(611, 525, 115, 33);
		panel.add(bt_nhap_lai);

		bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rec = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không? "
						, "Lưu ý",JOptionPane.YES_NO_OPTION);
				if(rec==JOptionPane.YES_OPTION) {

					dispose();
				}
			}
		});
		try {
			bt_thoat.setIcon(new ImageIcon(ImageIO.read(ViewSua.class.getResourceAsStream("out.png")) ));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bt_thoat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_thoat.setBounds(799, 525, 105, 33);
		panel.add(bt_thoat);

		text_ma = new JTextField();
		text_ma.setBounds(146, 96, 105, 20);
		panel.add(text_ma);
		text_ma.setColumns(10);

		JLabel lblNewLabel_2_3 = new JLabel("Mã    :");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(68, 96, 68, 17);
		panel.add(lblNewLabel_2_3);

		bt_cap_nhat = new JButton("Tìm và cập nhật\r\n");
		bt_cap_nhat.setMnemonic(KeyEvent.VK_ENTER);
		panel.getRootPane().setDefaultButton(bt_cap_nhat);
		bt_cap_nhat.setToolTipText("Bấm enter để tìm kiếm");
		bt_cap_nhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hienThi(text_ma.getText())==null) {
					JOptionPane.showMessageDialog(null, "Mã nhân sự bạn nhập không tồn tại!", "Lỗi nhập mã", JOptionPane.WARNING_MESSAGE);
				}
				else {
					hoten=null;
				}

			}
		});




		bt_cap_nhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bt_cap_nhat.setBounds(286, 95, 153, 23);
		panel.add(bt_cap_nhat);

		JLabel lblNewLabel = new JLabel("");
		try {
			lblNewLabel.setIcon(new ImageIcon(ImageIO.read(ViewSua.class.getResourceAsStream("edit.png")) ));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel.setBounds(95, 19, 74, 62);
		panel.add(lblNewLabel);
		JLabel lblNewLabel_3_3 = new JLabel("Ảnh thẻ  3×4 ");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(824, 119, 96, 17);
		panel.add(lblNewLabel_3_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(805, 188, 134, 156);
		panel.add(panel_1);
		panel_1.setLayout(null);

		lb_anh = new JLabel("");
		lb_anh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_anh.setBounds(10, 11, 114, 134);
		panel_1.add(lb_anh);

		JButton bt_chon_anh = new JButton("Sửa ảnh");
		bt_chon_anh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser= new JFileChooser();
				int option = chooser.showOpenDialog(ViewSua.this);
				if(option==JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					
					String fileName= file.getName();


					if(fileName.endsWith(".png")|| fileName.endsWith(".jpg")) {
						ImageIcon a= new ImageIcon(file.getAbsolutePath());
						lb_anh.setIcon(a);
						link =file.getAbsolutePath();

					}
				}
			}
		});
		bt_chon_anh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_chon_anh.setBounds(817, 376, 103, 23);
		panel.add(bt_chon_anh);
		// thêm tỉnh
		for(int i=0;i<tinh.length;i++) {
			cbb_tinh.addItem(tinh[i]);

		}
		// thêm nơi cấp cmnd
		for(int i=0;i<tinh.length;i++) {
			cbb_noi_cap.addItem(tinh[i]);

		}
		// chức vụ
		cbb_chuc_vu.addItem("");
		cbb_chuc_vu.addItem("Nhân Viên");
		cbb_chuc_vu.addItem("Quản Lý");
		cbb_chuc_vu.addItem("Phó Giám Đốc");
		cbb_chuc_vu.addItem("Giám Đốc");
		//phòng ban
		cbb_phong_ban.addItem("");
		cbb_phong_ban.addItem("Kế Toán");
		cbb_phong_ban.addItem("Hành Chính");
		cbb_phong_ban.addItem("Chăm sóc khách hàng");
		cbb_phong_ban.addItem("Nhân sự");
		cbb_phong_ban.addItem("Công nghệ thông tin");
		cbb_phong_ban.addItem("Quan hệ quốc tế");
		cbb_phong_ban.addItem("Marketing");

		cbb_bac_luong = new JComboBox<Integer>();
		cbb_bac_luong.setBounds(581, 440, 115, 22);
		panel.add(cbb_bac_luong);

		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("Bậc lương:");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1_1.setBounds(475, 441, 96, 17);
		panel.add(lblNewLabel_3_1_2_1_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("*");
		lblNewLabel_2_3_1.setForeground(Color.RED);
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(89, 96, 17, 17);
		panel.add(lblNewLabel_2_3_1);

		// bậc lương

		for(int i=0;i<bacluong.length;i++) {
			cbb_bac_luong.addItem(bacluong[i]);
		}

	}
	public void capNhat(String ma) {
		if(text_ho_ten.getText() !=null && text_ngay_sinh.getDate() !=null &&
				text_sdt.getText() !=null && 
				text_dan_toc.getText() !=null && text_email.getText() !=null &&
				text_ngay_cap.getDate()!=null && text_soCMND.getText() !=null && 
				cbb_noi_cap.getSelectedIndex()!=0 && cbb_phong_ban.getSelectedIndex()!=0 && 
				cbb_tinh.getSelectedIndex()!=0 && text_ma.getText()!=null
				&& cbb_bac_luong.getSelectedIndex()!=0) {
			String gioiTinh ="";

			if(rdnam.isSelected()) gioiTinh="Nam";
			else if(rdnu.isSelected()) gioiTinh="Nữ";
			// mã chức vụ
			String maChucVu="";
			if(cbb_chuc_vu.getSelectedIndex()==1) {
				maChucVu="NV";
			}
			else if(cbb_chuc_vu.getSelectedIndex()==2) {
				maChucVu="QL";
			}
			else if(cbb_chuc_vu.getSelectedIndex()==3) {
				maChucVu="PGD";
			}
			else if(cbb_chuc_vu.getSelectedIndex()==4) {
				maChucVu="GD";
			}
			//mã phòng
			String phong="";
			if(cbb_phong_ban.getSelectedIndex()==1) {
				phong="KT";
			}
			else if(cbb_phong_ban.getSelectedIndex()==2) {
				phong="HC";
			}
			else if(cbb_phong_ban.getSelectedIndex()==3) {
				phong="CSKH";
			}
			else if(cbb_phong_ban.getSelectedIndex()==4) {
				phong="NS";
			}
			else if(cbb_phong_ban.getSelectedIndex()==5) {
				phong="CNTT";
			}
			else if(cbb_phong_ban.getSelectedIndex()==6) {
				phong="QHQT";
			}
			else if(cbb_phong_ban.getSelectedIndex()==7) {
				phong="MAR";
			}
			boolean check=true;
			if(!(checkEmail(text_email.getText()))) check=false;

			// check sdt
			if(!(checkSdt(text_sdt.getText()))) check=false;
			long soCMND=0;

			// cmnd must be number
			try {
				soCMND= Long.parseLong(text_soCMND.getText());
			}
			catch(Exception ex ) {
				JOptionPane.showMessageDialog(null, "Số CMND/CCCD của bạn không hợp lệ!!!", "Lỗi CMND/CCCD", JOptionPane.ERROR_MESSAGE);
				check=false;
			}

			SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
			if(check) {

				try {

					String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
					Connection conn=DriverManager.getConnection(dbURL);

					String sua="UPDATE nhanvien "
							+ "SET hoten= N'"+text_ho_ten.getText()
							+ "',ngaysinh= '"+dateFormat.format(text_ngay_sinh.getDate())
							+ "',gioitinh=N'"+gioiTinh
							+ "',quequan=N'" +cbb_tinh.getItemAt(cbb_tinh.getSelectedIndex())
							+ "',sodienthoai='"+text_sdt.getText()
							+ "',email= '"+text_email.getText()
							+ "',ngayvaocongty='"+ dateFormat.format(text_ngay_vaocty.getDate())
							+ "',soCMND='"+text_soCMND.getText()
							+ "',noicap=N'"+cbb_noi_cap.getItemAt(cbb_noi_cap.getSelectedIndex())
							+ "',ngaycap='"+dateFormat.format(text_ngay_cap.getDate())
							+ "',dantoc=N'"+text_dan_toc.getText()
							+ "',linkanhcanhan=N'"+link
							+ "',bacluong='"+cbb_bac_luong.getItemAt(cbb_bac_luong.getSelectedIndex())
							+ "',machucvu='"+maChucVu
							+ "',maphong='"+phong
							+ "' where manv='"+ma.toUpperCase()+"'";
					PreparedStatement ps= conn.prepareStatement(sua);
					int a= ps.executeUpdate();
					if(a>0) {
						JOptionPane.showMessageDialog(null, "Thay đổi thông tin "+text_ho_ten.getText()+" thành công");
						clearForm();

					}





				}
				catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					System.out.println(ex.getMessage());

				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra kĩ lại thông tin",  "Thiếu thông tin", JOptionPane.ERROR_MESSAGE);
			
		}


	}

	//check email
	public boolean checkEmail(String s) {
		String a="^[\\w-]+@([\\w- ]+\\.)+[\\w-]+$";
		boolean b= s.matches(a);
		if(!(b)) {
			JOptionPane.showMessageDialog(null, "Email của bạn không hợp lệ!!!", "Lỗi email", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	public boolean checkSdt(String sdt) {
		String a="^\\d{10}$";
		boolean b= sdt.matches(a);
		if(!(b)) {
			JOptionPane.showMessageDialog(null, "Số điện thoại của bạn không hợp lệ!!!", "Lỗi số điện thoại", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	public String hienThi(String ma)  {
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			Connection conn=DriverManager.getConnection(dbURL);
			String hienthi="SELECT * FROM nhanvien where manv=?";
			PreparedStatement ps= conn.prepareStatement(hienthi);
			ps.setString(1,ma);

			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				text_ho_ten.setText(rs.getString("hoten"));

				if(rs.getString("gioitinh").trim().equalsIgnoreCase("Nam")) rdnam.setSelected(true);
				else rdnu.setSelected(true);	



				cbb_tinh.setSelectedItem(rs.getString("quequan"));

				text_dan_toc.setText(rs.getString("dantoc"));
				text_soCMND.setText(rs.getString("soCMND"));
				cbb_noi_cap.setSelectedItem(rs.getString("noicap"));

				text_sdt.setText(rs.getString("sodienthoai"));
				text_email.setText(rs.getString("email"));


				// lấy tên phòng
				if(rs.getString("maphong").trim().equals("KT")) {
					phong="Kế Toán";
				}
				if(rs.getString("maphong").trim().equals("HC")) {
					phong="Hành Chính";
				}
				else if(rs.getString("maphong").trim().equals("CSKH")) {
					phong="Chăm sóc khách hàng";
				}

				else if(rs.getString("maphong").trim().equals("NS")) {
					phong="Nhân sự";
				}
				else if(rs.getString("maphong").trim().equals("CNTT")) {
					phong="Công nghệ thông tin";
				}
				else if(rs.getString("maphong").trim().equals("QHQT")) {
					phong="Quan hệ quốc tế";
				}
				else if(rs.getString("maphong").trim().equals("MAR")) {
					phong="Marketing";
				}

				cbb_phong_ban.setSelectedItem(phong);
				// chức vụ
				String chucVu="";
				if(rs.getString("machucvu").trim().equals("NV")) {
					chucVu="Nhân Viên";
				}
				else if(rs.getString("machucvu").trim().equals("QL")) {
					chucVu="Quản Lý";
				}
				else if(rs.getString("machucvu").trim().equals("PGD")) {
					chucVu="Phó Giám Đốc";
				}
				else if(rs.getString("machucvu").trim().equals("GD")) {
					chucVu="Giám Đốc";
				}

				cbb_chuc_vu.setSelectedItem(chucVu);
				cbb_bac_luong.setSelectedItem(rs.getInt("bacluong"));
				cbb_bac_luong.setSelectedItem(rs.getString("bacluong"));
				lb_anh.setIcon(new ImageIcon(rs.getString("linkanhcanhan")));
				link = rs.getString("linkanhcanhan");
				hoten=rs.getString("hoten");
			}
		}
		catch(SQLException ex)  {
			System.out.println(ex.getMessage());
		} 
		return hoten;
	}
	void clearForm() {
		text_ma.setText("");
		text_ho_ten.setText(""); text_ngay_sinh.setDate(null);  
		text_sdt.setText(""); text_dan_toc.setText("");  
		text_email.setText("");  text_ngay_cap.setDate(null);
		text_soCMND.setText(""); 
		text_ngay_vaocty.setDate(null);
		buttonGroup.clearSelection();
		cbb_chuc_vu.setSelectedIndex(-1);
		cbb_tinh.setSelectedIndex(-1);
		cbb_noi_cap.setSelectedIndex(-1);
		cbb_phong_ban.setSelectedIndex(-1);
		cbb_bac_luong.setSelectedIndex(-1);
		lb_anh.setIcon(null);
		link=null;

	}
}

