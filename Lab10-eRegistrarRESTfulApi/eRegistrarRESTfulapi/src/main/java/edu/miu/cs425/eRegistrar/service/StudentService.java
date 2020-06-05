package edu.miu.cs425.eRegistrar.service;


import edu.miu.cs425.eRegistrar.model.Student;

import java.util.List;



public interface StudentService {

    List<Student> getAllStudents();
    Student registerNewStudent(Student newStudent);
    //Student saveStudent(Student student);
    Student getStudentById(Long studentId);
    Student updateStudent(Student editedStudent, Long studentId);
    void deleteStudentById(Long studentId);

}
