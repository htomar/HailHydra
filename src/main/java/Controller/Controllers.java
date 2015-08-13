package Controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.hydra.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ServiceImpl.ChangeStatusImpl;
import ServiceImpl.LoginImpl;
import ServiceImpl.SignUpServiceImpl;
import ServiceImpl.UserDetailsImpl;
import dao.EmployeePojo;

@Controller
@RequestMapping("/")
public class Controllers {

	@Autowired
	private LoginImpl loginImpl;
	
	@Autowired
	private SignUpServiceImpl signUpServiceImpl;
	
	@Autowired
	private UserDetailsImpl userDetailsImpl;
	
	@Autowired
	private ChangeStatusImpl changeStatusImpl;

	@Autowired
    private UserRepository userRepository;

    public void setRepository(UserRepository userRepository) {
			this.userRepository = userRepository;
		}

   
	
//	@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET })
//	public String indexPage(ModelMap model) {
//		return "index";
//	}
    
    @RequestMapping("/openSignUp")
	public String opensignUpPage(){
    	System.out.println("check");
  
    	return "signUp";
    }

	@RequestMapping(value = { "/login" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String createLogin(ModelMap model,ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		String username = request.getParameter("user");
		String password=request.getParameter("pass");
		String check;
//		String check = loginImpl.validate(username,password);
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
		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo = userDetailsImpl.getDetails(username);
		model.addAttribute("employee", employeePojo);
		return "loginsuccesspage";
		}
		else
			return "loginfailurepage";
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
//		signUpServiceImpl.signUp(user);
		userRepository.save(user);
		return "SignUpPage";
	}
	
	@RequestMapping(value = { "/apply" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String applyForVacation(ModelMap model,ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		String vacationDates = request.getParameter("vacationdates");
		changeStatusImpl.change(vacationDates);
		return "home";
	}
	
	
}
