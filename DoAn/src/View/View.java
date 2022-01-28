package View;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;


import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;


import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Model.NhanVien;

import ViewNhap.ViewNhap;
import ViewSua.ViewSua;
import ViewXoa.ViewXoa;
import java.awt.Toolkit;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class View extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public JTable table;
	private JScrollPane scrollPane;
	
	List <NhanVien> arrayList = new ArrayList<>();

	private JTextField text_show_hoten;
	private JTextField text_show_cmnd;
	private JTextField text_show_ngay_cap;
	private JTextField text_show_noi_cap;
	private JTextField text_show_chuc_vu;
	private JTextField text_show_phong;
	private Connection conn;
	String ma,hoten,gioitinh,quequan,sodienthoai,chucvu,email,phong,linkanhcanhan;
	private JTextField text_timkiem;
	private JLabel lb_show_anh;
	private int tongSoNhanSu;
	private double nsKT,nsHC,nsCSKH,nsCNTT,nsNS,nsQHQT,nsMAR;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public View() throws IOException {
		URL icon =View.class.getResource("file-info-icon.png");	
		setIconImage(Toolkit.getDefaultToolkit().createImage(icon));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1372,730);
		setLocationRelativeTo(null);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Thông kê số nhân sự các phòng");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewThongKe().setVisible(true);
			}
		});

		JMenu mnNewMenu_1 = new JMenu("Biễu diễn nhân sự ở các phòng dưới dạng đồ hoạ\r\n");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Biểu đồ cột");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongKe();
				DefaultCategoryDataset dcd= new DefaultCategoryDataset();
				dcd.setValue(nsKT, "Bộ phận tài chính", "Kế Toán");
				dcd.setValue(nsCSKH, "Bộ phận điều hành", "Chăm sóc khách hàng");
				dcd.setValue(nsHC, "Bộ phận tài chính", "Hành chính");
				dcd.setValue(nsCNTT, "Bộ phận điều hành", "Công nghệ thông tin");
				dcd.setValue(nsNS, "Bộ phận tài chính", "Nhân sự");
				dcd.setValue(nsQHQT, "Bộ phận điều hành", "Quan hệ quốc tế");
				dcd.setValue(nsMAR, "Bộ phận tài chính", "Marketing");
				JFreeChart jchart= ChartFactory.createBarChart3D("Biểu đồ biểu diễn số lương nhân sự ở các phòng theo từng bộ phận".toUpperCase(),"Tên các phòng", "Số phần trăm chiếm trong tổng số nhân sự", dcd, PlotOrientation.VERTICAL, true, true,true);
				//				CategoryPlot plot =jchart.getCategoryPlot();
				//				plot.setRangeGridlinePaint(Color.black);

				JFrame chartFrame= new ChartFrame("Biểu đồ cột", jchart,true);

				chartFrame.setIconImage(Toolkit.getDefaultToolkit().createImage(View.class.getResource("chart-icon.png")));
				chartFrame.setVisible(true);
				chartFrame.setSize(1372,730);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Biểu đồ tròn\r\n");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongKe();
				DefaultPieDataset dcd = new DefaultPieDataset();
				dcd.setValue("Kế toán",(nsKT*100)/tongSoNhanSu);
				dcd.setValue("Hành chính",(nsHC*100)/tongSoNhanSu);
				dcd.setValue("Chăm sóc khách hàng",(nsCSKH*100)/tongSoNhanSu);
				dcd.setValue("Nhân sự",(nsNS*100)/tongSoNhanSu);
				dcd.setValue("Công nghệ thông tin",(nsCNTT*100)/tongSoNhanSu);
				dcd.setValue("Quan hệ quốc tế",(nsQHQT*100)/tongSoNhanSu);
				dcd.setValue("Marketing",(nsMAR*100)/tongSoNhanSu);
				JFreeChart chart= ChartFactory.createPieChart3D("Biểu đồ biểu diễn số lương nhân sự ở các phòng ".toUpperCase(),dcd, true,true, true);
				ChartPanel chartPanel = new ChartPanel(chart);
				JFrame frame = new JFrame("Biểu đồ tròn");
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage(View.class.getResource("chart-icon.png")));
				frame.getContentPane().add(chartPanel);
				frame.setSize(600, 400);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setVisible(true);

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		mnNewMenu.add(mntmNewMenuItem);

		JSeparator separator_1_1 = new JSeparator();
		mnNewMenu.add(separator_1_1);

		JMenu mnNewMenu_3 = new JMenu("Mức lương");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Tính lương của nhân sự");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTinhLuong().setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);

		JSeparator separator_1_2 = new JSeparator();
		mnNewMenu_3.add(separator_1_2);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Hiện thị ra lương của toàn bộ nhân sự");
		mnNewMenu_3.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_4 = new JMenu("Trợ giúp");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Thông báo gần đây");
		mnNewMenu_4.add(mntmNewMenuItem_9);

		JSeparator separator_1_3 = new JSeparator();
		mnNewMenu_4.add(separator_1_3);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Thông tin của công ty");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewThongBao().setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_10);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 348, 92);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton bt_them = new JButton("Thêm");
		bt_them.setFont(new Font("Tahoma", Font.BOLD, 12));
		bt_them.setHorizontalAlignment(SwingConstants.LEFT);

		bt_them.setIcon( new ImageIcon(ImageIO.read( View.class.getResourceAsStream( "add_icon1.png" ) )) );	

		bt_them.setBounds(10, 11, 102, 70);
		panel_1.add(bt_them);

		JButton bt_xoa = new JButton("Xoá");
		bt_xoa.setFont(new Font("Tahoma", Font.BOLD, 12));

		bt_xoa.setIcon(new ImageIcon(ImageIO.read( View.class.getResourceAsStream("deleteicon.png"))));
		bt_xoa.setBounds(238, 11, 100, 70);
		panel_1.add(bt_xoa);

		JButton bt_sua = new JButton("Sửa");
		bt_sua.setFont(new Font("Tahoma", Font.BOLD, 12));
		bt_sua.setIcon(new ImageIcon(ImageIO.read(View.class.getResourceAsStream("update.png") )));
		bt_sua.setBounds(122, 11, 106, 70);
		panel_1.add(bt_sua);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 114, 934, 2);
		getContentPane().add(separator);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 127, 248, 531);
		panel_2.setBackground(new Color(192, 192, 192));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 65, 81, 14);
		panel_2.add(lblNewLabel_3);

		text_timkiem = new JTextField();
		text_timkiem.setForeground(new Color(255, 0, 0));
		text_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_timkiem.setBounds(47, 118, 178, 29);
		panel_2.add(text_timkiem);
		text_timkiem.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("(Tìm kiếm theo mã)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(82, 151, 117, 14);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ImageIO.read(View.class.getResourceAsStream("search-icon.png"))));
		lblNewLabel_5.setBounds(10, 118, 30, 35);
		panel_2.add(lblNewLabel_5);

		JButton btnNewButton_2 = new JButton("Xác nhận");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				showThongTin(); 
				if(hoten!=null) {
					new ShowThongTin(View.this).setVisible(true);
					setNullData();
				}
				else {
					JOptionPane.showMessageDialog(null, "Mã nhân sự không tồn tại");
				}



			}
		});
		btnNewButton_2.setForeground(new Color(0, 128, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(74, 194, 117, 23);
		panel_2.add(btnNewButton_2);

		JLabel lblNewLabel_6 = new JLabel("Khác:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 240, 46, 14);
		panel_2.add(lblNewLabel_6);

		JButton bt_hien_thi_toan_bo = new JButton("Hiển thị toàn bộ nhân viên");
		bt_hien_thi_toan_bo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showAllNhanVien();
			}
		});
		bt_hien_thi_toan_bo.setBounds(26, 286, 199, 23);
		panel_2.add(bt_hien_thi_toan_bo);

		JButton bt_hien_thi_ql = new JButton("Hiển thị toàn bộ quản lí");
		bt_hien_thi_ql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showAllQuanLy();
			}
		});
		bt_hien_thi_ql.setBounds(26, 341, 199, 23);
		panel_2.add(bt_hien_thi_ql);

		JButton bt_hien_thi_pgd = new JButton("Hiện thị phó giám đốc");
		bt_hien_thi_pgd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showAllPhoGiamDoc();
			}
		});
		bt_hien_thi_pgd.setBounds(26, 400, 199, 23);
		panel_2.add(bt_hien_thi_pgd);

		JButton bt_hien_thi_pgd_1 = new JButton("Hiển thị toàn bộ nhân sự");
		bt_hien_thi_pgd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				showUser();
			}
		});
		bt_hien_thi_pgd_1.setBounds(26, 465, 199, 23);
		panel_2.add(bt_hien_thi_pgd_1);
		JScrollPane jcp= new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jcp.setBounds(0, 0, 0, 0);
		getContentPane().add(jcp);
		getContentPane().add(jcp);
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1032, 127, 328, 531);
		panel_3.setBackground(new Color(192, 192, 192));
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Họ tên:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(35, 216, 58, 14);
		panel_3.add(lblNewLabel_7);

		text_show_hoten = new JTextField();
		text_show_hoten.setHorizontalAlignment(SwingConstants.CENTER);
		text_show_hoten.setEditable(false);
		text_show_hoten.setBounds(91, 214, 193, 20);
		panel_3.add(text_show_hoten);
		text_show_hoten.setColumns(10);

		JLabel lblNewLabel_7_1_1 = new JLabel("Số CMND/CCCD:\r\n");
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1_1.setBounds(21, 278, 106, 14);
		panel_3.add(lblNewLabel_7_1_1);

		JLabel lblNewLabel_7_1_2 = new JLabel("Ngày cấp:");
		lblNewLabel_7_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1_2.setBounds(35, 331, 58, 14);
		panel_3.add(lblNewLabel_7_1_2);

		text_show_cmnd = new JTextField();
		text_show_cmnd.setHorizontalAlignment(SwingConstants.CENTER);
		text_show_cmnd.setEditable(false);
		text_show_cmnd.setColumns(10);
		text_show_cmnd.setBounds(125, 276, 122, 20);
		panel_3.add(text_show_cmnd);

		JLabel lblNewLabel_7_1_2_1 = new JLabel("Nơi cấp:");
		lblNewLabel_7_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1_2_1.setBounds(35, 379, 58, 14);
		panel_3.add(lblNewLabel_7_1_2_1);

		text_show_ngay_cap = new JTextField();
		text_show_ngay_cap.setHorizontalAlignment(SwingConstants.CENTER);
		text_show_ngay_cap.setEditable(false);
		text_show_ngay_cap.setColumns(10);
		text_show_ngay_cap.setBounds(125, 329, 122, 20);
		panel_3.add(text_show_ngay_cap);

		text_show_noi_cap = new JTextField();
		text_show_noi_cap.setHorizontalAlignment(SwingConstants.CENTER);
		text_show_noi_cap.setEditable(false);
		text_show_noi_cap.setColumns(10);
		text_show_noi_cap.setBounds(125, 377, 122, 20);
		panel_3.add(text_show_noi_cap);

		JLabel lblNewLabel_7_1_2_1_1 = new JLabel("Mã chức vụ:");
		lblNewLabel_7_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1_2_1_1.setBounds(28, 428, 80, 20);
		panel_3.add(lblNewLabel_7_1_2_1_1);

		text_show_chuc_vu = new JTextField();
		text_show_chuc_vu.setHorizontalAlignment(SwingConstants.CENTER);
		text_show_chuc_vu.setEditable(false);
		text_show_chuc_vu.setColumns(10);
		text_show_chuc_vu.setBounds(125, 429, 122, 20);
		panel_3.add(text_show_chuc_vu);

		JLabel lblNewLabel_7_1_2_1_1_1 = new JLabel("Mã phòng ban:");
		lblNewLabel_7_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7_1_2_1_1_1.setBounds(21, 480, 87, 14);
		panel_3.add(lblNewLabel_7_1_2_1_1_1);

		text_show_phong = new JTextField();
		text_show_phong.setHorizontalAlignment(SwingConstants.CENTER);
		text_show_phong.setEditable(false);
		text_show_phong.setColumns(10);
		text_show_phong.setBounds(125, 478, 122, 20);
		panel_3.add(text_show_phong);

		JPanel panel = new JPanel();
		panel.setBounds(114, 49, 133, 154);
		panel_3.add(panel);
		panel.setLayout(null);

		lb_show_anh = new JLabel("");
		lb_show_anh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_show_anh.setBounds(10, 11, 114, 134);
		panel.add(lb_show_anh);

		JButton btnNewButton = new JButton("Xem thêm");
		btnNewButton.setToolTipText("chọn hàng nhân sự cần xem thêm thông tin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xemThongTin();
			}
		});
		btnNewButton.setBounds(125, 15, 112, 23);
		panel_3.add(btnNewButton);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"M\u00E3", "H\u1ECD T\u00EAn", "Ng\u00E0y Sinh", "Gi\u1EDBi Tính", "Qu\u00EA Qu\u00E1n", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email", "Ng\u00E0y v\u00E0o cty"
				}
				));

		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.setBounds(0, 0, 1, 1);


		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(278, 127, 747, 531);
		getContentPane().add(scrollPane);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(1227, 11, 119, 100);
		lblNewLabel.setIcon(new ImageIcon(View.class.getResource("a.png")));
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Quản Lý Nhân Sự 🏢🏢🏢");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel_1.setBounds(431, 11, 503, 61);
		getContentPane().add(lblNewLabel_1);

