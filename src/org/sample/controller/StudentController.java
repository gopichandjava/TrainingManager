package org.sample.controller;

import org.sample.model.StudentDetails;
import org.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	 private StudentService studentService;
     
	  @Autowired(required=true)
	    @Qualifier(value="studentService")
	    public void setStudentService(StudentService ps){
	        this.studentService = ps;
	    }
	     
	    @RequestMapping(value = "/students", method = RequestMethod.GET)
	    public String listStudents(Model model) {
	        model.addAttribute("student", new StudentDetails());
	        model.addAttribute("listStudents", this.studentService.listStudents());
	        return "addstudent";
	    }
	     
	    //For add and update student both
	    @RequestMapping(value= "/student/add", method = RequestMethod.POST)
	    public String addStudent(@ModelAttribute("student") StudentDetails student){
	         
	        if(student.getUserId() == 0){
	            //new student, add it
	            this.studentService.addStudent(student);
	        }else{
	            //existing student, call update
	            this.studentService.updateStudent(student);
	        }
	         
	        return "redirect:/students";
	         
	    }
	     
	    @RequestMapping("/remove/{id}")
	    public String removeStudents(@PathVariable("id") int id){
	         
	        this.studentService.removeStudent(id);
	        return "redirect:/students";
	    }
	  
	    @RequestMapping("/edit/{id}")
	    public String editPerson(@PathVariable("id") int id, Model model){
	        model.addAttribute("student", this.studentService.getStudentById(id));
	        model.addAttribute("listStudents", this.studentService.listStudents());
	        return "addstudent";
	    }

}
