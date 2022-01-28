package View;

import java.awt.BorderLayout;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTinhLuong extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_ma;
	private JLabel lb_luong;
	private JLabel lb_anh;
	private JLabel lb_ten;
	String hoten;
	double tongluong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewTinhLuong dialog = new ViewTinhLuong();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewTinhLuong() {
		setIconImage(Toolkit.getDefaultToolkit().createImage(ViewTinhLuong.class.getResource("Calculator.png")));
		setBounds(100, 100, 482, 334);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		text_ma = new JTextField();
		text_ma.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
			}
		});
		text_ma.setBounds(114, 42, 126, 28);
		contentPanel.add(text_ma);
		text_ma.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(37, 40, 26, 28);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(56, 40, 18, 28);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(":");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(73, 40, 18, 28);
		contentPanel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Tính lương");
		btnNewButton.setMnemonic(KeyEvent.VK_ENTER);{
			contentPanel.getRootPane().setDefaultButton(btnNewButton);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tinhLuong();
				if(hoten==null){
					JOptionPane.showMessageDialog(null, "Mã nhân sự bạn nhập không hợp lệ","Lỗi"
							+ " mã nhân sự", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					int yes= JOptionPane.showConfirmDialog(null, "Bạn có muốn thưởng lương cho "+hoten
							+ " không", "Thưởng lương", JOptionPane.YES_NO_OPTION);
					if(yes==JOptionPane.YES_OPTION) {
						String input=JOptionPane.showInputDialog("Nhập số tiền thưởng (triệu)");
						float money= Float.parseFloat(input);
						tongluong+=money;
						lb_luong.setText(tongluong+"");
						}
					else {
						tinhLuong();
						lb_luong.setText(tongluong+"");
					}
					hoten=null;
					tongluong=0;
				}
				
				
			
				
			}
		});
		btnNewButton.setBounds(290, 40, 104, 28);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng lương :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(23, 152, 94, 28);
		contentPanel.add(lblNewLabel_2);
		
		lb_luong = new JLabel("");
		lb_luong.setHorizontalAlignment(SwingConstants.LEFT);
		lb_luong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_luong.setBounds(114, 154, 145, 26);
		contentPanel.add(lb_luong);
		
		JButton btnNewButton_1 = new JButton("Ok");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(160, 212, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHTn.setBounds(23, 100, 57, 28);
		contentPanel.add(lblHTn);
		
		 lb_ten = new JLabel("");
		lb_ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb_ten.setBounds(114, 100, 145, 28);
		contentPanel.add(lb_ten);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(322, 79, 134, 156);
		contentPanel.add(panel_1);
		
		 lb_anh = new JLabel("");
		lb_anh.setHorizontalAlignment(SwingConstants.CENTER);
		lb_anh.setBounds(10, 11, 114, 134);
		panel_1.add(lb_anh);
		
		JLabel lb_anh_1 = new JLabel("");
		lb_anh_1.setHorizontalAlignment(SwingConstants.CENTER);
		lb_anh_1.setBounds(10, 11, 114, 134);
		panel_1.add(lb_anh_1);
		
		JLabel lblNewLabel_3 = new JLabel("Triệu VND");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(254, 161, 66, 19);
		contentPanel.add(lblNewLabel_3);
	}
	void tinhLuong() {
		try {

			String dbURL = "jdbc:sqlserver://localhost;databaseName=QLNS;user=sa;password=sa";
			Connection conn=DriverManager.getConnection(dbURL);
			String sql ="SELECT * FROM nhanvien nv,luong l where nv.bacluong=l.bacluong and manv=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, text_ma.getText() );
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				tongluong =rs.getInt("mucluongcoso")*rs.getFloat("hesoluong");
				lb_anh.setIcon(new ImageIcon(rs.getString("linkanhcanhan")));
				lb_ten.setText(rs.getString("hoten"));
				hoten=rs.getString("hoten");
			}
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
