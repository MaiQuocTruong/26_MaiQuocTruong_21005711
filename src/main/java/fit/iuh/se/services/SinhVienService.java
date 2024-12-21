package fit.iuh.se.services;

import java.util.List;

import fit.iuh.se.entities.SinhVien;

public interface SinhVienService {
	List<SinhVien> findAll();
	SinhVien findByMasv(int masv);
	boolean save(SinhVien sinhvien);
	boolean delete(int masv);
	boolean updateLopHoc(SinhVien sinhvien);
	List<SinhVien> search(String keyword);
	boolean existsByEmail(String email);
}
