package com.shreyam.springboot.todos.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") 
public class LoginController {

	@Autowired
	private AuthenticationService authenticationService; 
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String welcomePage(@RequestParam String name, @RequestParam String pass, ModelMap model) 
	{
		if(authenticationService.authenticate(name, pass))
		{
			model.put("name", name);
			model.put("pass", pass);
			return "welcome";
		}
		else
		{
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
			
		
		
	}
}
