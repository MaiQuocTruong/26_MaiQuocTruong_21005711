package fit.iuh.se.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="lophoc")
public class LopHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="malop")
	private int maLop;
	
	@Column(name = "tenlop", nullable = false, length = 255)
	private String tenLop;
	
	@OneToMany(mappedBy = "lophoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SinhVien> sinhviens;

	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LopHoc(int maLop, String tenLop, List<SinhVien> sinhviens) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.sinhviens = sinhviens;
	}

	public int getMaLop() {
		return maLop;
	}

	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public List<SinhVien> getSinhviens() {
		return sinhviens;
	}

	public void setSinhviens(List<SinhVien> sinhviens) {
		this.sinhviens = sinhviens;
	}

	@Override
	public String toString() {
		return "LopHoc [maLop=" + maLop + ", tenLop=" + tenLop + ", sinhviens=" + sinhviens + "]";
	}
	
}
