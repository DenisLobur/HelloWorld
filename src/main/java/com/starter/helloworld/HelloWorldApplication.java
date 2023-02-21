package com.starter.helloworld;

import com.starter.helloworld.repository.entity.Photo;
import com.starter.helloworld.service.PhotoService;
import com.starter.helloworld.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class HelloWorldApplication {

    private final StudentService studentService;
    private final PhotoService photoService;

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            // Creating students
            long stdOneId = studentService.createStudent("Student Name 1", "student1@email.com");
            System.out.printf("Added student with id: %s \n", stdOneId);
            long stdTwoId = studentService.createStudent("Student Name 2", "student2@email.com");
            System.out.printf("Added student with id: %s \n", stdTwoId);

            // Creating photos
            photoService.addPhoto("http://some/url/1", stdOneId, "description_1");
            photoService.addPhoto("http://some/url/2", stdOneId, "description_2");
            photoService.addPhoto("http://some/url/3", stdTwoId, "description_3");
            photoService.addPhoto("http://some/url/4", stdTwoId, "description_4");

            // Find photo by description
            List<Photo> foundPhotos = photoService.findPhotoByDescription("description_1");
            System.out.printf("Photo with descriptions %s found: %b \n", "description_1", foundPhotos.size() > 0);

            List<Photo> foundPhotos2 = photoService.findPhotoByDescription("description_5");
            System.out.printf("Photo with descriptions %s found: %b \n", "description_5", foundPhotos2.size() > 0);
        };
    }
}
