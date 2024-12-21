package fit.iuh.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.se.entities.SinhVien;
import fit.iuh.se.repositories.SinhVienRepository;
import fit.iuh.se.services.SinhVienService;

@Service
public class SinhVienServiceImpl implements SinhVienService{
	
	@Autowired
	private SinhVienRepository sinhvienRepository;
	
	@Override
	public List<SinhVien> findAll() {
		// TODO Auto-generated method stub
		return sinhvienRepository.findAll();
	}

	@Override
	public SinhVien findByMasv(int masv) {
		// TODO Auto-generated method stub
		return sinhvienRepository.findById(masv).get();
	}

	@Override
	public boolean save(SinhVien sinhvien) {
		// TODO Auto-generated method stub
		sinhvienRepository.save(sinhvien);
		return true;
	}

	@Override
	public boolean delete(int masv) {
		// TODO Auto-generated method stub
		if(sinhvienRepository.existsById(masv)) {
			sinhvienRepository.deleteById(masv);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateLopHoc(SinhVien sinhvien) {
		// TODO Auto-generated method stub
		sinhvienRepository.saveAndFlush(sinhvien);
		return true;
	}

	@Override
	public List<SinhVien> search(String keyword) {
		// TODO Auto-generated method stub
		return sinhvienRepository.search(keyword);
	}

	@Override
	public boolean existsByEmail(String email) {
	    return sinhvienRepository.existsByEmail(email);
	}

}
