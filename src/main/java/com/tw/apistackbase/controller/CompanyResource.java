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

import com.tw.apistackbase.domin.Company;
import com.tw.apistackbase.domin.Employee;

@RestController
@RequestMapping("/companies")
public class CompanyResource { 
	List<Company> companys = new ArrayList<Company>();
	List<Employee> employees = new ArrayList<Employee>();

	@GetMapping(path = "/")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> getCompanys() {
		return companys;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Company> getOneCompany(@PathVariable int id) {
		for (Company company : companys) {
			if (company.getId() == (id)) {
				return ResponseEntity.ok(company);
			}
		}
		return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/{id}/employees")
	public ResponseEntity<List<Employee>> getOneCompanyEmployees(@PathVariable int id) {
		for (Company company : companys) {
			if (company.getId() == (id)) {
				return ResponseEntity.ok(company.getEmployees());
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/employees")
	public ResponseEntity<List<Company>> getPages(@RequestParam int page, @RequestParam int pageSize) {
		List<Company> tempCompany = new ArrayList<>();
		for (int i = page; i < pageSize; i++) {
			tempCompany.add(companys.get(i));
			return ResponseEntity.ok(tempCompany);
			//return ResponseEntity.ok(companys.subList(page, pageSize));
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "/")
	@ResponseStatus(HttpStatus.CREATED)
	public Company createCompany(@RequestBody Company company) {
		companys.add(company);
		return company;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable int id) {
		for (Company company1 : companys) {
			if (company.getId() == (id)) {
				company1.setId(company.getId());
				company1.setCompanyName(company.getCompanyName());
				company1.setEmployeesNumber(company.getEmployeesNumber());
				company1.setEmployees(company.getEmployees());
			}
			return ResponseEntity.ok(company1);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Company> deleteEmployee(@PathVariable int id) {
		for (Company company1 : companys) {
			if (company1.getId() == (id)) {
				companys.remove(company1);
			}
			return ResponseEntity.ok(company1);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
