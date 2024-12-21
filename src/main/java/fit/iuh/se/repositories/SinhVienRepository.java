package fit.iuh.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fit.iuh.se.entities.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer>{
	@Query(value = "SELECT * FROM sinhvien s WHERE s.tensv LIKE %:keyword% OR s.malop IN (SELECT l.malop FROM lophoc l WHERE l.tenlop LIKE %:keyword%)", nativeQuery = true)
	List<SinhVien> search(@Param("keyword") String keyword);
	boolean existsByEmail(String email);
}
