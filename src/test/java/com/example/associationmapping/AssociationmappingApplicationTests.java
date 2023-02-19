package com.example.associationmapping;

import com.example.associationmapping.entities.*;
import com.example.associationmapping.repos.CustomerRepository;
import com.example.associationmapping.repos.LicenseRepository;
import com.example.associationmapping.repos.ProgrammerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class AssociationmappingApplicationTests {

	@Autowired
	CustomerRepository repository;
	@Autowired
	ProgrammerRepository programmerRepository;
	@Autowired
	LicenseRepository licenseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreateCustomer()
	{
		Customer customer = new Customer();
		customer.setName("Ashish");
		//HashSet<PhoneNumber> numbers=new HashSet<>();
		PhoneNumber number1 = new PhoneNumber();
		number1.setNumber("1234567890");
		number1.setType("cell");
		//number1.setCustomer(customer);
		//numbers.add(number1);

		PhoneNumber number2 = new PhoneNumber();
		number2.setNumber("0987654321");
		number2.setType("home");
		//number2.setCustomer(customer);
		//numbers.add(number2);

		//customer.setNumbers(numbers);

		// better way to handle foreign key
		customer.addPhoneNumber(number1);
		customer.addPhoneNumber(number2);
		repository.save(customer);
	}

	@Test
	@Transactional
	public void testLoadCustomer()
	{
		Customer customer = repository.findById(4L).get();
		System.out.println(customer.getName());

		Set<PhoneNumber> numbers=customer.getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));
	}

	@Test
	public void testUpdateCustomer()
	{
		Customer customer = repository.findById(4L).get();
		customer.setName("Ashish Gupta");

		Set<PhoneNumber> numbers=customer.getNumbers();
		numbers.forEach(number -> number.setType("cell"));
		repository.save(customer);
	}

	@Test
	public void testDelete()
	{
		repository.deleteById(4L);
	}

	@Test
	public void testMtoMCreateProgrammer()
	{
		Programmer programmer=new Programmer();
		programmer.setName("Ashish");
		programmer.setSalary(50000);

		HashSet<Project> projects=new HashSet<>();

		Project project=new Project();
		project.setName("Java");
		projects.add(project);

		programmer.setProjects(projects);
		programmerRepository.save(programmer);
	}

	@Test
	//@Transactional
	public void testMtoMFindProgrammer()
	{
		Programmer programmer=programmerRepository.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}

	@Test
	public void testOtoOCreateLicense()
	{
		License license=new License();
		license.setType("Car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		Person person=new Person();
		person.setFirstName("Ashish");
		person.setLastName("Gupta");
		person.setAge(22);

		license.setPerson(person);
		licenseRepository.save(license);
	}

}
