package fit.iuh.se.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fit.iuh.se.entities.Employee;
import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Transactional
	@Query(value = "SELECT e.* FROM employee e INNER JOIN role r ON e.role_id = r.id WHERE e.name = :name", nativeQuery = true)
	public Employee findByName(String name);

}
