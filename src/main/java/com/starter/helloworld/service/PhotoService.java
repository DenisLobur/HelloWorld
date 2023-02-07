package com.starter.helloworld.service;

import com.starter.helloworld.repository.PhotoRepository;
import com.starter.helloworld.repository.StudentRepository;
import com.starter.helloworld.repository.entity.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    private final StudentRepository studentRepository;

    public void addPhoto(String url, long studentId, String description) {
        Photo photo = new Photo();
        photo.setUrl(url);
        photo.setStudent(studentRepository.findById(studentId).orElseThrow());
        photo.setDescription(description);

        photoRepository.save(photo);
    }

    public List<Photo> findPhotoByDescription(String description) {
        return photoRepository.findPhotoByDescription(description);
    }
}
