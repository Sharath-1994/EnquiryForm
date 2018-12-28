package com.peppy.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	@Autowired
	RegisterService service;

	@RequestMapping("/")
	public String homePage() {
		System.out.println("LoginController.homePage()");
		return "home";
	}

	@RequestMapping("/register")
	public String Registration(HttpServletRequest request) {

		String firstName = request.getParameter("First_Name");
		String middleName = request.getParameter("Middle_Name");
		String lastName = request.getParameter("Last_Name");
		String emailId = request.getParameter("Email_Id");
		long mobileNo = Long.parseLong(request.getParameter("Mobile_Number"));
		String password = request.getParameter("Pass_Word");
		String address = request.getParameter("Address");
		System.out.println(mobileNo);
		System.out.println(address);

		NewRegistration registration = new NewRegistration();
		registration.setFirstName(firstName);
		registration.setLastName(lastName);
		registration.setMiddleName(middleName);
		registration.setEmailId(emailId);
		registration.setPhoneNumber(mobileNo);
		registration.setPassword(password);
		registration.setAddress(address);
		service.saveToDB(registration);
		return "RegistrationSucessfull";

	}

}
