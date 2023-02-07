package com.starter.helloworld.repository;

import com.starter.helloworld.repository.entity.Photo;
import com.starter.helloworld.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
