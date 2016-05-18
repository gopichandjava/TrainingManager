package org.sample.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("student")
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
	        initModelList(model);
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
	        
	      // student = new StudentDetails();
	         
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
	    
	    
	    @RequestMapping("/selectcourse")
	    public String selectCourse(@ModelAttribute("student") StudentDetails student, Model model){
	       model.addAttribute("student", new StudentDetails());
	       model.addAttribute("listStudents", this.studentService.selectStudentsByCourse(student.getSelectedCourse()));
	       initModelList(model);
	    	// this.studentService.selectStudentsByCourse(student.getSelectedCourse());
	        return "addstudent";
	    }
	    
//	    @RequestMapping("/selectcourseresult")
//	    public String selectCourseResult(Model model){
//	        model.addAttribute("student", new StudentDetails());
//	        model.addAttribute("listStudents", this.studentService.selectStudentsByCourse(null));
//	    	
//	    	
//	        return "addstudent";
//	    }
	    
	    
	    @RequestMapping(value="/addstudent")
		public String addstudent(Model model)
		{
			model.addAttribute("student", new StudentDetails());
			initModelList(model);
			System.out.println();
			return "addstudent";
		}
	    private void initModelList(Model model) {
	          List<String> courseList = new ArrayList<String>();
	  
	          courseList.add("java");
	  
	          courseList.add("j2ee");
	  
	          courseList.add(".net");
	  
	          courseList.add("hadoop");
	  
	          courseList.add("ui");
	  
	          model.addAttribute("courselist", courseList);
	          
	          System.out.println(courseList);
	 
	      }

}
