package fit.iuh.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.iuh.se.entities.LopHoc;

@Repository
public interface LopHocRepository extends JpaRepository<LopHoc, Integer>{

}
