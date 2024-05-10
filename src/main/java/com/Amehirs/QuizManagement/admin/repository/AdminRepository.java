package com.Amehirs.QuizManagement.admin.repository;

import com.Amehirs.QuizManagement.admin.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    
}
