package net.codejava.employee;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepositoryCustom extends JpaRepository<Employee, Long> {
	public List<Employee> findByAddress(String address);
	public List<Employee> findByEmail(String address);
	public List<Employee> findByAddressAndEmail(String address, String email);
	public List<Employee> findByEmailCustomQuery(String email);
}
