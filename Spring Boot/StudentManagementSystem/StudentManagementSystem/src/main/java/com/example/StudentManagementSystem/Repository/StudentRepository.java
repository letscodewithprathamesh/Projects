package com.example.StudentManagementSystem.Repository;

import com.example.StudentManagementSystem.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
