package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewThongBao extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewThongBao dialog = new ViewThongBao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * Create the dialog.
	 */
	public ViewThongBao() {
		setTitle("Điều lệ của công ty");
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().createImage(View.class.getResource("info-icon.png")));
		setBounds(100, 100, 760, 434);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 27, 724, 324);
			contentPanel.add(scrollPane);
			{
			 textArea = new JTextArea();
				scrollPane.setViewportView(textArea);
			}
		}
		{	
			
		}
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				textArea.setText("1. Khái niệm điều lệ công ty:\r\n"
						+ "Điều lệ công ty là bản cam kết của tất cả thành viên công ty về mục đích thành lập, về tổ chức quản lí và tổ chức hoạt động cho công ty, được các thành viên công ty thông qua và được cơ quan đăng kí kinh doanh xác nhận.\r\n"
						+ "\r\n"
						+ "Điều lệ công ty là bản thỏa thuận giữa những người chủ sở hữu công ty với nhau, là sự cam kết, ràng buộc các thành viên trong một luật lệ chung, được soạn thảo căn cứ trên những khuôn mẫu chung của pháp luật, để ấn định các\n nguyên tắc về cách thức thành lập, quản lý, hoạt động và giải thể của doanh nghiệp. Điều lệ công ti được xây dựng từ sự thoả thuận \ntự nguyện của các thành viên trên cơ sở không trái với quy định của pháp luật. Bởi vậy, các quy định của điều lệ có \ngiá trị bắt buộc thi hành đối với công ti và các thành viên của nó.\r\n"
						+ "\r\n"
						+ "Điều lệ công ti không chỉ điều chỉnh các quan hệ đối nội giữa các thành viên công ti với nhau; thành viên công ty với chính công ty mà còn điều chỉnh cả quan hệ đối ngoại của công ty với những người liên quan. Vì lẽ đó, điều \n lệ công ty thường có các nội dung chủ yếu như: hình thức, mục tiêu, tên gọi, trụ sở chính, thời hạn hoạt động của công ty; họ tên, địa chỉ các thành viên; vốn điều lệ, phần góp của mỗi thành viên vào vốn điều lệ; quyền và nghĩa vụ của thành viên\n công ty; cơ cấu tổ chức quản lý, người đại diện theo pháp luật của công ty; thể thức thông qua \nquyết định của công ty, nguyên tắc giải quyết tranh chấp nội bộ; các loại quỹ và mức giới hạn các quỹ được lập tại công ty, \nnguyên tắc phân chia lãi, lỗ trong kinh doanh; các trường hợp giải thể, thủ tục giải \nthể; thể thức sửa đổi, bổ sung điều lệ công ty.\r\n"
						+ "\r\n"
						+ "2. Đặc điểm của điều lệ công ty:\r\n"
						+ "Điều lệ công ty được xem như là bản hiến pháp của mỗi doanh nghiệp. Nếu Hiến pháp là luât cơ bản và quan trọng nhất của mỗi quốc gia thì Điều lệ công ty được xem là luật cơ bản nhất của doanh nghiệp.\r\n"
						+ "\r\n"
						+ "- Điều lệ công ty là căn cứ pháp lý đầu tiên và quan trọng nhất khi có tranh chấp xảy ra, được đưa ra làm cơ sở để các cơ quan Nhà nước có thẩm quyền giải quyết tranh chấp và các vấn đề phát sinh của doanh nghiệp." 
						+ "- Điều lệ công ty do doanh nghiệp tự lập nên, có nội dung căn cứ theo các quy định về pháp luật doanh nghiệp và không được trái với các quy định pháp luật.\r\n"
						+ "\r\n"
						+ "- Điều lệ là bản cam kết của các thành viên công ty về việc thành lập công ty, quản lý và hoạt động của doanh nghiệp.\r\n"
						+ "\r\n"
						+ "- Việc xác lập, sửa đổi, bổ sung và hủy bỏ Điều lệ của công ty phải thực hiện tuân thủ theo các quy định của pháp luật.\r\n"
						+ "\r\n"
						+ "- Điều lệ công ty bao gồm Điều lệ khi đăng ký doanh nghiệp và Điều lệ được sửa đổi, bổ sung trong quá trình hoạt động của doanh nghiệp.\r\n"
						+ "\r\n"
						+ "3. Nội dung điều lệ công ty theo quy định pháp luật :\r\n"
						+ "- Điều lệ công ty bao gồm Điều lệ khi đăng ký doanh nghiệp và Điều lệ được sửa đổi, bổ sung trong quá trình hoạt động.\r\n"
						+ "\r\n"
						+ "3.1.Điều lệ công ty bao gồm các nội dung chủ yếu sau đây:\r\n"
						+ "+ Tên, địa chỉ trụ sở chính của công ty; tên, địa chỉ chi nhánh và văn phòng đại diện (nếu có);\r\n"
						+ "\r\n"
						+ "+ Ngành, nghề kinh doanh;\r\n"
						+ "\r\n"
						+ "+ Vốn điều lệ; tổng số cổ phần, loại cổ phần và mệnh giá từng loại cổ phần đối với công ty cổ phần;\r\n"
						+ "\r\n"
						+ "+ Họ, tên, địa chỉ liên lạc, quốc tịch của thành viên hợp danh đối với công ty hợp danh; của chủ sở hữu công ty, thành viên đối với công ty trách nhiệm hữu hạn; của cổ đông sáng lập đối với công ty cổ phần. "
						+ "Phần vốn góp và giá trị vốn góp của mỗi thành viên đối với công ty trách nhiệm hữu hạn và công ty hợp danh. Số cổ phần, loại cổ phần, mệnh giá từng loại cổ phần của cổ đông sáng lập đối với công ty cổ phần;\r\n"
						+ "\r\n"
						+ "+ Quyền và nghĩa vụ của thành viên đối với công ty trách nhiệm hữu hạn, công ty hợp danh; của cổ đông đối với công ty cổ phần;\r\n"
						+ "\r\n"
						+ "+ Cơ cấu tổ chức quản lý;\r\n"
						+ "\r\n"
						+ "+ Số lượng, chức danh quản lý và quyền, nghĩa vụ của người đại diện theo pháp luật của doanh nghiệp; phân chia quyền và nghĩa vụ của người đại diện theo pháp luật trong trường hợp công ty có nhiều hơn một người đại diện theo pháp luật;\r\n"
						+ "\r\n"
						+ "+ Thể thức thông qua quyết định của công ty; nguyên tắc giải quyết tranh chấp nội bộ;\r\n"
						+ "\r\n"
						+ "+ Căn cứ và phương pháp xác định tiền lương, thù lao, thưởng của người quản lý và Kiểm soát viên;\r\n"
						+ "\r\n"
						+ "+ Trường hợp thành viên, cổ đông có quyền yêu cầu công ty mua lại phần vốn góp đối với công ty trách nhiệm hữu hạn hoặc cổ phần đối với công ty cổ phần;\r\n"
						+ "\r\n"
						+ "+ Nguyên tắc phân chia lợi nhuận sau thuế và xử lý lỗ trong kinh doanh;\r\n"
						+ "\r\n"
						+ "+ Trường hợp giải thể, trình tự giải thể và thủ tục thanh lý tài sản công ty;\r\n"
						+ "\r\n"
						+ "+ Thể thức sửa đổi, bổ sung Điều lệ công ty.\r\n"
						+ "\r\n"
						+ "3.2 Điều lệ công ty khi đăng ký doanh nghiệp phải bao gồm họ, tên và chữ ký của những người sau đây:\r\n"
						+ "+ Thành viên hợp danh đối với công ty hợp danh;\r\n"
						+ "\r\n"
						+ "+ Chủ sở hữu công ty là cá nhân hoặc người đại diện theo pháp luật của chủ sở hữu công ty là tổ chức đối với công ty trách nhiệm hữu hạn một thành viên;\r\n"
						+ "\r\n"
						+ "+ Thành viên là cá nhân và người đại diện theo pháp luật hoặc người đại diện theo ủy quyền của thành viên là tổ chức đối với công ty trách nhiệm hữu hạn hai thành viên trở lên;\r\n"
						+ "\r\n"
						+ "+ Cổ đông sáng lập là cá nhân và người đại diện theo pháp luật hoặc người đại diện theo ủy quyền của cổ đông sáng lập là tổ chức đối với công ty cổ phần.\r\n"
						+ "\r\n"
						+ "- Điều lệ công ty được sửa đổi, bổ sung phải bao gồm họ, tên và chữ ký của những người sau đây:\r\n"
						+ "\r\n"
						+ "+ Chủ tịch Hội đồng thành viên đối với công ty hợp danh;\r\n"
						+ "\r\n"
						+ "+ Chủ sở hữu, người đại diện theo pháp luật của chủ sở hữu hoặc người đại diện theo pháp luật đối với công ty trách nhiệm hữu hạn một thành viên;\r\n"
						+ "\r\n"
						+ "+ Người đại diện theo pháp luật đối với công ty trách nhiệm hữu hạn hai thành viên trở lên và công ty cổ phần.\r\n"
						+ "\r\n"
						+ "4. Vai trò của điều lệ công ty trong doanh nghiệp:\r\n"
						+ "Bên cạnh các quy định tại Luật doanh nghiệp năm 2020 và các quy định pháp luật khác, việc thành lập, tổ chức quản lý hoạt động, tổ chức lại và giải thể của các doanh nghiệp còn được điều chỉnh bởi điều lệ và các tài \n"
						+ "liệu nội bộ khác\n"
						+ "( bao gồm các quy chế quản lý nội bộ và các sổ đăng ký).\r\n"
						+ "\r\n"
						+ "Theo luật doanh nghiệp 2020 thì doanh nghiệp tư nhân không bắt buộc phải có điều lệ. Công ty hợp danh, công ty trách nhiệm hữu hạn và công ty cổ phần thì đều phải có điều lệ. Để được cấp giấy chứng nhận đăng ký doanh\n"
						+ " nghiệp, các thành viên hoặc cổ đông sáng lập của công ty hợp danh, công ty trách nhiệm hữu hạn và công ty cổ phần cần \n"
						+ "nộp dự thảo điều lệ công ty cho cơ quan đăng ký kinh doanh. Điều lệ\n công ty không phải là công ty đại chúng tương đối đơn giản và cơ quan đăng ký kinh doanh\n ở từng địa phương \n"
						+ "( ví dụ Sở kế hoạch và đầu tư) đều có mẫu điều lệ để tham khảo. Điều lệ thường có hiệu lực tại thời điểm công ty được cấp giấy chứng nhận đăng ký doanh nghiệp.\r\n"
						+ "\r\n"
						+ "Điều lệ doanh nghiệp được xem là một văn bản nội bộ quan trọng nhất trong doanh nghiệp và là văn bản đầu tiên của doanh nghiêp, các thành viên sáng lập ký vào đó để cùng nhau thực hiện việc quản trị điều hành doanh \n "
						+ "nghiệp. Mức độ quan trọng của điều lệ doanh nghiệp ở chỗ, các văn bản trong nội bộ công ty phải phù hợp và tuân thủ theo điều lệ công ty về mặt nội dung. Điều lệ doanh nghiệp được\n coi như bản \" Tuyên ngôn độc lập\" của doanh nghiệp, thể hiện những thỏa thuận của các chủ sở\n hữu doanh\n"
						+ " nghiệp về toàn bộ các vấn đề quản trị điều hành, chia lợi nhuận cổ tức,tăng giảm vốn điều lệ,.. của doanh nghiệp. Điều lệ càng chi tiết càng bảo đảm cho doanh nghiệp và ban\n quản trị điều hành công ty được hoạt động tốt hơn.\n"
						+ " Một trong các mục tiêu của điều lệ là giải quyết tất cả vấn đề nguyên tắc quản trị và điều hành trong công ty cũng như các mối quan hệ của bộ phận quản trị điều hành doanh nghiệp trong công ty. Vì vậy một điều lệ\n"
						+ " tốt là điều lệ mà người ta có thể căn cứ vào đó để tìm giải pháp giải quyết các vấn đề phát sinh trong quản trị điều hành công ty.\r\n"
						+ "\r\n"
						+ "Tầm quan trọng của Điều lệ được thể hiện như sau:\r\n"
						+ "\r\n"
						+ "Thứ nhất: Điều lệ công ty chuyển tải những vấn đề quan trọng nhất liên quan đến tổ chức và hoạt động của công ty, trong đó nổi bật nhất là hai vấn đề:\r\n"
						+ "- Cơ cấu tổ chức bộ máy quyền lực của công ty và cách sử dụng quyền lực ấy vào hoạt động kinh doanh: quyền và nghĩa vụ của thành viên/cổ đông, cơ cấu tổ chức quản lý, người đại diện theo pháp luật đối với công ty trách\n nhiệm hữu hạn, công ty cổ phần, thể thức thông qua quyết định của công ty.\r\n"
						+ "- Quyền và các nghĩa vụ của các cổ đông, thành viên góp vốn- những người chủ của công ty, kèm theo những nguyên tắc thực hiện, giải quyết tranh chấp nội bộ phát sinh.\r\n"
						+ "\r\n"
						+ "Thứ hai: điều lệ của công ty được thành lập dựa trên sự thống nhất ý chí của cơ quan quyền lực nhất trong công ty đó là hội đồng cổ đông hoặc hội đồng thành viên, do nó có giá trị áp dụng cao, xuyên suốt mọi hoạt động.\n Trong nhiều hoạt động của công ty cũng như những tranh chấp phát sinh, những quy định của điều lệ công ty có thể được ưu tiên áp dụng trước pháp luật.\r\n"
						+ "\r\n"
						+ "Thứ ba điều lệ công ty là nghệ thuật kinh doanh. Điều lệ công ty phần nào cũng giống như một bản dự án kêu gọi nhà đầu tư.\r\n"
						+ "\r\n"
						+ "Theo điều 24 của Luật doanh nghiệp 2020 thì tại khoản 1 quy định nội dung tối thiểu cần được quy định trong điều lệ và phải phù hợp với quy định pháp luật. Việc quy định các nội dung tối thiểu như trên là cần thiết để bảo\n đảm dự thảo điều lệ được cơ quan đăng ký kinh doanh chấp thuận và có giá trị ràng buộc đối với các thành viên hoặc cổ đông trong doanh nghiệp. Ngoài 13 nội dung bắt buộc phải có , các thành viên hoặc cổ đông có thể tự do thỏa thuận và quy định các nội dung khác trong điều lệ \nnhưng các nội dung khác này không được trái với quy định của Luật doanh nghiệp năm 2020 nói riêng và quy định pháp luật về doanh nghiệp nói chung.");
		
		
	}
	
}
