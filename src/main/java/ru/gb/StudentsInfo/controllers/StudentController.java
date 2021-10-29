package ru.gb.StudentsInfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.StudentsInfo.models.Student;
import ru.gb.StudentsInfo.services.StudentService;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // [http://localhost:8189/app]/
    @GetMapping("/")
    public String showAllStudentsPage(Model model) {
        model.addAttribute("groupName", "SSA-98");
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/{id}")
    public String showStudentInfo(@PathVariable(name = "id") Long id, Model model) {
        Optional<Student> student = studentService.findOneById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
        }
        return "student_info";
    }


    @GetMapping("/create")
    public String showCreator() {
        return "create_student_form";
    }

        @PostMapping("/create")
       public String createNewStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteById(id);
        return "redirect:/";
  }

    @PostMapping("/search")
    public String searchStudent(@RequestParam Long id, Model model) {
       return showStudentInfo(id, model);
    }

}

