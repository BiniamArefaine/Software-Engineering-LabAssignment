package edu.miu.cs425.eRegistrar.service;


import edu.miu.cs425.eRegistrar.model.Student;

import java.util.List;
import java.util.logging.LogManager;

public interface StudentService {

    Iterable<Student> getAllStudents();

    public abstract Student saveStudent(Student student);
    public abstract Student getStudentById(Long studentId);
    public abstract void deleteStudentById(Long studentId);
    public abstract List<Student> searchStudents(String searchString);
}
