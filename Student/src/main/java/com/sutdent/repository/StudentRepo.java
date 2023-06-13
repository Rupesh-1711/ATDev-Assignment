package com.sutdent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutdent.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

	Student findByContact(String contact);

	Student findByEmail(String email);

}
