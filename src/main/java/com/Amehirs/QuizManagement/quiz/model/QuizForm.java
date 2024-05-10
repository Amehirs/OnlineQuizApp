package com.Amehirs.QuizManagement.quiz.model;

import com.Amehirs.QuizManagement.admin.models.Admin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class QuizForm {

    private List<Admin> questions;
}
