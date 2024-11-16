package com.example.StudentManagementSystem.Services;

import com.example.StudentManagementSystem.Models.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    public void addstudent(Student student );
    public Student updateStudent(Student student);
    public Student getStudentById(int id);

    public void deletestudent(int id);

    public Page<Student> findPaginated(int pageNo,int pageSize,String sortField,String sortDirections);

}
