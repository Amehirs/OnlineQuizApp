package com.Amehirs.QuizManagement.admin.controller;

import com.Amehirs.QuizManagement.admin.models.Admin;
import com.Amehirs.QuizManagement.admin.models.QuestionDto;
import com.Amehirs.QuizManagement.admin.repository.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    public AdminRepository repo;

    @GetMapping("")
    public String showAllQuestions(Model model){
        List<Admin> questions = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("questions", questions );
        return "questions/index";
    }

    @GetMapping("/create")
    public String showCreatedQuestions(Model model){
        QuestionDto questionDto = new QuestionDto();
        model.addAttribute("questionDto", questionDto);
        return "questions/createQuestion";
    }

    @PostMapping("/create")
    public String createQuestions(
        @Valid @ModelAttribute QuestionDto questionDto,
                BindingResult result){
        if (result.hasErrors()) {
            // If there are errors, return to the form page
            return "questions/createQuestion";
        }

        Admin admin = new Admin();
        admin.setSubject(questionDto.getSubject());
        admin.setQuestion(questionDto.getQuestion());
        admin.setOption1(questionDto.getOption1());
        admin.setOption2(questionDto.getOption2());
        admin.setOption3(questionDto.getOption3());
        admin.setOption4(questionDto.getOption4());
        admin.setCorrectAnswers(questionDto.getCorrectAnswers());

        repo.save(admin);

        return "redirect:/admin";
    }

    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id){

    try{
        Admin questions = repo.findById(id).get();
        model.addAttribute("questions", questions);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setSubject(questions.getSubject());
        questionDto.setQuestion(questions.getQuestion());
        questionDto.setOption1(questions.getOption1());
        questionDto.setOption2(questions.getOption2());
        questionDto.setOption3(questions.getOption3());
        questionDto.setOption4(questions.getOption4());
        questionDto.setCorrectAnswers(questions.getCorrectAnswers());

        model.addAttribute("questionDto",questionDto);
    }catch(Exception ex){
        System.out.println("Exception:" + ex.getMessage());
        model.addAttribute("errorMessage", "An error occurred while retrieving the question.");
        return "questions/editQuestions";

    }
        return "questions/editQuestions";
    }

    @PostMapping("/edit")
    public String updateQuestion(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute QuestionDto questionDto,
            BindingResult result){
        try{
            Admin question = repo.findById(id).get();
            model.addAttribute("question",question);

            if (result.hasErrors()){
                return "questions/editQuestions";
            }

            question.setSubject(questionDto.getSubject());
            question.setQuestion(questionDto.getQuestion());
            question.setOption1(questionDto.getOption1());
            question.setOption2(questionDto.getOption2());
            question.setOption3(questionDto.getOption3());
            question.setOption4(questionDto.getOption4());
            question.setCorrectAnswers(questionDto.getCorrectAnswers());

            repo.save(question);
        }catch(Exception ex){
            System.out.println("Exception:" + ex.getMessage());
        }

        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String deleteQuestion(
        @RequestParam int id) {

        Admin question = null;
        try {
            question = repo.findById(id).get();
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
        }

        repo.delete(question);

        return "redirect:/admin";
    }


}
