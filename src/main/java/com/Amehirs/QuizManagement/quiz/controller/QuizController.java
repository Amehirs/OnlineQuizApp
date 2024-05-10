package com.Amehirs.QuizManagement.quiz.controller;

import com.Amehirs.QuizManagement.quiz.model.QuizForm;
import com.Amehirs.QuizManagement.quiz.model.Result;
import com.Amehirs.QuizManagement.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class QuizController {
    @Autowired
    Result result;
    Boolean submitted = false;

    @Autowired
    QuizService qService;

    @ModelAttribute("result")
    public Result getResult(){
        return result;
    }

    @GetMapping("/home")
    public String home(){
        return "redirect:/";
    }
    @GetMapping("/quiz")
    public String quizHome(){
        return "quizTest/index";
    }
    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model model, RedirectAttributes rd){
        if(username.equals("")){
            rd.addFlashAttribute("warning","You must enter your name");
            return "redirect:/quiz";
        }

        submitted = false;
        result.setUsername(username);

        //generate random question
        QuizForm qForm = qService.getQuestion();
        model.addAttribute("qForm",qForm);

        return "quizTest/startTest.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuizForm qform, Model model){
        if(!submitted){
            result.setTotalCorrect(qService.getResult(qform));
            qService.saveScore(result);
            submitted = true;
        }
        return "quizTest/result.html";
    }

    @GetMapping("/score")
    public String score(Model model){
        List<Result> sList = qService.getTopScore();
        model.addAttribute("sList",sList);

        return "quizTest/scoreboard.html";
    }
}
