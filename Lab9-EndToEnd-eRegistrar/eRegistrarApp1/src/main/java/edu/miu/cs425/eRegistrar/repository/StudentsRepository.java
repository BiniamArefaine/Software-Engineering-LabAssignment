package edu.miu.cs425.eRegistrar.repository;


import edu.miu.cs425.eRegistrar.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {

    List<Student> findAllByfNameContainingOrLastNameContainingOrStudentNumberContainingOrderByStudentId(String fName,
                                                                                         String lastName,
                                                                                         String studentNumber);
    List<Student> findAllBycGpaEquals(Double cGpa);
    List<Student> findAllByDateOfEnrollmentEquals(LocalDate datePublished);

    // More queries
    List<Student> findBooksByDateOfEnrollmentIsStartingWith(String str);
}
