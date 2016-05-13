package org.sample.service;

public class ValidateCredentials {

	public boolean valiatePassword(String password)
	{
		if(password==null || password.trim()=="")
		{
			return false;
		}
		return true;
	}
	
	
}
