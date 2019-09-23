package com.metacube.Student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.Student.model.Search;
import com.metacube.Student.model.Student;
import com.metacube.Student.service.StudentService;

/**
 * @author krishan
 *Controller
 */
@Controller
public class StudentController
{

	@Autowired
	private StudentService service;

	@Value("${home.message}")
	private String message;

	/**
	 * Mapping for home page
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("message", message);
		return "home";
	}

	/**
	 * Get Mapping for Student Detail page
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/StudentDetail")
	public String studentDetail(Model model)
	{
		model.addAttribute(new Student());
		return "StudentDetail";
	}

	/**
	 * Post Mapping for Student Detail page
	 * @param student to be validated
	 * @param bindingResult contains errors
	 * @return name of view
	 */
	@PostMapping("/StudentDetail")
	public String addStudentDetail(@Validated Student student, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return "StudentDetail";
		}
		else
		{
			service.add(student);
			return "redirect:/home";
		}
	}

	/**
	 * Get Mapping to show student
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/showStudent")
	public String showStudent(Model model)
	{
		List<Student> students = service.getAll();
		model.addAttribute("students", students);
		return "showStudent";
	}

	/**
	 * Get Mapping to search student
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/SearchStudent")
	public String searchStudent(Model model)
	{
		model.addAttribute(new Search());
		return "searchStudent";
	}

	/**
	 * Post Mapping to search student
	 * @param search 
	 * @param bindingResult
	 * @param model
	 * @return name of view
	 */
	@PostMapping("/SearchStudent")
	public String doSearch(@Validated Search search, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors())
		{
			return "searchStudent";
		}
		else
		{
			List<Student> student = service.get(search.getKey());
			model.addAttribute("students", student);
			return "/showStudent";
		}
	}
}