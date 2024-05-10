package com.Amehirs.QuizManagement.admin.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {

    @NotEmpty(message= "Question is required")
    private String question;

    @NotEmpty(message="subject is required")
    private String subject;

    @NotEmpty(message="option is required")
    private String Option1;

    @NotEmpty(message="option is required")
    private String Option2;

    @NotEmpty(message="option is required")
    private String Option3;

    @NotEmpty(message="option is required")
    private String Option4;

    @NotNull(message = "correct answer is required")
    private Integer correctAnswers;
}

