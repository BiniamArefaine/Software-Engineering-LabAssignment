package miu.edu.cs.cs425.springSecurityDemo.eRegitrarSecurity.controller;

import miu.edu.cs.cs425.springSecurityDemo.eRegitrarSecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EResgistrarServicesController {

    private StudentService studentService;
    @Autowired
    public EResgistrarServicesController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/secured/services","/ereigstrar/secured/services"})
    public String services() {
        return "secured/services";
    }

//    @GetMapping(value = {"/securedd/services/admin/usrmgmt/edit/{studentId}", "/eregistrar/secured/services/admin/edit/{studentId}"})
//    public String editStudent(@PathVariable long studentId, Model model) {
//        Student student = studentService.getStudentById(studentId);
//        if (student != null) {
//            model.addAttribute("student", student);
//            return "/secured/services/admin/usrmgmt/edit";
//        }
//        return "/secured/services/admin/usrmgmt/list";
//    }
//
//    @PostMapping(value = {"/eregistrar/student/edit", "/student/edit"})
//    public String updateStudents(@Validated @ModelAttribute("student") Student student,
//                                 BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "student/edit";
//        }
//        student = studentService.saveStudent(student);
//        return "redirect:/eregistrar/student/list";
//    }
//
//    @GetMapping(value = {"/eregistrar/student/delete/{studentId}", "/student/delete/{studentId}"})
//    public String deleteStudent(@PathVariable Long studentId, Model model) {
//        studentService.deleteStudentById(studentId);
//        return "redirect:/eregistrar/student/list";
//    }
//
//    @GetMapping(value = {"/secured/services/admin/usrmgmt/list","/eregistrar/secured/services/admin/usrmgmt/new"})
//    public String usrmgmtNew() {
//        return "secured/services/admin/usrmgmt/new";
//    }

}
