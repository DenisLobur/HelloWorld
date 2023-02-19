package com.starter.helloworld.service;

import com.starter.helloworld.repository.PhotoRepository;
import com.starter.helloworld.repository.StudentRepository;
import com.starter.helloworld.repository.entity.PhotoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    private final StudentRepository studentRepository;

    public void addPhoto(String url, long studentId, String description) {
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setUrl(url);
        photoEntity.setStudentEntity(studentRepository.findById(studentId).orElseThrow());
        photoEntity.setDescription(description);

        photoRepository.save(photoEntity);
    }

    public List<PhotoEntity> findPhotoByDescription(String description) {
        return photoRepository.findPhotoByDescription(description);
    }
}
