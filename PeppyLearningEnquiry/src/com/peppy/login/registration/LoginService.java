package com.peppy.login.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peppy.login.NewRegistration;

@Service
public class LoginService {

	@Autowired
	private LoginDAO doa;
	
	public boolean checkUserNamePassword(NewRegistration regObj){
		return doa.checkWithDB(regObj);
	}
	
}
