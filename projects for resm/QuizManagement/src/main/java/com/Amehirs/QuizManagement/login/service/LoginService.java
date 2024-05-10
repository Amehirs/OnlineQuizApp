package com.Amehirs.QuizManagement.login.service;

import com.Amehirs.QuizManagement.login.model.LoginModel;
import com.Amehirs.QuizManagement.login.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepo loginRepo;
    private LoginService(LoginRepo loginRepo){
        this.loginRepo = loginRepo;
    }
    public LoginModel registerUser(String login,String password,String email){
        if(login == null && password == null){
           return null;
        }else {
            LoginModel loginModel = new LoginModel();
            loginModel.setLogin(login);
            loginModel.setPassword(password);
            loginModel.setEmail(email);
            return loginRepo.save(loginModel);
        }
    }
    public LoginModel authentication(String login,String password){
        return loginRepo.findByLoginAndPassword(login,password).orElse(null);
    }
}
