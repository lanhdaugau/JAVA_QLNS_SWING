package ViewNhap;



import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


import Model.NhanVien;

//
//import Controller.NhanVien;
import View.View;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class ViewNhap extends JDialog implements ActionListener {
	// sửa 688
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


	private View view;
	JComboBox<String> cbb_chuc_vu; 
	JComboBox<Object> cbb_tinh ;
	private JPanel contentPane;
	private JDateChooser text_ngay_sinh;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField text_sdt;
	private JTextField text_dan_toc;
	private JTextField text_so_cmnd;
	private JDateChooser text_ngay_cap;
	private JTextField text_email;
	private JDateChooser text_ngay_vao;
	private JLabel lb_anh;
	private JRadioButton rdbt_nam;
	private JRadioButton rdbt_nu;
	private JComboBox<Object> cbb_noi_cap;
	private JComboBox<Object> cbb_phong_ban;
	private String link;
	private int []bacluong= {1,2,3,4,5,6,7,8};
	private JComboBox cbb_bac_luong;
	private JTextField text_hoten;
	private JTextField text_ma;
	private DefaultTableModel model;

	public ViewNhap(JFrame parent,boolean modal) {

		super(parent,modal);
		URL icon= ViewNhap.class.getResource("add.png");
		setIconImage(Toolkit.getDefaultToolkit().createImage(icon));

		view= (View) parent; // ép kiểu view mới tạo thành cái cha của ViewNhap
		// nếu mà v thì có thể tương tác trên cái cha của nó
		model= (DefaultTableModel) view.table.getModel();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 50, 1015, 642);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		try {
			lblNewLabel.setIcon(new ImageIcon(ImageIO.read(ViewNhap.class.getResourceAsStream("add.png") )));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel.setBounds(38, 11, 75, 74);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Điền thông tin nhân viên\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(149, 19, 360, 44);
		panel.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(-7, 104, 694, 4);
		panel.add(separator);

		JLabel lblNewLabel_2 = new JLabel("Họ và Tên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(38, 144, 68, 17);
		panel.add(lblNewLabel_2);
		// điền ngày sinh
		text_ngay_sinh = new JDateChooser();
		text_ngay_sinh.getCalendarButton().setForeground(Color.BLACK);
		text_ngay_sinh.setBounds(157, 246, 115, 20);
		panel.add(text_ngay_sinh);
		//		text_ngay_sinh.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Số Điện Thoại:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(25, 379, 96, 17);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Giới tính:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(38, 188, 68, 17);
		panel.add(lblNewLabel_2_2);
		// chọn giói tính nam
		rdbt_nam = new JRadioButton("Nam");
		buttonGroup.add(rdbt_nam);
		rdbt_nam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbt_nam.setBounds(159, 185, 75, 23);
		panel.add(rdbt_nam);
		// chọn giói tính nữ
		rdbt_nu = new JRadioButton("Nữ");
		buttonGroup.add(rdbt_nu);
		rdbt_nu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbt_nu.setBounds(236, 185, 68, 23);
		panel.add(rdbt_nu);

		JLabel lblNewLabel_3 = new JLabel("Quê quán:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(279, 246, 81, 17);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Ngày sinh:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(25, 246, 81, 17);
		panel.add(lblNewLabel_3_1);
		// điền sđt
		text_sdt = new JTextField();
		text_sdt.setBounds(157, 379, 105, 20);
		panel.add(text_sdt);
		text_sdt.setColumns(10);
		JLabel lblNewLabel_3_2 = new JLabel("Dân tộc:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(475, 246, 81, 17);
		panel.add(lblNewLabel_3_2);
		// điền tên dân tộc
		text_dan_toc = new JTextField();
		text_dan_toc.setBounds(581, 246, 115, 20);
		panel.add(text_dan_toc);
		text_dan_toc.setColumns(10);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(25, 216, 249, 4);
		panel.add(separator_1_1);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(25, 288, 249, 4);
		panel.add(separator_1_2);

		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(25, 353, 249, 4);
		panel.add(separator_1_3);
		// comboBox các tỉnh
		cbb_tinh = new JComboBox<Object>();
		cbb_tinh.setForeground(new Color(0, 0, 0));
		cbb_tinh.setBounds(361, 245, 96, 22);
		panel.add(cbb_tinh);



		JLabel lblNewLabel_4 = new JLabel("Số CMND/CCCD:\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(25, 309, 105, 14);
		panel.add(lblNewLabel_4);
		// điền số CMND
		text_so_cmnd = new JTextField();
		text_so_cmnd.setBounds(157, 303, 105, 20);
		panel.add(text_so_cmnd);
		text_so_cmnd.setColumns(10);

		JLabel lblNewLabel_3_1_1 = new JLabel("Nơi Cấp:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(279, 308, 81, 17);
		panel.add(lblNewLabel_3_1_1);
		// comboBox nơi cấp
		cbb_noi_cap = new JComboBox<Object>();
		cbb_noi_cap.setBounds(361, 307, 96, 22);
		panel.add(cbb_noi_cap);

		JLabel lblNewLabel_3_1_2 = new JLabel("Ngày Cấp:");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2.setBounds(475, 312, 81, 17);
		panel.add(lblNewLabel_3_1_2);
		// điền ngày cấp
		text_ngay_cap = new JDateChooser();
		//		text_ngay_cap.setColumns(10);
		text_ngay_cap.setBounds(581, 308, 115, 20);
		panel.add(text_ngay_cap);



		JLabel lblNewLabel_3_1_1_1 = new JLabel("Email:");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(279, 379, 81, 17);
		panel.add(lblNewLabel_3_1_1_1);
		// điền email
		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(361, 379, 105, 20);
		panel.add(text_email);

		JLabel lblNewLabel_3_1_2_1 = new JLabel("Ngày vào cty:");
		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1.setBounds(475, 379, 96, 17);
		panel.add(lblNewLabel_3_1_2_1);
		// điền ngày bắt đầu làm việc
		text_ngay_vao = new JDateChooser();
		//		text_ngay_vao.setColumns(10);
		text_ngay_vao.setBounds(581, 379, 115, 20);
		panel.add(text_ngay_vao);

		JLabel lblNewLabel_2_1_1 = new JLabel("Xưởng/phòng ban:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(25, 441, 129, 17);
		panel.add(lblNewLabel_2_1_1);
		// comboBox phòng ban
		cbb_phong_ban = new JComboBox<Object>();
		cbb_phong_ban.setBounds(157, 440, 115, 22);
		panel.add(cbb_phong_ban);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1_1.setBounds(279, 444, 81, 17);
		panel.add(lblNewLabel_3_1_1_1_1);
		// comboBox chức vụ
		cbb_chuc_vu = new JComboBox<String>();
		cbb_chuc_vu.setBounds(359, 440, 105, 22);
		panel.add(cbb_chuc_vu);
		// đưa form nhập về null
		JButton btnNhpLi = new JButton("Nhập lại");
		try {
			btnNhpLi.setIcon(new ImageIcon(ImageIO.read(ViewNhap.class.getResourceAsStream("reload_con.png")) ));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		btnNhpLi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhpLi.setBounds(624, 531, 115, 33);
		panel.add(btnNhpLi);
		btnNhpLi.addActionListener(this);
		// exit 
		JButton btnThot = new JButton("Thoát");

		try {
			btnThot.setIcon(new ImageIcon(ImageIO.read(ViewNhap.class.getResourceAsStream("out.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThot.setBounds(805, 531, 105, 33);
		panel.add(btnThot);
		btnThot.addActionListener(this);


		JLabel lblNewLabel_3_3 = new JLabel("Ảnh thẻ  3×4 ");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(824, 119, 96, 17);
		panel.add(lblNewLabel_3_3);
		// tạo khung dễ phân biệt
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(805, 188, 134, 156);
		panel.add(panel_1);
		panel_1.setLayout(null);
		// chứa ảnh cá nhân
		lb_anh = new JLabel("");
		lb_anh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_anh.setBounds(10, 11, 114, 134);
		panel_1.add(lb_anh);
		// sử dụng jfilechooser để set jlabel ảnh nhận ảnh cá nhân
		JButton bt_chon_anh = new JButton("Chọn ảnh");
		bt_chon_anh.addActionListener(new ActionListener() {
			private JFileChooser chooser;
			private File file;

			public void actionPerformed(ActionEvent e) {
				chooser= new JFileChooser();
				int option = chooser.showOpenDialog(ViewNhap.this);
				if(option==JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();

					String fileName= file.getName();


					if(fileName.endsWith(".png")|| fileName.endsWith(".jpg")) {
						// label theo phương pháp lấy đường dẫn tuyệt đối
						//						ImageIcon a= new ImageIcon(file.getAbsolutePath());
						lb_anh.setIcon(new ImageIcon(file.getAbsolutePath()));
						link=file.getAbsolutePath();


					}
				}
			}
		});
		bt_chon_anh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_chon_anh.setBounds(817, 376, 103, 23);
		panel.add(bt_chon_anh);
		// tạo button lưu lại để dán vào JTable của bảng View
		JButton bt_luu = new JButton("Lưu lại");
		bt_luu.addActionListener(this);



		try {
			bt_luu.setIcon(new ImageIcon(ImageIO.read(ViewNhap.class.getResourceAsStream("save_icon.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bt_luu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_luu.setBounds(431, 531, 115, 33);

		panel.add(bt_luu);
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

		cbb_bac_luong = new JComboBox();
		cbb_bac_luong.setBounds(581, 440, 106, 22);
		panel.add(cbb_bac_luong);

		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("Bậc lương:");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_2_1_1.setBounds(475, 441, 96, 17);
		panel.add(lblNewLabel_3_1_2_1_1);
		cbb_bac_luong.addItem("");

		text_hoten = new JTextField();
		text_hoten.setBounds(127, 144, 300, 20);
		panel.add(text_hoten);

		JLabel lblNewLabel_2_2_1 = new JLabel("Mã Nhân Sự     :");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(456, 144, 115, 17);
		panel.add(lblNewLabel_2_2_1);

		text_ma = new JTextField();
		text_ma.setToolTipText("Ví dụ: NV1,NV2....");
		text_ma.setColumns(10);
		text_ma.setBounds(562, 144, 115, 20);
		panel.add(text_ma);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("*");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setForeground(Color.RED);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3_1.setBounds(529, 144, 17, 17);
		panel.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_5 = new JLabel("(Điền đầy đủ và chính xác thông tin của nhân sự)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel_5.setBounds(201, 85, 300, 14);
		panel.add(lblNewLabel_5);


		for(int i=0;i<bacluong.length;i++) {
			cbb_bac_luong.addItem(bacluong[i]);
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

	//save inf
	void luuThongTin() {

		String maNV="";
		String hoTen="";
		Object ngaySinh="";
		String gioiTinh="";
		Object queQuan="";
		String soDienThoai="";
		String email="";
		Object ngayVaoCty="";
		String maChucVu="";
		long soCMND=0;
		Object noiCap="";
		Object ngayCap="";
		String danToc="";
		int bacLuong=0;
		String phong="";
		String duongDanAnhCaNhan="";
		if(rdbt_nam.isSelected()) gioiTinh="Nam";
		else if(rdbt_nu.isSelected()) gioiTinh="Nữ";
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
		if(text_hoten.getText() !=null && text_ngay_sinh.getDate() !=null &&
				text_sdt.getText() !=null && 
				text_dan_toc.getText() !=null && text_email.getText() !=null &&
				text_ngay_cap.getDate()!=null && text_so_cmnd.getText() !=null && gioiTinh!=""
				&& cbb_noi_cap.getSelectedIndex()!=0 && cbb_phong_ban.getSelectedIndex()!=0 && 
				cbb_tinh.getSelectedIndex()!=0 && text_ma.getText()!=null
				&& cbb_bac_luong.getSelectedIndex()!=0 ) {

			//mã chức vụ
			if(cbb_chuc_vu.getSelectedIndex()==1) {
				maChucVu="NV";
			}
			if(cbb_chuc_vu.getSelectedIndex()==2) {
				maChucVu="QL";
			}
			if(cbb_chuc_vu.getSelectedIndex()==3) {
				maChucVu="PGD";
			}
			if(cbb_chuc_vu.getSelectedIndex()==4) {
				maChucVu="GD";
			}



			boolean check=true;
			//mã nv
			maNV=text_ma.getText();
			//checkEmail
			if(!(checkEmail(text_email.getText()))) check=false;
			else email=text_email.getText();
			// check sdt
			if(!(checkSdt(text_sdt.getText()))) check=false;
			else soDienThoai= text_sdt.getText();
			// tên
			hoTen=text_hoten.getText();
			// ngày sinh
			ngaySinh= dateFormat.format(text_ngay_sinh.getDate());
			//quê quán
			queQuan =(String) cbb_tinh.getItemAt(cbb_tinh.getSelectedIndex());

			// ngày vào cty
			ngayVaoCty= dateFormat.format(text_ngay_vao.getDate());
			// cmnd must be number
			try {
				soCMND= Long.parseLong(text_so_cmnd.getText());
			}
			catch(Exception ex ) {
				JOptionPane.showMessageDialog(null, "Số CMND/CCCD của bạn không hợp lệ!!!", "Lỗi CMND/CCCD", JOptionPane.ERROR_MESSAGE);
				check=false;
			}
			// nơi cấp
			noiCap=cbb_noi_cap.getItemAt(cbb_noi_cap.getSelectedIndex());
			//ngày cấp
			ngayCap=dateFormat.format(text_ngay_cap.getDate());
			//dân tộc
			danToc=text_dan_toc.getText();
			//bậc lương
			bacLuong=(int) cbb_bac_luong.getItemAt(cbb_bac_luong.getSelectedIndex());

			// đường dẫn avt
			duongDanAnhCaNhan=link;
			if(duongDanAnhCaNhan==null) {
				JOptionPane.showMessageDialog(null, "Thiếu ảnh cá nhân của nhân sự.");
				check=false;
			}
			//mã phòng
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

			// condition true --> create empl
			if(check) {

				NhanVien nv= new NhanVien(maNV, hoTen, ngaySinh, gioiTinh, (String) queQuan, soDienThoai, email, ngayVaoCty, soCMND, (String) noiCap, ngayCap,danToc, bacLuong, phong, duongDanAnhCaNhan,maChucVu);
				if(themNhanVienSQL(nv)) {JOptionPane.showMessageDialog(null,"Thêm thông tin nhân sự "+nv.getHoTen()+" thành công");;

				model.setRowCount(0);
				view.showUser();
				clearForm();
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Bạn nhập thiếu thông tin vui lòng kiểm tra lại!!!","Lỗi điền thông tin", JOptionPane.ERROR_MESSAGE);
		}
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String ac= e.getActionCommand();
		// Lưu lại
		if(ac=="Lưu lại") {
			luuThongTin();
		}
		else if(ac=="Nhập lại") {
			clearForm();
		}
		else if( ac=="Thoát") {
			

				int rec = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát không? "
						, "Lưu ý",JOptionPane.YES_NO_OPTION);
				if(rec==JOptionPane.YES_OPTION) {

					dispose();
				}
				
			

			
			
			
		}


	}



	void clearForm() {
		text_ma.setText("");
		text_hoten.setText(""); text_ngay_sinh.setDate(null);  
		text_sdt.setText(""); text_dan_toc.setText("");  
		text_email.setText("");  text_ngay_cap.setDate(null);
		text_so_cmnd.setText(""); 
		text_ngay_vao.setDate(null);
		buttonGroup.clearSelection();
		cbb_chuc_vu.setSelectedIndex(-1);
		cbb_tinh.setSelectedIndex(-1);
		cbb_noi_cap.setSelectedIndex(-1);
		cbb_phong_ban.setSelectedIndex(-1);
		cbb_bac_luong.setSelectedIndex(-1);
		lb_anh.setIcon(null);
		link=null;

	}
	public boolean themNhanVienSQL(NhanVien nv) {


		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			Connection conn=DriverManager.getConnection(dbURL);
			String them="insert into nhanvien(manv,hoten,ngaysinh,gioitinh,quequan,sodienthoai,email,ngayvaocongty,soCMND,noicap,ngaycap,dantoc,linkanhcanhan,bacluong,machucvu,maphong)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(them);
			ps.setString(1,nv.getMaNV().toUpperCase());
			ps.setString(2,nv.getHoTen());
			ps.setString(3,(String) nv.getNgaySinh());
			ps.setString(4,nv.getGioiTinh());
			ps.setString(5,nv.getQueQuan());
			ps.setString(6,nv.getSoDienThoai());
			ps.setString(7,nv.getEmail());
			ps.setString(8,(String) nv.getNgayVaoCty());
			ps.setLong(9,nv.getSoCMND());
			ps.setString(10,nv.getNoiCap());
			ps.setString(11,(String) nv.getNgayCap());
			ps.setString(12,nv.getDanToc());
			ps.setString(13,nv.getDuongDanAnhCaNhan());
			ps.setInt(14,nv.getBacLuong());
			ps.setString(15,nv.getMaChucVu());
			ps.setString(16,nv.getPhong());
			return ps.executeUpdate()>0;



		}
		catch (Exception e){


			if(e.getMessage().startsWith("Violation of PRIMARY KEY constraint 'PK_nhanvien'")) {
				JOptionPane.showMessageDialog(null, "Mã nhân sự này đã tồn tại vui lòng điền mã khác");
				text_ma.setText(null);
			}
		}
		return false;



	}
}




