package ServiceImpl;

import org.hydra.mongodb.model.User;
import org.hydra.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginImpl {


//	@Autowired
//	    private UserRepository userRepository;
//
//	    public void setRepository(UserRepository userRepository) {
//			this.userRepository = userRepository;
//		}
//
//	public String validate(String username, String password) {
//		// TODO Auto-generated method stub
//		User user = userRepository.findByEmail(username);
//		if(user.getEmailID().equals(username)){
//			if(user.getPassword().equals(password))
//				return "Loggedin";
//			else
//				return "PleaseCheckYourPassrod";
//		}
//		
//		else
//			return "username doesn't exist";
//		
//	}

}
