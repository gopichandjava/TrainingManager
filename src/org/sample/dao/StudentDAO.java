package org.sample.dao;

import java.util.List;

import org.sample.model.StudentDetails;

public interface StudentDAO {

	 public void addStudent(StudentDetails s);
	    public void updateStudent(StudentDetails s);
	    public List<StudentDetails> listStudents();
	    public StudentDetails getStudentById(int id);
	    public void removeStudent(int id);
		public List<StudentDetails> selectStudentsByCourse(String selectedCourse);
	
}
