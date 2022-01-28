package View;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;

public class ViewThongKe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lb_ns;
	private JLabel lb_cntt;
	private JLabel lb_mar;
	private JLabel lb_qhqt;
	private JLabel lb_cskh;
	private JLabel lb_hc;
	private JLabel lb_kt;
	private JLabel lb_nhanvien;
	private JLabel lb_quanly;
	private JLabel lb_phogiamdoc;

	
	public ViewThongKe() {
		setTitle("Thống kê số lượng nhân sự");
		setBounds(100, 100, 699, 520);
		setIconImage(Toolkit.getDefaultToolkit().createImage(View.class.getResource("info-icon.png")));
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
			JLabel lblNewLabel = new JLabel("Số lượng nhân sự ở mỗi phòng");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblNewLabel.setBounds(163, 26, 324, 37);
			contentPanel.add(lblNewLabel);
		
		
			JLabel lblKTon = new JLabel("Kế Toán");
			lblKTon.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblKTon.setBounds(10, 100, 139, 22);
			contentPanel.add(lblKTon);
		
		
			JLabel lblHnhChnh = new JLabel("Hành chính");
			lblHnhChnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHnhChnh.setBounds(10, 152, 139, 22);
			contentPanel.add(lblHnhChnh);
		
		
			JLabel lblChmScKhch = new JLabel("Chăm sóc khách hàng");
			lblChmScKhch.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblChmScKhch.setBounds(10, 205, 139, 22);
			contentPanel.add(lblChmScKhch);
	
		
			JLabel lblNhnS = new JLabel("Nhân sự");
			lblNhnS.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNhnS.setBounds(10, 271, 139, 22);
			contentPanel.add(lblNhnS);
		
		
			JLabel lblCngNghThng = new JLabel("Công nghệ thông tin");
			lblCngNghThng.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCngNghThng.setBounds(10, 330, 139, 22);
			contentPanel.add(lblCngNghThng);
	
		
			JLabel lblQuanHQuc = new JLabel("Quan hệ quốc tế");
			lblQuanHQuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblQuanHQuc.setBounds(10, 387, 139, 22);
			contentPanel.add(lblQuanHQuc);
		
		
			JLabel lblMarketing = new JLabel("Marketing");
			lblMarketing.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMarketing.setBounds(10, 438, 139, 22);
			contentPanel.add(lblMarketing);
		
		
			lb_kt = new JLabel("New label");
			lb_kt.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_kt.setBounds(163, 106, 145, 14);
			contentPanel.add(lb_kt);
		
		
			lb_hc = new JLabel("New label");
			lb_hc.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_hc.setBounds(163, 158, 145, 14);
			contentPanel.add(lb_hc);
		
	
			lb_cskh = new JLabel("New label");
			lb_cskh.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_cskh.setBounds(163, 211, 145, 14);
			contentPanel.add(lb_cskh);
		
		
			lb_ns = new JLabel("New label");
			lb_ns.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_ns.setBounds(163, 277, 145, 14);
			contentPanel.add(lb_ns);
		
		
			lb_cntt = new JLabel("New label");
			lb_cntt.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_cntt.setBounds(163, 336, 145, 14);
			contentPanel.add(lb_cntt);
		
		
			lb_qhqt = new JLabel("New label");
			lb_qhqt.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_qhqt.setBounds(163, 393, 145, 14);
			contentPanel.add(lb_qhqt);
	
		
			lb_mar = new JLabel("New label");
			lb_mar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_mar.setBounds(163, 444, 131, 14);
			contentPanel.add(lb_mar);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(318, 100, 38, 37);
			lblNewLabel_1.setIcon(new ImageIcon(ViewThongKe.class.getResource("accountant.png")));
			contentPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setBounds(318, 152, 38, 37);
			lblNewLabel_1_1.setIcon(new ImageIcon(ViewThongKe.class.getResource("administrative.png")));
			contentPanel.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("");
			lblNewLabel_1_2.setBounds(318, 205, 38, 37);
			lblNewLabel_1_2.setIcon(new ImageIcon(ViewThongKe.class.getResource("customercare.png")));
			contentPanel.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("");
			lblNewLabel_1_3.setBounds(318, 271, 32, 37);
			lblNewLabel_1_3.setIcon(new ImageIcon(ViewThongKe.class.getResource("personel.png")));
			contentPanel.add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1_4 = new JLabel("");
			lblNewLabel_1_4.setBounds(318, 330, 32, 37);
			lblNewLabel_1_4.setIcon(new ImageIcon(ViewThongKe.class.getResource("IT.png")));
			contentPanel.add(lblNewLabel_1_4);
			
			JLabel lblNewLabel_1_5 = new JLabel("");
			lblNewLabel_1_5.setBounds(318, 387, 32, 37);
			lblNewLabel_1_5.setIcon(new ImageIcon(ViewThongKe.class.getResource("qhqt.png")));
			contentPanel.add(lblNewLabel_1_5);
			
			JLabel lblNewLabel_1_6 = new JLabel("");
			lblNewLabel_1_6.setBounds(318, 438, 32, 37);
			lblNewLabel_1_6.setIcon(new ImageIcon(ViewThongKe.class.getResource("marketing.png")));
			contentPanel.add(lblNewLabel_1_6);
			
			lb_nhanvien = new JLabel("Nhân viên");
			lb_nhanvien.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_nhanvien.setBounds(423, 182, 139, 22);
			contentPanel.add(lb_nhanvien);
			
			lb_quanly = new JLabel("Quản Lý");
			lb_quanly.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_quanly.setBounds(423, 254, 139, 22);
			contentPanel.add(lb_quanly);
			
			lb_phogiamdoc = new JLabel("Phó Giám Đốc");
			lb_phogiamdoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lb_phogiamdoc.setBounds(423, 336, 225, 22);
			contentPanel.add(lb_phogiamdoc);
			thongKe();
	}
	void thongKe() {
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			Connection conn=DriverManager.getConnection(dbURL);
			String query1="select count(manv) as soluong from nhanvien where maphong='KT'";
			PreparedStatement ps1=conn.prepareStatement(query1);
			ResultSet rs1= ps1.executeQuery();
			while(rs1.next()) {
				lb_kt.setText(rs1.getInt("soluong")+" nhân sự");
			}
			String query2="select count(manv) as soluong from nhanvien where maphong='HC'";
			PreparedStatement ps2=conn.prepareStatement(query2);
			ResultSet rs2= ps2.executeQuery();
			while(rs2.next()) {
				lb_hc.setText(rs2.getInt("soluong")+" nhân sự");
			}
			String query3="select count(manv) as soluong from nhanvien where maphong='CSKH'";
			PreparedStatement ps3=conn.prepareStatement(query3);
			ResultSet rs3= ps3.executeQuery();
			while(rs3.next()) {
				lb_cskh.setText(rs3.getInt("soluong")+" nhân sự");
			}
			String query4="select count(manv) as soluong from nhanvien where maphong='NS'";
			PreparedStatement ps4=conn.prepareStatement(query4);
			ResultSet rs4= ps4.executeQuery();
			while(rs4.next()) {
				lb_ns.setText(rs4.getInt("soluong")+" nhân sự");
			}
			String query5="select count(manv) as soluong from nhanvien where maphong='CNTT'";
			PreparedStatement ps5=conn.prepareStatement(query5);
			ResultSet rs5= ps5.executeQuery();
			while(rs5.next()) {
				lb_cntt.setText(rs5.getInt("soluong")+" nhân sự");
			}String query6="select count(manv) as soluong from nhanvien where maphong='QHQT'";
			PreparedStatement ps6=conn.prepareStatement(query6);
			ResultSet rs6= ps6.executeQuery();
			while(rs6.next()) {
				lb_qhqt.setText(rs6.getInt("soluong")+" nhân sự");
			}
			String query7="select count(manv) as soluong from nhanvien where maphong='MAR'";
			PreparedStatement ps7=conn.prepareStatement(query7);
			ResultSet rs7= ps7.executeQuery();
			while(rs7.next()) {
				lb_mar.setText(rs7.getInt("soluong")+" nhân sự");
			}
			String soNhanVien="select count(manv) as soluong from nhanvien where machucvu='NV'";
			PreparedStatement ps8=conn.prepareStatement(soNhanVien);
			ResultSet rs8= ps8.executeQuery();
			while(rs8.next()) {
				lb_nhanvien.setText("Nhân viên:  "+ rs8.getInt("soluong") +" người");
			}
			String soQuanLy="select count(manv) as soluong from nhanvien where machucvu='QL'";
			PreparedStatement ps9=conn.prepareStatement(soQuanLy);
			ResultSet rs9= ps9.executeQuery();
			while(rs9.next()) {
				lb_quanly.setText("Quản lý:  "+ rs9.getInt("soluong")+" người");
			}
			String soPGD="select count(manv) as soluong from nhanvien where machucvu='PGD'";
			PreparedStatement ps10=conn.prepareStatement(soPGD);
			ResultSet rs10= ps10.executeQuery();
			while(rs10.next()) {
				lb_phogiamdoc.setText("Phó Giám Đốc:  "+ rs10.getInt("soluong")+" người");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
