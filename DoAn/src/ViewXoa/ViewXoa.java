package ViewXoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import View.View;
import ViewSua.ViewSua;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class ViewXoa extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_ma;
	private JTextField text_hoten;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField text_que_quan;
	private JTextField text_chuc_vu;
	private JLabel lb_anh;
	private View view;

	private String hoten;
	public ViewXoa(JFrame parent,boolean modal) {
		super(parent,modal);
		view=(View) parent;
		
		setIconImage(Toolkit.getDefaultToolkit().createImage(ViewXoa.class.getResource("Delete-group-icon.png")));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 50, 564, 486);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tìm kiếm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 82, 65, 17);
		contentPane.add(lblNewLabel);

		text_ma = new JTextField();
		text_ma.setBounds(156, 82, 111, 20);
		contentPane.add(text_ma);
		text_ma.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 113, 506, 2);
		contentPane.add(separator);

		JLabel lb_ho_ten = new JLabel("Họ tên:");
		lb_ho_ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_ho_ten.setBounds(20, 180, 67, 17);
		contentPane.add(lb_ho_ten);

		text_hoten = new JTextField();
		text_hoten.setEditable(false);
		text_hoten.setBounds(101, 180, 131, 20);
		contentPane.add(text_hoten);
		text_hoten.setColumns(10);

		lblNewLabel_2 = new JLabel("Quê quán");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 232, 67, 17);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Chức vụ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 289, 67, 17);
		contentPane.add(lblNewLabel_3);

		text_que_quan = new JTextField();
		text_que_quan.setEditable(false);
		text_que_quan.setColumns(10);
		text_que_quan.setBounds(101, 232, 131, 20);
		contentPane.add(text_que_quan);

		text_chuc_vu = new JTextField();
		text_chuc_vu.setEditable(false);
		text_chuc_vu.setColumns(10);
		text_chuc_vu.setBounds(101, 291, 131, 20);
		contentPane.add(text_chuc_vu);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(353, 126, 134, 156);
		contentPane.add(panel_1);

		lb_anh = new JLabel("");
		lb_anh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_anh.setBounds(10, 11, 114, 134);
		panel_1.add(lb_anh);

		JLabel lb_anh_1 = new JLabel("");
		lb_anh_1.setBounds(10, 11, 114, 134);
		panel_1.add(lb_anh_1);

		JLabel lblNewLabel_4 = new JLabel("Ảnh nhân sự");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(381, 292, 93, 19);
		contentPane.add(lblNewLabel_4);

		JButton bt_tim = new JButton("Tìm \r\n");
		bt_tim.setMnemonic(KeyEvent.VK_ENTER);
		contentPane.getRootPane().setDefaultButton(bt_tim);
		bt_tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(hienThi(text_ma.getText())==null) {
					JOptionPane.showMessageDialog(null, "Mã nhân sự bạn nhập không tồn tại !","Lỗi nhập mã",JOptionPane.WARNING_MESSAGE);
				}
				else {
					hoten=null;

				}
			}
		});
		bt_tim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_tim.setBounds(323, 79, 89, 23);
		contentPane.add(bt_tim);

		JButton bt_xoa = new JButton("    Xoá");
		bt_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int chon= JOptionPane.showConfirmDialog(null, "Bạn có xác nhận xoá nhân sự "+text_hoten.getText()+" không?", "Xác nhận xoá 🚫", JOptionPane.YES_NO_OPTION);
				if(chon==JOptionPane.YES_OPTION) {
				xoa(text_ma.getText());
				clearForm();
				DefaultTableModel model= (DefaultTableModel) view.table.getModel();
				model.setRowCount(0);
				view.showUser();
				}
			}
		});
		try {
			bt_xoa.setIcon(new ImageIcon(ImageIO.read(ViewXoa.class.getResourceAsStream("delete_icon.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		bt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bt_xoa.setBounds(204, 370, 111, 33);
		contentPane.add(bt_xoa);

		JLabel lblNewLabel_1 = new JLabel("Xoá nhân sự");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(188, 11, 299, 46);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_5 = new JLabel("");
		try {
			lblNewLabel_5.setIcon(new ImageIcon(ImageIO.read(ViewXoa.class.getResourceAsStream("Delete-group-icon.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel_5.setBounds(71, 11, 107, 64);
		contentPane.add(lblNewLabel_5);

	}

	
	void xoa(String ma) {
		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			Connection conn=DriverManager.getConnection(dbURL);
			String xoa="DELETE FROM nhanvien where manv=?";
			PreparedStatement ps=conn.prepareStatement(xoa);
			ps.setString(1, ma);
			ps.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String hienThi(String ma) {

		try {
			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			Connection conn=DriverManager.getConnection(dbURL);
			String query= "SELECT * FROM nhanvien where manv=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, ma);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
			text_hoten.setText(rs.getString("hoten"));
			text_que_quan.setText(rs.getString("quequan"));
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

			text_chuc_vu.setText(chucVu);
			lb_anh.setIcon(new ImageIcon(rs.getString("linkanhcanhan")));
			hoten=rs.getString("hoten");
			}
			
			
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return hoten;
	}
	void clearForm() {
		text_hoten.setText(null);
		text_ma.setText(null);
		text_que_quan.setText(null);
		text_chuc_vu.setText(null);
		lb_anh.setIcon(null);
	}
}
