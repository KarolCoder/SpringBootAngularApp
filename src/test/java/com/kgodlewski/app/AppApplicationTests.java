package com.kgodlewski.app;

import com.kgodlewski.app.entities.Customer;
import com.kgodlewski.app.entities.Student;
import com.kgodlewski.app.repositories.CustomerRepository;
import com.kgodlewski.app.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class AppApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
	private CustomerRepository customerRepository;

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("Karol");
        student.setCourse("Spring boot");
        student.setFee(30d);
        studentRepository.save(student);
    }

    @Test
    public void findStudentById() {
        Student student = studentRepository.findById(1L).get();
        System.out.println(student);
    }

    @Test
    public void testUpdateStudent() {
        Student student = studentRepository.findById(1L).get();
        student.setFee(40d);
        studentRepository.save(student);

    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student();
        student.setId(1L);
        studentRepository.delete(student);
    }

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Karol");
		customer.setEmail("KG@gmail.com");
		customerRepository.save(customer);
	}

	@Test
	public void findCustomerById() {
		Customer customer = customerRepository.findById(1L).get();
		System.out.println(customer);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerRepository.findById(1L).get();
		customer.setName("Lukasz");
		customerRepository.save(customer);

	}

	@Test
	public void testDeleteCustomer() {
		Customer customer = new Customer();
		customer.setId(1L);
		customerRepository.delete(customer);
	}

}
