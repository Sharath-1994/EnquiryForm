package com.peppy.login.registration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peppy.login.NewRegistration;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping("/Welcome")
	public String getRegistration(HttpServletRequest request) {

		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");

		NewRegistration register = new NewRegistration();
		register.setEmailId(userName);
		register.setPassword(passWord);

		boolean result = service.checkUserNamePassword(register);
		if (result == true)
			return "Works";
		else
			return "Does not work";
	}
}
