package net.codejava.employee;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	//http://localhost:8080/EmployeeManager/
	@RequestMapping("/")
	public ModelAndView home() {
		List<Employee> listEmployee = employeeService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listEmployee", listEmployee);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newEmployeeForm(Map<String, Object> model) {
		Employee employee = new Employee();
		model.put("employee", employee);
		return "new_employee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editEmployeeForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_employee");
		Employee employee = employeeService.get(id);
		mav.addObject("employee", employee);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteEmployeeForm(@RequestParam long id) {
		employeeService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Employee> result = employeeService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}
	
	@RequestMapping("/searchByName")
	public ModelAndView searchByName(@RequestParam String keyword) {
		List<Employee> result = employeeService.searchByNameCutomQuery(keyword);
		ModelAndView mav = new ModelAndView("searchByName");
		mav.addObject("result", result);		
		return mav;		
	}
	
	//http://localhost:8080/EmployeeManager/findByAddress?keyword=bsk
	@RequestMapping("/findByAddress")
	public ModelAndView findByAddress(@RequestParam String keyword) {
		List<Employee> result = employeeService.findByAddress(keyword);
		ModelAndView mav = new ModelAndView("searchByName");
		mav.addObject("result", result);		
		return mav;		
	}
	
	@RequestMapping("/findByEmail")
	public ModelAndView findByEmailCustomQuery(@RequestParam String keyword) {
		List<Employee> result = employeeService.findByEmailCustomQuery(keyword);
		ModelAndView mav = new ModelAndView("searchByName");
		mav.addObject("result", result);		
		return mav;		
	}
}
