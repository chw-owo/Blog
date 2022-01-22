package com.example.demo.controller;

import com.example.demo.domain.Memo;
import com.example.demo.domain.MemoRepository;
import com.example.demo.domain.MemoRequestDto;
import com.example.demo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

//        Memo memo = new Memo(requestDto);
//        memoRepository.save(memo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test.html");
        return modelAndView;
    }

    @PostMapping("/hello")
    public Memo createTest (@RequestBody MemoRequestDto requestDto) {

        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("test.html");
//        return modelAndView;
    }

    @RequestMapping("/detail")
    public ModelAndView detailPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("detail.html");
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