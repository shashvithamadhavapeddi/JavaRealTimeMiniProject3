package com.excelr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.excelr.entity.Comment;
import com.excelr.service.CommentService;
import com.excelr.service.PostService;

@SpringBootApplication
public class JavaRealTimeMiniProject3Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaRealTimeMiniProject3Application.class, args);
        System.out.println("Blogging App Started Successfully!");
    }

    @Bean
    CommandLineRunner testComment(CommentService commentService, PostService postService) {
        return args -> {
            // Safety Check: Only add a comment if Post #1 exists in DB
            if (postService.getPostById(1) != null) {
                Comment c = new Comment();
                c.setName("System Test");
                c.setEmail("admin@blog.com");
                c.setContent("This is my first comment");
                
                commentService.createComment(1, c);
                System.out.println("Test comment inserted for Post #1");
            } else {
                System.out.println("Test comment skipped: Post #1 does not exist yet.");
            }
        };
    }
}