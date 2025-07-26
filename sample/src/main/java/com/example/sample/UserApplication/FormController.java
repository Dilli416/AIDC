//package com.example.sample.UserApplication;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin(origins = "http://localhost:5173")
//public class FormController {
//
//    @Autowired
//    private FormReposetry formRepo;
//
//    // LOGIN with fallback to auto-register
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> data) {
//        String email = data.get("email");
//        String password = data.get("password");
//
//        Optional<Form> userOpt = formRepo.findByEmail(email);
//        if (userOpt.isPresent()) {
//            Form user = userOpt.get();
//            if (user.getPassword().equals(password)) {
//                return ResponseEntity.ok(Map.of(
//                        "message", "Login successful",
//                        "email", user.getemail(),
//                        "name", user.getName()
//                ));
//            } else {
//                return ResponseEntity.badRequest().body(Map.of("error", "❌ Wrong password"));
//            }
//        } else {
//            // Auto-register logic
//            Form newUser = new Form();
//            newUser.setemail(email);
//            newUser.setPassword(password);
//            newUser.setName("New User");
//            formRepo.save(newUser);
//            return ResponseEntity.ok(Map.of(
//                    "message", "✅ Account created and logged in",
//                    "email", email,
//                    "name", "New User"
//            ));
//        }
//    }
//
//    // Explicit Registration
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Form form) {
//        if (formRepo.findByEmail(form.getemail()).isPresent()) {
//            return ResponseEntity.badRequest().body(Map.of("error", "❌ Email already registered"));
//        }
//        formRepo.save(form);
//        return ResponseEntity.ok(Map.of("message", "✅ Registration successful"));
//    }
//}
