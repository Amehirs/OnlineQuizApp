package com.Amehirs.QuizManagement.admin.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "questions")
public class Admin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private String subject;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private int correctAnswers;
    private int  chose;
}
