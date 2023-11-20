package com.library.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.StudentDto;
import com.library.entities.Student;
import com.library.repositories.StudentRepository;
import com.library.service.StudentService;
@Service
public class StudentServiceImpl implements  StudentService{

	@Autowired
	StudentRepository sr;
	
	@Override
	//create student
	public Student createStudent(StudentDto st) {
		 Student s= Student.builder()
		    		.sName(st.getSName())
		    		.sEmail(st.getSEmail())
		    		.sContact(st.getSContact())
		    		.sBook(st.getSBook())
		    		.build();
		return sr.save(s);
	}

	@Override
	//get the student by id 
	public Student getStudent(int sId) {
		return sr.findById(sId).get();
	}

	@Override
	// get all Student list
	public List<Student> getAllStudents() {
		return sr.findAll();
	}

	@Override
	//delete student by id 
	public String deleteStudent(int sId) {
		sr.deleteById(sId);
		return "Record deleted successfully..";
	}

	@Override
	public String updateStudent(int sId, Student st) {
		Student s=sr.findById(sId).get();
		s.setSName(st.getSName());
		s.setSContact(st.getSContact());
		s.setSEmail(st.getSEmail());
		s.setSBook(st.getSBook());
		sr.save(s);
		return "Resord updated successfully...";
	}
	

}
