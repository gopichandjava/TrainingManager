package org.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String lastname;
	private String firstname;
	private String course;
	
	@Transient
	private String SelectedCourse;
	
	public String getSelectedCourse() {
		return SelectedCourse;
	}
	public void setSelectedCourse(String selectedCourse) {
		SelectedCourse = selectedCourse;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
}
