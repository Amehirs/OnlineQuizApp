package com.Amehirs.QuizManagement.quiz.service;

import com.Amehirs.QuizManagement.admin.models.Admin;
import com.Amehirs.QuizManagement.admin.repository.AdminRepository;
import com.Amehirs.QuizManagement.quiz.model.QuizForm;
import com.Amehirs.QuizManagement.quiz.model.Result;
import com.Amehirs.QuizManagement.quiz.repository.ResultRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    QuizForm qForm;

    @Autowired
    AdminRepository qrepo;

    @Autowired
    ResultRepo rRepo;

    //to generate random questions
    public QuizForm getQuestion(){
        List<Admin> allQues = qrepo.findAll();
        List<Admin> qList = new ArrayList<Admin>();

        Random random = new Random();

        for(int i=0; i<10; i++){
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }
        qForm.setQuestions(qList);

        return qForm;
    }

    public int getResult(QuizForm qform) {
        int correct = 0;

        for (Admin q : qform.getQuestions()) {
            if (q.getCorrectAnswers() == q.getChose())
                correct++;
        }

        return correct;
    }
    public  void saveScore(Result result){
        Result saveResult = new Result();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect (result.getTotalCorrect());
        rRepo.save(saveResult);
    }
    public List<Result> getTopScore(){
        List<Result> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC,"totalCorrect"));

        return sList;
    }
}
