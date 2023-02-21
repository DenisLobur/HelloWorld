package com.starter.helloworld.controller;

import com.starter.helloworld.controller.data.StudentDto;
import com.starter.helloworld.controller.mapper.StudentMapper;
import com.starter.helloworld.repository.entity.StudentEntity;
import com.starter.helloworld.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents() {
        List<StudentDto> studentsDto = StudentMapper.INSTANCE.toDtoList(studentService.getAllStudents());
        return new ResponseEntity<>(studentsDto, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") Long id) {
        Optional<StudentDto> studentDto = studentService.getStudent(id).map(StudentMapper.INSTANCE::toDto);
        return studentDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentEntity studentEntity = StudentMapper.INSTANCE.toEntity(studentDto);

        StudentDto createdStudentDto = StudentMapper.INSTANCE.toDto(
                studentService.createStudent(studentEntity.getName(), studentEntity.getEmail())
        );

        return new ResponseEntity<>(createdStudentDto, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) {
        StudentEntity studentEntity = StudentMapper.INSTANCE.toEntity(studentDto);

        Optional<StudentDto> updatedStudentDto = studentService.updateStudent(studentEntity).map(StudentMapper.INSTANCE::toDto);
        return updatedStudentDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("studentId") Long id) {
        if (studentService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
