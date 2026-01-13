package com.excelr.service;

import java.util.List;
import com.excelr.entity.Comment;

public interface CommentService {
    // Add this specific method to match your Starter class
    public Comment createComment(Integer postId, Comment comment);
    
    public Comment addComment(Comment comment);
    public List<Comment> getCommentsByPostId(Integer postId);
    public List<Comment> getAllComments();
}