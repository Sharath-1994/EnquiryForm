package com.peppy.login.registration;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peppy.login.NewRegistration;

@Repository
@Transactional
public class LoginDAO {

	@Autowired
	private SessionFactory factory;

	public boolean checkWithDB(NewRegistration regObj) {

		String sqlEmailIDQuery = "Select registration.email_id from registration where registration.email_id = :eid";

		Query<?> eQuery = factory.getCurrentSession().createNativeQuery(sqlEmailIDQuery).setParameter("eid",
				regObj.getEmailId());

		String emailQueryResult = null;

		try {
			emailQueryResult = (String) eQuery.getSingleResult().toString();
		} catch (NoResultException ex) {
			System.out.println(ex.getLocalizedMessage());
			return false;
		}


		String sqlPasswordQuery = "Select password from registration where registration.email_id = :emailId";
		Query<?> passQuery = factory.getCurrentSession().createNativeQuery(sqlPasswordQuery).setParameter("emailId",regObj.getEmailId());

		String passWordResult = null;
		try {
			passWordResult = (String) passQuery.getSingleResult().toString();
		} catch (NoResultException ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		
		System.out.println("Password is " + passWordResult + " & Email is " + emailQueryResult);

		if (regObj.getEmailId().equals(emailQueryResult) && regObj.getPassword().equals(passWordResult)) {
			System.out.println("Matches");
			return true;

		} else {
			System.out.println("Email not valid. Kindly check");
		}
		return true;

	}

}
