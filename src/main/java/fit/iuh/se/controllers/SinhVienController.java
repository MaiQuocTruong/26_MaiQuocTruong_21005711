package fit.iuh.se.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fit.iuh.se.entities.SinhVien;
import fit.iuh.se.services.LopHocService;
import fit.iuh.se.services.SinhVienService;
import jakarta.validation.Valid;

@Controller
public class SinhVienController {
	@Autowired
	SinhVienService sinhvienService;
	@Autowired
	LopHocService lophocService;
	
	@GetMapping("/sinhvien")
	public String getAllSinhVien(Model model) {
		model.addAttribute("sv", sinhvienService.findAll());
		return "sinhvien-list";
	}
	
	@GetMapping("/sinhvien/add-sinhvien")
	public String addSinhVienForm(Model model) {
		model.addAttribute("addNewSinhVien", new SinhVien());
		model.addAttribute("lophocs", lophocService.findAll());
		return "AddSinhVien";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new java.beans.PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				try {
					setValue(dateFormat.parse(text));
				} catch (Exception e) {
					setValue(null); 
              }
			}
		});
	}
	
	@PostMapping("/sinhvien/save")
	public String saveSinhVien(@Valid @ModelAttribute("addNewSinhVien") SinhVien sinhvien, BindingResult bindingResult, Model model) {
	    // Check if email already exists
	    if (sinhvienService.existsByEmail(sinhvien.getEmail())) {
	        bindingResult.rejectValue("email", "error.email", "Email đã tồn tại");
	    }

	    if (bindingResult.hasErrors()) {
	        model.addAttribute("lophocs", lophocService.findAll());
	        return "AddSinhVien";
	    }

	    sinhvienService.save(sinhvien);
	    return "redirect:/sinhvien";
	}
	
	@GetMapping("/sinhvien/delete/{masv}")
	public String deleteSinhVien(@PathVariable("masv") int masv) {
		boolean isDeleted = sinhvienService.delete(masv);
		if (isDeleted) {
			return "redirect:/sinhvien";
        } else {
            return "redirect:/sinhvien";
		} 
	}
	
	@GetMapping("/sinhvien/edit-sinhvien/{masv}")
	public String editSinhVienForm(@PathVariable("masv") int masv, Model model) {
		SinhVien sinhvien = sinhvienService.findByMasv(masv);
		model.addAttribute("updateSinhVien", sinhvien);
		model.addAttribute("lophocs", lophocService.findAll());
		return "Edit";
	}
	
	@PostMapping("/sinhvien/update/{masv}")
	public String updateSinhVien(@PathVariable("masv") int masv, @Valid @ModelAttribute("updateSinhVien") SinhVien sinhvien, BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors()) {
	        model.addAttribute("lophocs", lophocService.findAll());
	        return "Edit";
	    }

	    sinhvien.setMasv(masv);
	    sinhvienService.save(sinhvien);
	    return "redirect:/sinhvien";
	}

	
	@GetMapping("/sinhvien/search")
	public String searchSinhVien(@RequestParam("keyword") String keyword, Model model) {
		List<SinhVien> sinhvien = sinhvienService.search(keyword);
		model.addAttribute("sv", sinhvien);
		model.addAttribute("keyword", keyword);
		return "sinhvien-list";
	}
	
}
