package com.peppy.login;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class RegisterDAO {

	@Autowired
	private SessionFactory session;

	public boolean addToDB(NewRegistration registraion) {
		
		session.getCurrentSession().save(registraion);
		return true;
	}
	

}
