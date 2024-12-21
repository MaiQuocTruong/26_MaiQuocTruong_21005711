package fit.iuh.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.se.entities.LopHoc;
import fit.iuh.se.repositories.LopHocRepository;
import fit.iuh.se.services.LopHocService;

@Service
public class LopHocServiceImpl implements LopHocService{
	
	@Autowired
	private LopHocRepository lophocRepository;

	@Override
	public List<LopHoc> findAll() {
		// TODO Auto-generated method stub
		return lophocRepository.findAll();
	}
	
}
