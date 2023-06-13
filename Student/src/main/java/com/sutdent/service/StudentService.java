package com.sutdent.service;

import java.util.List;

import com.sutdent.exception.StudentException;
import com.sutdent.model.Student;

public interface StudentService {

	List<Student> getAllStudents()throws StudentException;
	
	Student getStudentById(Integer StudentId) throws StudentException;
	
	Student addStudent(Student student) throws StudentException;
	
	Student updateStudent(Student student)throws StudentException;
	
	String deleteStudentbyId(Integer studentId)throws StudentException;
	
}
