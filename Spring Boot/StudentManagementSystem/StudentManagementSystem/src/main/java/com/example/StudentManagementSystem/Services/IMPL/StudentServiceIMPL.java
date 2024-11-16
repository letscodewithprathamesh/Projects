package com.example.StudentManagementSystem.Services.IMPL;

import com.example.StudentManagementSystem.Models.Student;
import com.example.StudentManagementSystem.Repository.StudentRepository;
import com.example.StudentManagementSystem.Services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIMPL implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceIMPL(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void addstudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public void deletestudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection) {
        Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                :Sort.by(sortField).descending();
        Pageable pageable= PageRequest.of(pageNo-1,pageSize,sort);
        return this.studentRepository.findAll(pageable);
    }



}
