package edu.miu.cs425.eRegistrar.repository;


import edu.miu.cs425.eRegistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {



}
