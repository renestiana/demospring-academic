package com.renasgmt.demospring.academic.repository;

import com.renasgmt.demospring.academic.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    @Query("{'student_id': ?0}")
    Optional<Student> findByStudentId(String studentId);
}
