package com.metacube.Student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.metacube.Student.model.Student;
import com.metacube.Student.utils.UseDAO;

/**
 * @author krishan
 * Controller
 *
 */
@Controller
public class StudentController
{

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
			System.out.println(UseDAO.getInstance().add(student));
			return "redirect:/home";
		}
	}

	/**
	 * Get Mapping to show student
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/ShowStudent")
	public String showStudent(Model model)
	{
		List<Student> students = UseDAO.getInstance().getAll();
		model.addAttribute("students", students);
		return "showStudent";
	}

	/**
	 * get Mapping for Login
	 * @param error parameter
	 * @param model to pass values to view
	 * @return name of view
	 */
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model)
	{
		if (error != null)
		{
			model.addAttribute("errorMsg", "Authentication Failed");
		}

		return "login";
	}
}