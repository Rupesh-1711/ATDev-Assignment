package com.sutdent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutdent.exception.StudentException;
import com.sutdent.model.Student;
import com.sutdent.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService sService;

	//For adding the sudent
	@PostMapping("/add")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student) throws StudentException {

		Student addedStudent = sService.addStudent(student);
		return new ResponseEntity<Student>(addedStudent, HttpStatus.OK);
	}

	//for getting all list of students 
	@GetMapping("/allstudent")
	ResponseEntity<List<Student>> getAllStudents() throws StudentException {
		List<Student> allStudents = sService.getAllStudents();
		return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}

	//get student by id
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Integer StudentId) throws StudentException {
		Student student = sService.getStudentById(StudentId);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	//update data of student
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentException {
          Student updatedStudent = sService.updateStudent(student);
		return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
	}

	//Delete student by id
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudentbyId(@PathVariable("studentId")Integer studentId) throws StudentException {
		String message = sService.deleteStudentbyId(studentId);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
