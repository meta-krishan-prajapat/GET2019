package com.metacube.assignment8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.metacube.assignment8.model.Student;
import com.metacube.assignment8.service.StudentService;

/**
 * @author krishan
 * Front Controller for spring mvc
 *
 */
@Controller
public class ApplicationController
{
	@Value("${home.message}")
	private String message;

	@Autowired
	StudentService studentService;

	/**
	 * @param model
	 * @return index view
	 */
	@GetMapping("/home")
	public String displayIndex(Model model)
	{
		model.addAttribute("message", message);
		return "index";
	}

	/**
	 * @return addStudentDetail view with backing bean
	 */
	@GetMapping("/addStudentDetail")
	public ModelAndView addStudentMapping()
	{
		return new ModelAndView("addStudentDetail", "student", new Student());
	}

	/**
	 * @param student
	 * @param result
	 * @return addStudentDetail view if error occurs in binding result else return index view
	 */
	@PostMapping("/addStudent")
	public String displayToLogger(@Validated @ModelAttribute("student") Student student, BindingResult result)
	{
		if (result.hasErrors())
		{
			ObjectError objectError = new ObjectError("global_error", "details must not be blank");
			result.addError(objectError);
			return "addStudentDetail";
		}
		else
		{
			studentService.addStudent(student);
			return "index";
		}
	}

	/**
	 * @return displayAllStudent view with attached list of students
	 */
	@GetMapping("/showStudents")
	public ModelAndView displayAllStudents()
	{
		List<Student> allStudents = studentService.getAllStudent();
//		ModelAndView map = new ModelAndView("displayAllStudent");
//		map.addObject("lists", allStudents);
//		return map;
		return new ModelAndView("displayAllStudent", "lists", allStudents);
	}

}