//		DefaultTableModel tblModel =  (DefaultTableModel) table.getModel();


		// thêm sự kiện cho button
		bt_them.addActionListener(this);
		bt_sua.addActionListener(this);
		bt_xoa.addActionListener(this);		
		showUser();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action= e.getActionCommand();
		// mở thêm
		if(action=="Thêm") {
			ViewNhap nhap = new ViewNhap(this, rootPaneCheckingEnabled);
			nhap.setVisible(true);
		}
		// mở sửa
		else if(action=="Sửa") {
			ViewSua sua= new ViewSua(this, rootPaneCheckingEnabled);
			sua.setVisible(true);
		}
		else if (action== "Xoá") {
			ViewXoa xoa= new ViewXoa(this, rootPaneCheckingEnabled);
			xoa.setVisible(true);
		}

	}

	// show all
	public ArrayList<NhanVien> getList(){
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT * FROM nhanvien";

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			conn=DriverManager.getConnection(dbURL);

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				NhanVien s = new NhanVien();
				s.setMaNV(rs.getString("manv"));
				s.setHoTen(rs.getString("hoten"));
				s.setNgaySinh(rs.getString("ngaysinh"));
				s.setGioiTinh(rs.getString("gioitinh"));
				s.setQueQuan(rs.getString("quequan"));
				s.setSoDienThoai(rs.getString("sodienthoai"));
				s.setEmail(rs.getString("email"));
				s.setNgayVaoCty(rs.getString("ngayvaocongty"));

				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public void showUser(){
		ArrayList <NhanVien> list= getList();
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		Object []row= new Object[8];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getMaNV();
			row[1]=list.get(i).getHoTen();
			row[2]=list.get(i).getNgaySinh();
			row[3]=list.get(i).getGioiTinh();
			row[4]=list.get(i).getQueQuan();
			row[5]=list.get(i).getSoDienThoai();
			row[6]=list.get(i).getEmail();
			row[7]=list.get(i).getNgayVaoCty();

			model.addRow(row);
		}


	}	
	// show nhanvien
	public ArrayList<NhanVien> getListNhanVien(){
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT * FROM nhanvien where machucvu='NV'";

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			conn=DriverManager.getConnection(dbURL);

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				NhanVien s = new NhanVien();
				s.setMaNV(rs.getString("manv"));
				s.setHoTen(rs.getString("hoten"));
				s.setNgaySinh(rs.getString("ngaysinh"));
				s.setGioiTinh(rs.getString("gioitinh"));
				s.setQueQuan(rs.getString("quequan"));
				s.setSoDienThoai(rs.getString("sodienthoai"));
				s.setEmail(rs.getString("email"));
				s.setNgayVaoCty(rs.getString("ngayvaocongty"));

				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public void showAllNhanVien(){
		ArrayList <NhanVien> list= getListNhanVien();
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		Object []row= new Object[8];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getMaNV();
			row[1]=list.get(i).getHoTen();
			row[2]=list.get(i).getNgaySinh();
			row[3]=list.get(i).getGioiTinh();
			row[4]=list.get(i).getQueQuan();
			row[5]=list.get(i).getSoDienThoai();
			row[6]=list.get(i).getEmail();
			row[7]=list.get(i).getNgayVaoCty();

			model.addRow(row);
		}


	}	
	//show quản lý
	public ArrayList<NhanVien> getListQuanLy(){
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT * FROM nhanvien where machucvu='QL'";

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			conn=DriverManager.getConnection(dbURL);

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				NhanVien s = new NhanVien();
				s.setMaNV(rs.getString("manv"));
				s.setHoTen(rs.getString("hoten"));
				s.setNgaySinh(rs.getString("ngaysinh"));
				s.setGioiTinh(rs.getString("gioitinh"));
				s.setQueQuan(rs.getString("quequan"));
				s.setSoDienThoai(rs.getString("sodienthoai"));
				s.setEmail(rs.getString("email"));
				s.setNgayVaoCty(rs.getString("ngayvaocongty"));

				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public void showAllQuanLy(){
		ArrayList <NhanVien> list= getListQuanLy();
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		Object []row= new Object[8];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getMaNV();
			row[1]=list.get(i).getHoTen();
			row[2]=list.get(i).getNgaySinh();
			row[3]=list.get(i).getGioiTinh();
			row[4]=list.get(i).getQueQuan();
			row[5]=list.get(i).getSoDienThoai();
			row[6]=list.get(i).getEmail();
			row[7]=list.get(i).getNgayVaoCty();

			model.addRow(row);
		}


	}
	// show phó giám đốc
	public ArrayList<NhanVien> getListPhoGiamDoc(){
		ArrayList<NhanVien> list = new ArrayList<>();
		String sql = "SELECT * FROM nhanvien where machucvu='PGD'";

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			conn=DriverManager.getConnection(dbURL);

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				NhanVien s = new NhanVien();
				s.setMaNV(rs.getString("manv"));
				s.setHoTen(rs.getString("hoten"));
				s.setNgaySinh(rs.getString("ngaysinh"));
				s.setGioiTinh(rs.getString("gioitinh"));
				s.setQueQuan(rs.getString("quequan"));
				s.setSoDienThoai(rs.getString("sodienthoai"));
				s.setEmail(rs.getString("email"));
				s.setNgayVaoCty(rs.getString("ngayvaocongty"));

				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public void showAllPhoGiamDoc(){
		ArrayList <NhanVien> list=  getListPhoGiamDoc();
		DefaultTableModel model= (DefaultTableModel) table.getModel();
		Object []row= new Object[8];
		for(int i=0;i<list.size();i++) {
			row[0]=list.get(i).getMaNV();
			row[1]=list.get(i).getHoTen();
			row[2]=list.get(i).getNgaySinh();
			row[3]=list.get(i).getGioiTinh();
			row[4]=list.get(i).getQueQuan();
			row[5]=list.get(i).getSoDienThoai();
			row[6]=list.get(i).getEmail();
			row[7]=list.get(i).getNgayVaoCty();

			model.addRow(row);
		}


	}

	public void showThongTin() {




		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			conn=DriverManager.getConnection(dbURL);
			String timkiem= "select * from nhanvien where manv=? ";
			PreparedStatement ps=conn.prepareStatement(timkiem);
			ps.setString(1, text_timkiem.getText());

			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				hoten=rs.getString("hoten");
				ma=text_timkiem.getText().toUpperCase();
				gioitinh=rs.getString("gioitinh");
				quequan=rs.getString("quequan");
				sodienthoai=rs.getString("sodienthoai");
				email=rs.getString("email");
				chucvu=rs.getString("machucvu");
				phong=rs.getString("maphong");
				linkanhcanhan=rs.getString("linkanhcanhan");
			}

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}


	}

	public void xemThongTin() {
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			conn=DriverManager.getConnection(dbURL);
			int row= table.getSelectedRow();

			String value=table.getModel().getValueAt(row, 0).toString();
			String sql="SELECT * FROM nhanvien where manv="+"'"+value+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				text_show_hoten.setText(rs.getString("hoten"));

				text_show_chuc_vu.setText(rs.getString("machucvu"));
				text_show_cmnd.setText(rs.getString("soCMND"));
				text_show_ngay_cap.setText(rs.getString("ngaycap"));
				text_show_noi_cap.setText(rs.getString("noicap"));
				text_show_phong.setText(rs.getString("maphong"));
				lb_show_anh.setIcon(new ImageIcon(rs.getString("linkanhcanhan")));
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
	void setNullData() {
		ma=null;hoten=null;
		gioitinh=null;quequan=null;sodienthoai=null;chucvu=null;email=null;
		phong=null;linkanhcanhan=null;ma=null;hoten=null;gioitinh=null;quequan=null;
		sodienthoai=null;chucvu=null;email=null;phong=null;linkanhcanhan=null;

	}
	void thongKe() {
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			Connection conn=DriverManager.getConnection(dbURL);
			String soNhanVien="select count(manv) as soluong from nhanvien ";
			PreparedStatement ps8=conn.prepareStatement(soNhanVien);
			ResultSet rs8= ps8.executeQuery();
			while(rs8.next()) {
				tongSoNhanSu=rs8.getInt("soluong");
			}
			String query1="select count(manv) as soluong from nhanvien where maphong='KT'";
			PreparedStatement ps1=conn.prepareStatement(query1);
			ResultSet rs1= ps1.executeQuery();
			while(rs1.next()) {
				nsKT=(rs1.getDouble("soluong")*100)/tongSoNhanSu;
			}
			String query2="select count(manv) as soluong from nhanvien where maphong='HC'";
			PreparedStatement ps2=conn.prepareStatement(query2);
			ResultSet rs2= ps2.executeQuery();
			while(rs2.next()) {
				nsHC=(rs2.getDouble("soluong")*100)/tongSoNhanSu;
			}
			String query3="select count(manv) as soluong from nhanvien where maphong='CSKH'";
			PreparedStatement ps3=conn.prepareStatement(query3);
			ResultSet rs3= ps3.executeQuery();
			while(rs3.next()) {
				nsCSKH=(rs3.getDouble("soluong")*100)/tongSoNhanSu;
			}
			String query4="select count(manv) as soluong from nhanvien where maphong='NS'";
			PreparedStatement ps4=conn.prepareStatement(query4);
			ResultSet rs4= ps4.executeQuery();
			while(rs4.next()) {
				nsNS=(rs4.getDouble("soluong")*100)/tongSoNhanSu;
			}
			String query5="select count(manv) as soluong from nhanvien where maphong='CNTT'";
			PreparedStatement ps5=conn.prepareStatement(query5);
			ResultSet rs5= ps5.executeQuery();
			while(rs5.next()) {
				nsCNTT=(rs5.getDouble("soluong")*100)/tongSoNhanSu;
			}String query6="select count(manv) as soluong from nhanvien where maphong='QHQT'";
			PreparedStatement ps6=conn.prepareStatement(query6);
			ResultSet rs6= ps6.executeQuery();
			while(rs6.next()) {
				nsQHQT=(rs6.getDouble("soluong")*100)/tongSoNhanSu;
			}
			String query7="select count(manv) as soluong from nhanvien where maphong='MAR'";
			PreparedStatement ps7=conn.prepareStatement(query7);
			ResultSet rs7= ps7.executeQuery();
			while(rs7.next()) {
				nsMAR=(rs7.getDouble("soluong")*100)/tongSoNhanSu;
			}


		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

