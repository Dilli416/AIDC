package com.example.sample.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true")
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;

    // Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (registerRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered");
        }

        registerRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        User user = registerRepository.findByEmail(email)
                .orElse(null);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
        }

        return ResponseEntity.ok(user); // You can return token here in real JWT-based login
    }
}
