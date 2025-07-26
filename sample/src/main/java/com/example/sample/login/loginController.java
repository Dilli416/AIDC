//package com.example.sample.login;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:5173")
//public class loginController {
//
//    @Autowired
//    private loginReposetry userRepo;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> loginOrCreate(@RequestBody Map<String, String> loginData) {
//        String email = loginData.get("email");
//        String password = loginData.get("password");
//
//        Optional<login> userOpt = userRepo.findByEmail(email);
//
//        if (userOpt.isPresent()) {
//            login user = userOpt.get();
//            if (user.getPassword().equals(password)) {
//                return ResponseEntity.ok(Map.of(
//                        "message", "Login successful",
//                        "email", user.getEmail(),
//                        "role", user.getRole()
//                ));
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                        .body(Map.of("error", "Incorrect password"));
//            }
//        } else {
//            // Auto-create new account
//            login newUser = new login();
//            newUser.setEmail(email);
//            newUser.setPassword(password);
//            newUser.setRole("farmer"); // default role
//            userRepo.save(newUser);
//
//            return ResponseEntity.ok(Map.of(
//                    "message", "New account created",
//                    "email", newUser.getEmail(),
//                    "role", newUser.getRole()
//            ));
//        }
//    }
//}
