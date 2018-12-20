package com.peppy.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

	@Autowired
	private RegisterDAO data;

	public boolean saveToDB(NewRegistration reg) {

		return data.addToDB(reg);

	}
}
