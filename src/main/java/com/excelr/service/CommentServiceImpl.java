package com.excelr.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excelr.entity.Comment;
import com.excelr.entity.Post;
import com.excelr.repository.CommentRepository;
import com.excelr.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    // IMPLEMENT THE NEW METHOD
    @Override
    public Comment createComment(Integer postId, Comment comment) {
        // 1. Find the post by ID
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post Not Found with ID: " + postId));
        
        // 2. Map the post to the comment
        comment.setPost(post);
        
        // 3. Save the comment
        return commentRepository.save(comment);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment); 
    }
    
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsByPostId(Integer postId) {
        return commentRepository.findCommentsByPostId(postId);
    }
}