package com.starter.helloworld.repository;

import com.starter.helloworld.repository.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
    List<PhotoEntity> findPhotoByDescription(String description);
}
