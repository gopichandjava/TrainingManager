package org.sample.dao;


import org.sample.model.StudentDetails;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	
	@Override
	public void addStudent(StudentDetails s) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(s);
        logger.info("Student saved successfully, Student Details="+s);
		
	}

	@Override
	public void updateStudent(StudentDetails s) {
		// TODO Auto-generated method stub
		 Session session = this.sessionFactory.getCurrentSession();
	        session.update(s);
	        logger.info("Student updated successfully, Student Details="+s);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StudentDetails> listStudents() {
		 Session session = this.sessionFactory.getCurrentSession();
	        List<StudentDetails> studentsList = session.createQuery("from StudentDetails").list();
	        for(StudentDetails p : studentsList){
	            logger.info("Student List::"+p);
	        }
	        return studentsList;
	}

	@Override
	public StudentDetails getStudentById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();      
        StudentDetails p = (StudentDetails) session.load(StudentDetails.class, new Integer(id));
        logger.info("student loaded successfully, student details="+p);
        return p;
	}

	@Override
	public void removeStudent(int id) {
		// TODO Auto-generated method stub

		 Session session = this.sessionFactory.getCurrentSession();
	        StudentDetails student = (StudentDetails) session.load(StudentDetails.class, new Integer(id));
	        if(null != student){
	            session.delete(student);
	        }
	        logger.info("student deleted successfully, student details="+student);
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<StudentDetails> selectStudentsByCourse(String selectedCourse) {
		// TODO Auto-generated method stub
		 Session session = this.sessionFactory.getCurrentSession();
	        Query query = (Query) session.createQuery("from StudentDetails where course = :selectedcourse");
	        query.setParameter("selectedcourse", selectedCourse);
	        
	        List<StudentDetails> studentsList = query.list();
	        for(StudentDetails p : studentsList){
	            logger.info("Student List::"+p);
	        }
	        return studentsList;

		
	}


}