package edu.miu.cs425.eRegistrar.service.impl;

import edu.miu.cs425.eRegistrar.model.Student;
import edu.miu.cs425.eRegistrar.repository.StudentsRepository;
import edu.miu.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentsRepository studentsRepository;

    @Autowired
    public StudentServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentsRepository.findAll();
    }

    @Override
    public Student registerNewStudent(Student newStudent) {
        return studentsRepository.save(newStudent);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentsRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updateStudent(Student editedStudent, Long studentId) {
        return studentsRepository.findById(studentId)
                .map(student -> {
                    student.setfName(editedStudent.getfName());
                    student.setMiddleName(editedStudent.getMiddleName());
                    student.setLastName(editedStudent.getLastName());
                    student.setStudentNumber(editedStudent.getStudentNumber());
                    student.setcGpa(editedStudent.getcGpa());
                    student.setIsInternational(editedStudent.getIsInternational());
                    student.setDateOfEnrollment(editedStudent.getDateOfEnrollment());
                    return studentsRepository.save(student);
                }).orElseGet(() -> {
                    return studentsRepository.save(editedStudent);
                });
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentsRepository.deleteById(studentId);
    }


}


