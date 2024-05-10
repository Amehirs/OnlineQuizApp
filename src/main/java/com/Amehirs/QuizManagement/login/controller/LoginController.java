package com.Amehirs.QuizManagement.login.controller;

import com.Amehirs.QuizManagement.login.model.LoginModel;
import com.Amehirs.QuizManagement.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("registerRequest",new LoginModel());
        return "LoginPage/login.html";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("loginRequest",new LoginModel());
        return "LoginPage/Register.html";
    }

    @PostMapping("/register")
    public  String register(@ModelAttribute LoginModel loginModel){
        System.out.println("Register request:" + loginModel);
        LoginModel registeredUser = loginService.registerUser(loginModel.getLogin(),loginModel.getPassword(), loginModel.getEmail());
        return registeredUser == null ? "errorPage" : "redirect:/login";
    }

    @PostMapping("/login")
    public  String login(@ModelAttribute LoginModel loginModel, Model model, RedirectAttributes rd){
        System.out.println("login request:" + loginModel);
        LoginModel authentication = loginService.authentication(loginModel.getLogin(),loginModel.getPassword());
        if(authentication != null){
            model.addAttribute("userLogin", authentication.getLogin());
            return "redirect:/admin";
        }else{
            rd.addFlashAttribute("warning","If you're a new user register before login");
            return "redirect:/login";
        }
    }




}
