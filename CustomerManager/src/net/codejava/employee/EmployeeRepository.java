package net.codejava.employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	@Query(value = "SELECT c FROM Employee c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'"
			+ " OR c.address LIKE '%' || :keyword || '%'")
	public List<Employee> search(@Param("keyword") String keyword);

	@Query(value = "SELECT c FROM Employee c WHERE c.name = :keyword ")
	public List<Employee> searchByNameCutomQuery(@Param("keyword") String keyword);
	
}
