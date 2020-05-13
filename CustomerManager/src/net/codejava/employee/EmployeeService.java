package net.codejava.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
	@Autowired EmployeeRepository repo;
	@Autowired EmployeeRepositoryCustom customRepo;
	
	public void save(Employee employee) {
		repo.save(employee);
	}
	
	public List<Employee> listAll() {
		return (List<Employee>) repo.findAll();
	}
	
	public Employee get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Employee> search(String keyword) {
		return repo.search(keyword);
	}
	
	public List<Employee> searchByNameCutomQuery(String keyword) {
		return repo.searchByNameCutomQuery(keyword);
	}
	
	public List<Employee> findByAddress(String keyword) {
		//return customRepo.findByAddress(keyword);
		return customRepo.findByAddressAndEmail(keyword, keyword);
	}
	
	public List<Employee> findByEmailCustomQuery(String keyword) {
		return customRepo.findByEmailCustomQuery(keyword);
	}
	
}
