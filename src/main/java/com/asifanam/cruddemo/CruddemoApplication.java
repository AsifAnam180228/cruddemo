package com.asifanam.cruddemo;

import com.asifanam.cruddemo.dao.StudentDAO;
import com.asifanam.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted rows: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
//		Student student = studentDAO.findById(studentId);
		//delete the student
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
		//display the updated student

	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key

		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student student = studentDAO.findById(studentId);

		//change first name to ""
		System.out.println("Updating student");
		student.setFirstName("John");
		student.setLastName("Doo");

		//update the student
		studentDAO.update(student);

		//display the updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		//display list of students
		for(Student student: theStudents){
			System.out.println(student);
		}
	}


	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for (Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object.......");
		Student tempStudent = new Student("Chad", "Darby", "chad@asifanam.com");

		//save student
		System.out.println("Saving the student...........");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);
		//display student
		System.out.println("Found the student: "+ myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating 3 student objects........");
		Student tempStudent1 = new Student("John", "Doe", "john@asifanam.com");
		Student tempStudent2 = new Student("Mary", "Public", "public@asifanam.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@asifanam.com");

		//save the student object
		System.out.println("Saving the students........");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object........");
		Student tempStudent = new Student("Paul", "Doe", "paul@asifanam.com");
		//save the student object
		System.out.println("Saving the student...........");
		studentDAO.save(tempStudent);
		//display id of  the saved object
		System.out.println("Saved student. Generated id: "+ tempStudent.getId());

	}

}
