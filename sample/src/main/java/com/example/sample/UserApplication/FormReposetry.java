package com.example.sample.UserApplication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormReposetry extends JpaRepository<Form,String>{
    Optional<Form> findByEmail(String email);

}
