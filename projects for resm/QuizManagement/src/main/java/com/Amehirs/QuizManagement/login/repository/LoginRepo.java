package com.Amehirs.QuizManagement.login.repository;

import com.Amehirs.QuizManagement.login.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<LoginModel,Integer> {


    Optional<LoginModel> findByLoginAndPassword(String login,String password);


}
