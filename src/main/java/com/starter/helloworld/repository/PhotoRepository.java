package com.starter.helloworld.repository;

import com.starter.helloworld.repository.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findPhotoByDescription(String description);
}
