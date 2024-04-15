package com.vti.loship.services;

import com.vti.loship.jwt.JWTUtility;
import com.vti.loship.models.User;
import com.vti.loship.repositories.UserRepository;
import com.vti.loship.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public String loginWithEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        assert user != null;
        if (PasswordEncoder.getInstance().matches(password, user.getPassword())) {
            return JWTUtility.getInstance().generateTokenWithEmail(email);
        }
        return null;
    }
}
