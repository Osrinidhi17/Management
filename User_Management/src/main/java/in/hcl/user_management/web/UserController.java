package in.hcl.user_management.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.hcl.user_management.domain.User;
import in.hcl.user_management.exception.PasswordValidationException;
import in.hcl.user_management.repository.UserRepository;
import in.hcl.user_management.service.UserService;
import in.hcl.user_management.serviceImpl.MapValidationErrorService;
import in.hcl.user_management.util.Status;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result) throws PasswordValidationException {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		boolean passwordVaild = userService.passwordVaild(user);
		if (passwordVaild) {
			User registeredUser = userService.registerUser(user);
			return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);	
		}
		else
		{
			throw new PasswordValidationException("Enter a valid password");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		Status login = userService.loginUser(user);
		return new ResponseEntity<Status>(login,HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logUserOut(@RequestBody User user) {
		Status logout = userService.logoutUser(user);
		return new ResponseEntity<Status>(logout,HttpStatus.OK);
	}

	@PostMapping("/change_password")
	public ResponseEntity<?> changePassword(@RequestBody User user) {
		Status changePassword = userService.changePassword(user);
		return new ResponseEntity<Status>(changePassword, HttpStatus.OK);	
	}

	@PatchMapping("/update_profile")
	public ResponseEntity<?> updateProfile(@RequestBody User user) {
		Status profileUpdate = userService.updateProfile(user);
		return new ResponseEntity<Status>(profileUpdate, HttpStatus.OK);	
	}
	 @DeleteMapping("/userId/{userId}")
	    public ResponseEntity<?> deleteProject(@PathVariable("userId") long id){
			Status deleteUser = userService.deleteProfile(id);
			 return new ResponseEntity<Status>(deleteUser , HttpStatus.OK);	
	  }
	   @GetMapping("/all")
	    public Iterable<User> getAllProjects(){
	      return userService.findAllUser();	
	    }
	
}
