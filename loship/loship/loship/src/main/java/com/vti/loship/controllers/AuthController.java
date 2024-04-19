package com.vti.loship.controllers;

import com.vti.loship.jwt.JwtTokenStore;
import com.vti.loship.models.User;
import com.vti.loship.requests.LoginRequest;
import com.vti.loship.responses.ResponseObject;
import com.vti.loship.security.PasswordEncoder;
import com.vti.loship.services.AuthService;
import com.vti.loship.services.UserService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody User user) {

        boolean checkExist =
                userService.checkExistEmailOrPassword(user.getEmail(), user.getPhone());

        if(checkExist)
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, "null", "Email or Phone already exists"));

        user.setPassword(PasswordEncoder.getInstance().encodePassword(user.getPassword()));
        User response = userService.create(user);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, response, "success"));

    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody LoginRequest loginRequest) {

        Optional<User> user = userService.findByEmail((loginRequest.getEmail()));
        if (user.isEmpty() || !PasswordEncoder.getInstance().matches(loginRequest.getPassword(), user.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(201, user, "Email or Password incorrect"));
        }

        String token = authService.loginWithEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        JwtTokenStore.getInstance().storeToken(loginRequest.getEmail(), token);
        return ResponseEntity.status(HttpStatus.OK).body
                (new ResponseObject(200,user,token));

    }

}
