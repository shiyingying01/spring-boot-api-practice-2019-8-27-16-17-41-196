package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tw.apistackbase.domin.Employee;

@RestController
@RequestMapping("/employees")

//GET /employees #获取员工名单
//GET / employees / 1＃获得某个特定员工
//GET / employees?page=1＆pageSize=5  #分页查询，page等于1，pageSize等于5
//GET /employees?gender=male #查询所有男性员工
//POST / employees＃添加一名员工
//PUT / employees / 1 #update一名员工
//DELETE / employees / 1 #delete一名员工
public class EmployeeResource {
	List<Employee> employees = new ArrayList<Employee>();

	@GetMapping(path = "/")
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployees() {
		return employees;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable int id) {
		for (Employee employee : employees) {
			if (employee.getId() == (id)) {
				return ResponseEntity.ok(employee);
			}
		}
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/employeesGender")
	public ResponseEntity<Employee> getOneCompanyEmployees(@PathVariable String gender) {
		for (Employee employee : employees) {
			if (employee.getGender() == (gender)) {
				return ResponseEntity.ok(employee);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}	

	@GetMapping(path = "/employees")
	public ResponseEntity<List<Employee>> getPages(@RequestParam int page, @RequestParam int pageSize) {
		List<Employee> tempEmployee = new ArrayList<>();
		for (int i = page; i < pageSize; i++) {
			tempEmployee.add(employees.get(i));
			return ResponseEntity.ok(tempEmployee);
			//return ResponseEntity.ok(companys.subList(page, pageSize));
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return employee;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		for (Employee employee1 : employees) {
			if (employee.getId() == (id)) {
				employee1.setId(employee.getId());
				employee1.setName(employee.getName());
				employee1.setAge(employee.getAge());
				employee1.setGender(employee.getGender());
				employee1.setSalary(employee.getSalary());
			}
			return ResponseEntity.ok(employee1);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		for (Employee employee1 : employees) {
			if (employee1.getId() == (id)) {
				employees.remove(employee1);
			}
			return ResponseEntity.ok(employee1);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
