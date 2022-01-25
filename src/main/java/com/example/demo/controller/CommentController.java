package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class CommentController {

//    private final CommentRepository CommentRepository;
//    private final CommentService CommentService;
//
//    @PostMapping("/api/Comments")
//    public Comment createComment(@RequestBody CommentRequestDto requestDto) {
//        Comment Comment = new Comment(requestDto);
//        return CommentRepository.save(Comment);
//    }
//
//    @GetMapping("/postingpage")
//    public ModelAndView getTest () {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("post.html");
//        return modelAndView;
//    }
//
//    @PostMapping("/postingpage")
//    public Comment createTest (@RequestBody CommentRequestDto requestDto) {
//
//        Comment Comment = new Comment(requestDto);
//        return CommentRepository.save(Comment);
//    }
//
//    @GetMapping("/detailpage/{id}")
//    public ModelAndView detailPage(@PathVariable("id") Long Id) {
//
//        Optional<Comment> Comment = CommentRepository.findById(Id);
//
//        ModelAndView modelAndView = new ModelAndView("detail.html");
//        modelAndView.addObject("id",Comment.get().getId());
//        modelAndView.addObject("title", Comment.get().getUsername());
//        modelAndView.addObject("contents", Comment.get().getComment());
//
//
//        return modelAndView;
//
//    }
//
//    @GetMapping("/api/Comments")
//    public List<Comment> getComments() {
//
//        return CommentRepository.findAllByOrderByModifiedAtDesc();
//    }
//
//    @DeleteMapping("/api/Comments/{id}")
//    public Long deleteComment(@PathVariable Long id) {
//        CommentRepository.deleteById(id);
//        return id;
//    }
//
//    @PutMapping("/api/Comments/{id}")
//    public Comment editComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
//        Comment Comment = CommentRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("no such data"));
//
//        Comment.update(requestDto);
//
//        return CommentRepository.save(Comment);
//    }

}