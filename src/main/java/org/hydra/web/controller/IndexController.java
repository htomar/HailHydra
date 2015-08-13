package org.hydra.web.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hydra.mongodb.model.User;
import org.hydra.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

	private static final String PATH = "/error";
	@Autowired
    private UserRepository userRepository;

    public void setRepository(UserRepository userRepository) {
			this.userRepository = userRepository;
		}

   
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}

	@RequestMapping(value = PATH)
	public String error() {
		return "error";
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
	  @RequestMapping("/openSignUp")
		public String opensignUpPage(){
	    	System.out.println("check");
	  
	    	return "signUp";
	    }
	  
	  @RequestMapping("/loginPage")
		public String openLoginPage(){
	    	return "LoginPage";
	    }
	  
	  @RequestMapping("/signup" )
		public String createSignUP(ModelMap model,ServletRequest servletRequest) {
			HttpServletRequest request = (HttpServletRequest)servletRequest;
			org.hydra.mongodb.model.User user = new org.hydra.mongodb.model.User();
			
			user.setOracleID(request.getParameter("oid"));
			user.setLogonID(request.getParameter("LogonId"));
			user.setEmailID(request.getParameter("emailid"));
			user.setPassword(request.getParameter("password"));
			user.setDesignation(request.getParameter("designation"));
//			signUpServiceImpl.signUp(user);
			userRepository.save(user);
			User user1 = userRepository.findByEmailID("a@g.com");
			System.out.println(user1.getLogonID());
			return "HomePage";
		}
	  
		@RequestMapping(value = { "/login" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		public String createLogin(ModelMap model,ServletRequest servletRequest) {
			HttpServletRequest request = (HttpServletRequest)servletRequest;
			String username = request.getParameter("emailid");
			String password=request.getParameter("password");
//			String username = "a1@g.com";
//			String password = "check";
			String check;
//			String check = loginImpl.validate(username,password);
			org.hydra.mongodb.model.User user = new org.hydra.mongodb.model.User();
				user = userRepository.findByEmailID(username);
			if(user.getEmailID().equals(username)){
				if(user.getPassword().equals(password))
					check = "Loggedin";
				else
					check = "PleaseCheckYourPassrod";
			}
			
			else
				check = "username doesn't exist";
			
			model.addAttribute("check", check);
			if(check.equals("Loggedin")){
//			EmployeePojo employeePojo = new EmployeePojo();
//			employeePojo = userDetailsImpl.getDetails(username);
//			model.addAttribute("employee", employeePojo);
				return "loginsuccesspage";
			}
			else
				return "error";
		}
		
		@RequestMapping(value = { "/logout" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
		public String manualLogout(HttpServletRequest request, HttpServletResponse response)
		{ 
			request.getSession().invalidate();
			return "index";
		}
}
