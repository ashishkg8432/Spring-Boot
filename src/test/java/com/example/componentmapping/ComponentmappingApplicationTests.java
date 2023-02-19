package com.example.componentmapping;

import com.example.componentmapping.entities.Address;
import com.example.componentmapping.entities.Employee;
import com.example.componentmapping.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentmappingApplicationTests {
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee employee=new Employee();
		employee.setId(123);
		employee.setName("Ashish");
		Address address=new Address();
		address.setCity("Delhi");
		address.setCountry("India");
		address.setStreetaddress("Dwarka");
		address.setZipcode("110045");
		address.setState("New delhi");
		employee.setAddress(address);
		repository.save(employee);
	}


}
