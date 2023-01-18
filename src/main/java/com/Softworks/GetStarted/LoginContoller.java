package com.Softworks.GetStarted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LoginContoller {
	
	@Autowired
	private LoginService loginService;

		@PostMapping("/signup")
		public ResponseEntity<APIResponse> signUp (@RequestBody SignUpRequest signUpRequest) {
			
			APIResponse apiResponse = loginService.signUp(signUpRequest);
			
			return ResponseEntity
					.status(apiResponse.getStatus())
					.body(apiResponse);
		}

	
		 
		 
		@PostMapping("/login")
		public ResponseEntity<APIResponse> login (@RequestBody LoginRequest loginRequest) {
			
			APIResponse apiResponse = loginService.logIn(loginRequest);
			
			return ResponseEntity
					.status(apiResponse.getStatus())
					.body(apiResponse);
		}

		
					
}
		
