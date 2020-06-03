package edu.miu.cs425.eRegistrar.Controller;

import edu.miu.cs425.eRegistrar.model.Student;
import edu.miu.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/eregistrar/students/list")
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.getAllStudents());
        modelAndView.setViewName("students/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregistrar/students/new","/students/new"})

    public String displayNewBookForm(Model model) {
        model.addAttribute("students", new Student());
        return "students/new";
    }

    @PostMapping(value = {"/eregistrar/students/new","/students/new"})
    public String addNewStudent(@Valid @ModelAttribute("students") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "students/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/students/list";
    }

    @GetMapping(value = {"/eregistrar/students/edit/{studentId}","/students/edit/{studentId}"})
    public String editBook(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "students/edit";
        }
        return "students/list";
    }

    @PostMapping(value = {"/eregistrar/students/edit","/students/edit"})
    public String updateBook(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "students/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/students/list";
    }

//    @GetMapping(value = {"/eregistrar/students/delete/{studentId}","/students/delete/{studentId}"})
//    public String deleteBook(@PathVariable Long studentId, Model model) {
//        studentService.deleteStudentById(studentId);
//        return "redirect:/eregistrar/students/list";
//    }

    @GetMapping(value = {"/eregistrar/students/search", "/students/search"})
    public ModelAndView searchBooks(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("students/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregistrar/students/delete/{studentId}","/students/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/students/list";
    }

}
