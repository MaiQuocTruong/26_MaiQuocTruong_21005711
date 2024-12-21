package fit.iuh.se.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "masv")
	private int masv;
	
	@Column(name = "tensv", nullable = false, length = 50)
	@NotEmpty(message = "Tên sinh viên không được bỏ trống")
	@Size(max = 50, message = "Tên sinh viên không được quá 50 ký tự")
	private String tenSV;
	
	@Column(name = "email", nullable = false, length = 255)
	@NotEmpty(message = "Email không được bỏ trống")
    @Email(message = "Email phải có định dạng đúng")
	private String email;
	
	@Column(name = "ngaysinh", nullable = false)
    @Temporal(TemporalType.DATE)
	@Past(message = "Ngày sinh phải là quá khứ và bạn phải đủ 18 tuổi")
	private Date ngaySinh;
	
	@Column(name = "gioitinh", nullable = false)
	private String gioitinh;
	
	@Column(name = "dienthoai", nullable = false, length = 255)
	@NotEmpty(message = "Dien thoai must not be empty")
	private String dienthoai;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "malop", nullable = false)
	private LopHoc lophoc;

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SinhVien(int masv,
			@NotEmpty(message = "Tên sinh viên không được bỏ trống") @Size(max = 50, message = "Tên sinh viên không được quá 50 ký tự") String tenSV,
			@NotEmpty(message = "Email không được bỏ trống") @Email(message = "Email phải có định dạng đúng") String email,
			@Past(message = "Ngày sinh phải là quá khứ và bạn phải đủ 18 tuổi") Date ngaySinh, String gioitinh,
			@NotEmpty(message = "Dien thoai must not be empty") String dienthoai, LopHoc lophoc) {
		super();
		this.masv = masv;
		this.tenSV = tenSV;
		this.email = email;
		this.ngaySinh = ngaySinh;
		this.gioitinh = gioitinh;
		this.dienthoai = dienthoai;
		this.lophoc = lophoc;
	}



	public int getMasv() {
		return masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
        if (email != null && !email.endsWith("@gmail.com")) {
            throw new IllegalArgumentException("Email phải có định dạng @gmail.com");
        }
        this.email = email;
    }

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
        if (ngaySinh != null) {
            Calendar today = Calendar.getInstance();
            Calendar dob = Calendar.getInstance();
            dob.setTime(ngaySinh);
            dob.add(Calendar.YEAR, 18);
            if (dob.after(today)) {
                throw new IllegalArgumentException("Ngày sinh phải lớn hơn hoặc bằng 18 tuổi");
            }
        }
        this.ngaySinh = ngaySinh;
    }
	
	public String getNgaySinhFormatted() {
        if (ngaySinh != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.format(ngaySinh);
        }
        return null;
    }

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getDienthoai() {
		return dienthoai;
	}

	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}

	public LopHoc getLophoc() {
		return lophoc;
	}

	public void setLophoc(LopHoc lophoc) {
		this.lophoc = lophoc;
	}
	
	
}
