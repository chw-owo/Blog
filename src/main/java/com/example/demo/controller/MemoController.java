package com.example.demo.controller;

import com.example.demo.domain.Memo;
import com.example.demo.domain.MemoRepository;
import com.example.demo.domain.MemoRequestDto;
import com.example.demo.service.MemoService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController

public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/hello")
    public ModelAndView getTest () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test.html");
        return modelAndView;
    }

    @PostMapping("/hello")
    public Memo createTest (@RequestBody MemoRequestDto requestDto) {

        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/de/{idx}")
    public ModelAndView detailPage(@PathVariable("idx") Long Id) {

        Optional<Memo> memo = memoRepository.findById(Id);

        ModelAndView modelAndView = new ModelAndView("/detail.html");
        modelAndView.addObject("idx",memo.get().getId());
        modelAndView.addObject("username", memo.get().getUsername());
        modelAndView.addObject("contents", memo.get().getContents());

        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println(memo.get().getId().getClass().getSimpleName());
        System.out.println("==============================================");
        System.out.println("==============================================");
        System.out.println("==============================================");

        return modelAndView;

    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {

        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }

}