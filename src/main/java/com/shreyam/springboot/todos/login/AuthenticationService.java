package com.shreyam.springboot.todos.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String uname, String pass)
	{
		return uname.equalsIgnoreCase("shreyam") && pass.equalsIgnoreCase("pass");
	}
	
}
