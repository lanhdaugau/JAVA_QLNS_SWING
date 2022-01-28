package Model;

public class NhanVien {
	private String maNV;
	private String hoTen;
	private Object ngaySinh;
	private String gioiTinh;
	private String queQuan;
	private String soDienThoai;
	private String email;
	private Object ngayVaoCty;
	private String maChucVu;
	private long soCMND;
	private String noiCap;
	private Object ngayCap;
	private String danToc;
	private int bacLuong;
	private String phong;
	private String duongDanAnhCaNhan;

	
	public NhanVien(String maNV, String hoTen, Object ngaySinh, String gioiTinh, String queQuan, String soDienThoai,
			String email, Object ngayVaoCty, long soCMND, String noiCap, Object ngayCap, String danToc,
			int bacLuong, String phong, String duongDanAnhCaNhan, String chucVu) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.queQuan = queQuan;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.ngayVaoCty = ngayVaoCty;
		this.maChucVu = chucVu;
		this.soCMND = soCMND;
		this.noiCap = noiCap;
		this.ngayCap = ngayCap;
		this.danToc = danToc;
		this.bacLuong = bacLuong;
		this.phong = phong;
		this.duongDanAnhCaNhan = duongDanAnhCaNhan;
	}
	public String getNoiCap() {
		return noiCap;
	}
	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}
	public Object getNgayCap() {
		return ngayCap;
	}
	public void setNgayCap(Object ngayCap) {
		this.ngayCap = ngayCap;
	}
	public String getDanToc() {
		return danToc;
	}
	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}
	public int getBacLuong() {
		return bacLuong;
	}
	public void setBacLuong(int bacLuong) {
		this.bacLuong = bacLuong;
	}
	public String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	
	
	public NhanVien() {
		super();
	}
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Object getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Object ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getNgayVaoCty() {
		return ngayVaoCty;
	}
	public void setNgayVaoCty(Object ngayVaoCty) {
		this.ngayVaoCty = ngayVaoCty;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String chucVu) {
		this.maChucVu = chucVu;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public long getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(long soCMND) {
		this.soCMND = soCMND;
	}
	public String getDuongDanAnhCaNhan() {
		return duongDanAnhCaNhan;
	}
	public void setDuongDanAnhCaNhan(String duongDanAnhCaNhan) {
		this.duongDanAnhCaNhan = duongDanAnhCaNhan;
	}
	
	
}
