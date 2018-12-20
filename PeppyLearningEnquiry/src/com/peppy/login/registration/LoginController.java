package com.peppy.login.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/Welcome")
	public void getRegistration() {
		System.out.println("Registraion called");
	}
}
