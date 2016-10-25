package com.ars.pro1.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ars.pro1.model.LoginAdmin;
import com.ars.pro1.service.AdminService;

@Controller

@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(method = RequestMethod.GET)
	public String displayLogin(ModelMap modelMap, HttpSession session,
			HttpServletRequest request) throws SQLException {
		//LoginAdmin loginAdmin = checkCookie(request);
		//if (loginAdmin == null) {
	//		modelMap.put("msg1", "Online Book Store");
		//	modelMap.put("msg2", "Please Sign In");
			modelMap.put("loginAdmin", new LoginAdmin());
			return "login";
		//} else {
		//	if (adminService.isValidUser(loginAdmin.getUsername(),
		//			loginAdmin.getPassword())) {
			//	session.setAttribute("username", loginAdmin.getUsername());
			//	return "adminPanel";
			//}

		//	else {
			//	modelMap.put("error", "Account is Invalid");
			//	return "login";
		//	}
	//	}

	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(
			@ModelAttribute LoginAdmin admin,BindingResult result, Model model,HttpSession session) throws SQLException {

		if (result.hasErrors()) {
		
			return "login";
		}

		boolean userExists = adminService.isValidUser(admin.getUsername(),
				admin.getPassword());
		if (userExists == true) {
			session.setAttribute("adminloggedin", admin);
	/*		if (request.getParameter("remember") != null) {
				Cookie ckUsername = new Cookie("username", admin.getUsername());
				ckUsername.setMaxAge(3600);
				response.addCookie(ckUsername);
				Cookie ckPassword = new Cookie("password", admin.getPassword());
				ckPassword.setMaxAge(3600);
				response.addCookie(ckPassword);
			}*/
			return "adminPanel";
		} else {
		  model.addAttribute("error", "Invalid Account");

			return "redirect:/login";
		}

	}

/*	public LoginAdmin checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		LoginAdmin loginAdmin = null;
		String username = "", password = "";
		for (Cookie ck : cookies) {
			if (ck.getName().equalsIgnoreCase("username"))
				username = ck.getValue();
			if (ck.getName().equalsIgnoreCase("password"))
				password = ck.getValue();
		}
		if (!username.isEmpty() && !password.isEmpty())
			loginAdmin = new LoginAdmin(username, password);

		return loginAdmin;

	}*/

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		session.removeAttribute("adminloggedin");
		/*for (Cookie ck : request.getCookies()) {
			if (ck.getName().equalsIgnoreCase("username")) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
			if (ck.getName().equalsIgnoreCase("password")) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
		}*/
	//	model.addAttribute("loginAdmin", new LoginAdmin());
		return "redirect:/login";
	}
}
