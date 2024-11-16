package com.example.StudentManagementSystem.Controller;

import com.example.StudentManagementSystem.Models.PageNumbers;
import com.example.StudentManagementSystem.Models.Student;
import com.example.StudentManagementSystem.Services.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {


    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
@GetMapping("/student")
    public String listStudent(Model model){
    return getPage(1,"name","dsc",model);
    }

    @GetMapping("/addstudents")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "addstudent";
    }

    @PostMapping("/addstudentdata")
    public String addData(@ModelAttribute("student") Student student){
        studentService.addstudent(student);
        return "redirect:/student";
    }

    @GetMapping("/getupdatestudent/{id}")
    public String getStudent(@PathVariable int id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "updatestudent";
    }
    @GetMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable int id){
       studentService.deletestudent(id);
        return "redirect:/student";
    }

    @GetMapping("/page")
    public String getPage(@RequestParam int pageNumber, @RequestParam("sortField") String sortField,@RequestParam("sortDir") String sortDir,Model model) {
        System.out.println(pageNumber);
        int pageSize = 5;
        Page<Student> page = studentService.findPaginated(pageNumber, pageSize,sortField,sortDir);
        List<Student> studentList = page.getContent();

        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");

        model.addAttribute("listStudent", studentList);
        return "students";
    }






}
