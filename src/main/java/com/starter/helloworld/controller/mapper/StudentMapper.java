package com.starter.helloworld.controller.mapper;

import com.starter.helloworld.controller.data.StudentDto;
import com.starter.helloworld.repository.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(StudentEntity studentEntity);

    StudentEntity toEntity(StudentDto studentDto);

    List<StudentDto> toDtoList(List<StudentEntity> studentEntityList);

    List<StudentEntity> toEntityList(List<StudentDto> studentDtoList);
}
