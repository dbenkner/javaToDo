package com.benkner.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	public UserRepository userRepo;
	
	@GetMapping
	public ResponseEntity<Iterable<User>> GetAllUsers() {
		Iterable<User> users = userRepo.findAll();
		return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
	}
	@PostMapping("/newuser")
	public ResponseEntity<User> addNewUser(@RequestBody NewUserDTO newUserDTO){
		String hashedPW = hashPassword(newUserDTO.password);
		User user = new User(newUserDTO, hashedPW);
		userRepo.save(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	private String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
}

