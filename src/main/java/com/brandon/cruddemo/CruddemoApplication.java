package com.brandon.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.brandon.cruddemo.dao.StudentDAO;
import com.brandon.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// Student theStudent = studentDAO.findById(1);
			// Student stud = studentDAO.findById(1);
			// stud.setEmail("thisEmailHasBeenUpdated@test.com");
			// studentDAO.update(stud);
			// System.out.println(studentDAO.findById(1));
			System.out.println(studentDAO.delete(2));
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Brandon", "Browns", "test@gmail.com");
		
		// use the DAO to save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
