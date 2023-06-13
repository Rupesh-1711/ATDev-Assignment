package com.sutdent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutdent.exception.StudentException;
import com.sutdent.model.Student;
import com.sutdent.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo sRepo;

	@Override
	public List<Student> getAllStudents() throws StudentException {
		// get all list of students
		List<Student> allStudents = sRepo.findAll();
		if (allStudents.size() == 0) {
			throw new StudentException("Studetns not Found !");
		}

		return allStudents;
	}

	@Override
	public Student getStudentById(Integer StudentId) throws StudentException {
		// get student by id
		Student student = sRepo.findById(StudentId).orElseThrow(() -> new StudentException("Student not forund "));

		return student;
	}

	@Override
	public Student addStudent(Student student) throws StudentException {

		Student std = sRepo.findByContact(student.getContact());
		Student std2 = sRepo.findByEmail(student.getEmail());
		// checking student mobile present or not
		if (std != null) {
			throw new StudentException("Studetn already Present with this mobile number !");
		}
		// checking student email present or not
		if (std2 != null) {
			throw new StudentException("Studetn already Present with this Email number !");
		}

		//save student in db
		Student SavedStudent = sRepo.save(student);

		return SavedStudent;
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {

		Student std = sRepo.findById(student.getStudentId())
				.orElseThrow(() -> new StudentException("Student not found with id : " + student.getStudentId()));

		//update Student 
		Student updatedStudetn = sRepo.save(student);
		return updatedStudetn;
	}

	@Override
	public String deleteStudentbyId(Integer studentId) throws StudentException {
		Student std = sRepo.findById(studentId)
				.orElseThrow(() -> new StudentException("Student not found with id : " + studentId));
		
		//Delete student by id
		sRepo.delete(std);
		return "Successfuly deleted student with id :" + studentId;
	}

}
