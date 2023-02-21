package com.starter.helloworld.service;

import com.starter.helloworld.repository.StudentRepository;
import com.starter.helloworld.repository.entity.StudentEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Optional<StudentEntity> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity createStudent(String name, String email) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setEmail(email);

        return studentRepository.save(studentEntity);
    }

    public Optional<StudentEntity> updateStudent(StudentEntity updatedStudentEntity) {
        Optional<StudentEntity> studentNullable = studentRepository.findById(updatedStudentEntity.getId());
        studentNullable.ifPresentOrElse(
                studentEntity -> {
                    studentEntity.setName(updatedStudentEntity.getName());
                    studentEntity.setEmail(updatedStudentEntity.getEmail());
                    studentEntity.setPhotoEntities(updatedStudentEntity.getPhotoEntities());
                },
                Optional::empty
        );

        return studentNullable;
    }

    public boolean deleteStudent(Long id) {
        Optional<StudentEntity> studentNullable = studentRepository.findById(id);
        studentNullable.map(
                studentEntity -> {
                    studentRepository.delete(studentEntity);
                    return true;
                }
        );
        return false;
    }
}
