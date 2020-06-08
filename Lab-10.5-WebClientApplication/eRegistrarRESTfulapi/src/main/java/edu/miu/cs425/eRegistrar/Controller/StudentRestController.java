package edu.miu.cs425.eRegistrar.Controller;

import edu.miu.cs425.eRegistrar.model.Student;
import edu.miu.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value="/eregistrar", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRestController {


    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping(value = "/get/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping(value = "/add")
    public Student registerNewStudent(@Valid @RequestBody Student student) {
        return studentService.registerNewStudent(student);
    }

    @GetMapping(value = "/list/students")
    public List<Student> listStudents() {
        return studentService.getAllStudents();
    }


    @PutMapping(value = "/update/{studentId}")
    public Student updateStudent(@Valid @RequestBody Student editedStudent, @PathVariable Long studentId) {
        return studentService.updateStudent(editedStudent,studentId);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }
}
