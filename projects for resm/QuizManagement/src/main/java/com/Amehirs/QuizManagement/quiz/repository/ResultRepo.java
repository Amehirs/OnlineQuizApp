package com.Amehirs.QuizManagement.quiz.repository;

import com.Amehirs.QuizManagement.quiz.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result,Integer> {
}
