package edu.miu.cs425.eRegistrar.service.impl;

import edu.miu.cs425.eRegistrar.model.Student;
import edu.miu.cs425.eRegistrar.repository.StudentsRepository;
import edu.miu.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentsRepository studentsRepository;

    @Autowired
    public StudentServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentsRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentsRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if(containsDecimalPoint(searchString) && isGpa(searchString)) {
            return studentsRepository.findAllBycGpaEquals(Double.parseDouble(searchString));

        } else if(isDate(searchString)) {
            return studentsRepository.findAllByDateOfEnrollmentEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return studentsRepository.findAllByfNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(searchString, searchString, searchString);
        }
    }

    private boolean isGpa(String searchString) {
        boolean isParseableAsGpa = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsGpa = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsGpa = false;
            }
        }
        return isParseableAsGpa;
    }

    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch(Exception ex) {
            if(ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }

    @Override
    public Student saveStudent(Student student) {
        return studentsRepository.save(student);
    }
}


