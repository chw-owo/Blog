package com.example.demo.controller;

import com.example.demo.domain.comment.Comment;
import com.example.demo.domain.comment.CommentRepository;
import com.example.demo.domain.comment.CommentRequestDto;
import com.example.demo.domain.memo.Memo;
import com.example.demo.domain.memo.MemoRequestDto;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("/api/comment")
    public List<Comment> getComment() {

        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/comment")
    public Comment createComment(@RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    @DeleteMapping("/api/comment/{id}")
    public Long deleteComment(@PathVariable("id") Long id) {
        commentRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/comment/{id}")
    public Comment editComment(@PathVariable("id") Long id, @RequestBody CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no such data"));

        comment.update(requestDto);

        return commentRepository.save(comment);
    }


}