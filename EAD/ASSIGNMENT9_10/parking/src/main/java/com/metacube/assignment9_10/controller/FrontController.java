package com.metacube.assignment9_10.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.metacube.assignment9_10.model.Employee;
import com.metacube.assignment9_10.model.EmployeeAllDetails;
import com.metacube.assignment9_10.model.EmployeeVehicle;
import com.metacube.assignment9_10.model.Friends;
import com.metacube.assignment9_10.service.impl.EmployeeService;

/**
 * @author krishan
 * FrontController is a Controller class to handle requests of web pages
 *
 */
@Controller
public class FrontController
{
	@Autowired
	Employee emp;
	@Autowired
	EmployeeVehicle employeeVehicle;
	@Autowired
	EmployeeService empService;
	Logger logger = LoggerFactory.getLogger(FrontController.class);

	/**
	 * @return index page with model attribute Employee
	 */
	@GetMapping("/index")
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView = new ModelAndView("index", "Employee", emp);
		return modelAndView;
	}

	/**
	 * @param recievedParam
	 * @return vehicleRegister page with model attribute EmployeeVehicle if employee details are successfully inserted in database else return to index page
	 */
	@PostMapping("/vehicleRegister")
	public ModelAndView vehicleRegister(@ModelAttribute Employee recievedParam)
	{
		try
		{
			boolean result = empService.setEmployeeToDb(recievedParam);
			if (result == true)
			{
				ModelAndView modelAndView = new ModelAndView("vehicleRegister", "EmployeeVehicle", employeeVehicle);
				return modelAndView;
			}
			else
			{
				ModelAndView modelAndView = new ModelAndView("index", "Employee", emp);
				return modelAndView;
			}
		}
		catch (Exception e)
		{
			logger.info("Exception Occured at vehicleRegister Request");
			ModelAndView modelAndView = new ModelAndView("index");
			return modelAndView;
		}
	}

	/**
	 * @param employeeVehicle
	 * @return
	 */
	/**
	 * @param employeeVehicle
	 * @return login page if successfully insert vehicle details to the database else return to index page
	 */
	@PostMapping("/vehicleDetailsToDb")
	public String vehicleDetailsToDb(@ModelAttribute EmployeeVehicle employeeVehicle)
	{
		try
		{
			if (empService.setEmployeeVehicleToDb(employeeVehicle))
			{
				return "login";
			}
			else
				return "index";
		}
		catch (Exception e)
		{
			logger.info("Exception Occured at CheckLoging Request");
			return "index";
		}
	}

	/**
	 * @return
	 */
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}

	/**
	 * @param email
	 * @param pass
	 * @param request
	 * @return redirect to home if user exist else return to login page
	 */
	@PostMapping("/checkLogin")
	public String home(@RequestParam("empEmail") String email, @RequestParam("empPassword") String pass, HttpServletRequest request)
	{
		try
		{

			HttpSession session;
			boolean result = empService.checkLogin(email, pass);
			if (result)
			{
				session = request.getSession();
				session.setAttribute("EmployeeEmail", email);
				session.setAttribute("EmployeePass", pass);
				return "redirect:/redirectToHome";
			}
			else
			{
				return "login";
			}
		}
		catch (Exception e)
		{

			logger.info("Exception Occured at CheckLogin Request");
			return "login";
		}

	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("redirectToHome")
	public ModelAndView redirectToHome(HttpServletRequest request)
	{
		ModelAndView modelAndView = null;
		try
		{
			HttpSession session = request.getSession(false);
			String email = (String) session.getAttribute("EmployeeEmail");
			String pass = (String) session.getAttribute("EmployeePass");
			List<String> list = (List<String>) empService.getEmployeeDetails(email, pass);
			session.setAttribute("EmployeeData", list);
			int id = Integer.parseInt(list.get(9));

			session.setAttribute("EmployeeId", id);
			modelAndView = new ModelAndView("EmployeeDetails", "list", list);
		}
		catch (Exception e)
		{
			logger.info("Exception Occured at retirectToHome request");
		}
		return modelAndView;
	}

	/**
	 * @param request
	 * @return EmployeeDetails page with model attribute list if session is available else return to login page
	 */
	@PostMapping("/EmployeeHome")
	public ModelAndView home(HttpServletRequest request)
	{
		HttpSession session;
		try
		{
			session = request.getSession(false);
			if (session != null)
			{

				List<String> list = (List<String>) session.getAttribute("EmployeeData");
				ModelAndView modelAndView = new ModelAndView("EmployeeDetails", "list", list);
				modelAndView.addObject(session);
				return modelAndView;
			}
			else
			{
				ModelAndView modelAndView = new ModelAndView("login");
				return modelAndView;
			}
		}
		catch (Exception e)
		{

			logger.info("Exception Occured at EmployeeHome Request");
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}

	}

	/**
	 * @param request
	 * @return friends page with model attribute friends if session is available else redirect to EmployeeHome
	 */
	@GetMapping("/friends")
	public ModelAndView friendsPage(HttpServletRequest request)
	{
		try
		{
			HttpSession session = request.getSession(false);
			if (session != null)
			{

				List<String> list = (List<String>) session.getAttribute("EmployeeData");
				String organization = list.get(4);
				int id = Integer.parseInt(list.get(9));
				List<Friends> friends = empService.getAllFriends(organization, id);
				if (friends != null)
				{
					session.setAttribute("Allfriends", friends);
					ModelAndView modelAndView = new ModelAndView("friends", "friends", friends);
					return modelAndView;
				}
				else
				{
					ModelAndView modelAndView = new ModelAndView("redirect:/EmployeeHome");
					return modelAndView;

				}
			}
			else
			{
				ModelAndView modelAndView = new ModelAndView("login");
				return modelAndView;
			}
		}
		catch (Exception e)
		{
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}

	}

	/**
	 * @param id
	 * @param request
	 * @return friendDetail page and attach model attribute friendData if session is available else redirect to EmployeeHome
	 */
	@GetMapping("/friendsData")
	public ModelAndView getFriendsData(@RequestParam("id") String id, HttpServletRequest request)
	{
		try
		{
			HttpSession session = request.getSession(false);
			if (session != null)
			{

				Friends friendData = null;
				int friendId = Integer.parseInt(id);
				List<Friends> friends = (List<Friends>) session.getAttribute("Allfriends");
				for (Friends f : friends)
				{
					if (f.getE().getEmpId() == friendId)
					{
						friendData = f;
						break;
					}
				}
				ModelAndView modelAndView = new ModelAndView("friendDetail", "friendData", friendData);
				return modelAndView;
			}
			else
			{
				ModelAndView modelAndView = new ModelAndView("redirect:/EmployeeHome");
				return modelAndView;
			}
		}
		catch (Exception e)
		{
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}
	}

	/**
	 * @param request
	 * @return updateEmployeeDetails page if session is available and attach model attributes empData and EmpUpdateDetails else redirect to login page
	 */
	@PostMapping("/UpdateEmployee")
	public ModelAndView updateEmployeeDetails(HttpServletRequest request)
	{
		HttpSession session;
		EmployeeAllDetails empData = new EmployeeAllDetails();
		try
		{
			session = request.getSession(false);

			if (session != null)
			{

				List<String> list = (List<String>) session.getAttribute("EmployeeData");
				ModelAndView modelAndView = new ModelAndView("updateEmployeeDetails");

				modelAndView.addObject("empData", empData);
				modelAndView.addObject("EmpUpdateDetails", list);

				return modelAndView;
			}
			else
			{
				throw new Exception();
			}
		}
		catch (Exception e)
		{
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
		}
	}

	/**
	 * @param data
	 * @param req
	 * @return redirectToHome page if successfully updates the data else return UpdateEmployee
	 */
	@PostMapping("/updateEmployeeResult")
	public String updateEmployeeResult(@ModelAttribute EmployeeAllDetails data, HttpServletRequest req)
	{

		try
		{
			if (data != null && data.getEmpName() != null && data.getEmpContact() != null && data.getEmpGender() != null
					&& data.getVehicleName() != null)
			{
				HttpSession session = req.getSession(false);
				int id = (int) session.getAttribute("EmployeeId");

				if (empService.updateEmployee(data, id))
				{
					return "redirect:/redirectToHome";
				}
				else
				{
					return "redirect:/redirectToHome";
				}
			}
			else
			{
				throw new Exception();
			}
		}

		catch (Exception e)
		{

			logger.info("couldn't update Employee details");
			return "redirect:/redirectToHome";
		}

	}

	/**
	 * @param request
	 * @return index page if successfully log out and destroys the session else return index page
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		try
		{
			HttpSession session = request.getSession(false);
			if (session != null)
			{
				session.invalidate();
				return "login";
			}
			else
			{
				throw new Exception();
			}
		}

		catch (Exception e)
		{

			logger.info("you can't hit logout from url");
			return "index";
		}
	}

}
