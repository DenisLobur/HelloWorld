package com.starter.helloworld.service;

import com.starter.helloworld.repository.StudentRepository;
import com.starter.helloworld.repository.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public long createStudent(String name, String email) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);

        Student newStudent = studentRepository.save(student);

        return newStudent.getId();
    }
}
