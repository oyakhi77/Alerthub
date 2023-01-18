package com.Softworks.GetStarted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	private UserRepo userRepo;
	

	public APIResponse signUp(SignUpRequest signUpRequest) {
		APIResponse apiResponse = new APIResponse();
		
		// save user
		
		User userEntity = new User();
		userEntity.setName(signUpRequest.getName());
		userEntity.setEmail(signUpRequest.getEmail());
		userEntity.setPassword(signUpRequest.getPassword());
		userEntity.setConfirm_password(signUpRequest.getConfirm_password());
		
	// store entity
		
		userEntity = userRepo.save(userEntity);
		
		// return
		apiResponse.setData(userEntity);
		
		return apiResponse;
	}


	public APIResponse logIn(LoginRequest loginRequest) {
	
		APIResponse apiResponse = new APIResponse();
		
		//verify user exist with email & password
		
	User user =	userRepo.findOneByEmailIgnoreCaseAndPassword(loginRequest.getEmailString(), loginRequest.getPasswordString());
		
	if(user == null) {
		apiResponse.setData(("Login Failed"));
	} else {
		apiResponse.setData(("Login Successful"));
	}
	
		return apiResponse;
	}

}
