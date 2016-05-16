package org.sample.service;

import java.util.List;
import org.sample.dao.StudentDAO;
import org.sample.model.StudentDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	private  StudentDAO studentDAO;
	 
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
	
	
	@Override
	@Transactional
	public void addStudent(StudentDetails s) {
		// TODO Auto-generated method stub
		 this.studentDAO.addStudent(s);
		
	}

	@Override
	@Transactional
	public void updateStudent(StudentDetails s) {
		// TODO Auto-generated method stub
		this.studentDAO.updateStudent(s);
		
	}

	@Override
	@Transactional
	public List<StudentDetails> listStudents() {
		// TODO Auto-generated method stub
		return this.studentDAO.listStudents();
		
	}

	@Override
	@Transactional
	public StudentDetails getStudentById(int id) {
		// TODO Auto-generated method stub
		 return this.studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		// TODO Auto-generated method stub
		 this.studentDAO.removeStudent(id);
	}

}
