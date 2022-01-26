package com.example.demo.controller;

import com.example.demo.domain.memo.Memo;
import com.example.demo.domain.memo.MemoRepository;
import com.example.demo.domain.memo.MemoRequestDto;
import com.example.demo.service.MemoService;
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

    @GetMapping("/postingpage")
    public ModelAndView getPostpage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("post.html");
        return modelAndView;
    }

    @GetMapping("/detailpage/{id}")
    public ModelAndView detailPage(@PathVariable("id") Long Id) {

        Optional<Memo> memo = memoRepository.findById(Id);

        ModelAndView modelAndView = new ModelAndView("detail.html");
        modelAndView.addObject("memoId",memo.get().getId());
        modelAndView.addObject("memoUsername",memo.get().getUsername());
        modelAndView.addObject("title", memo.get().getTitle());
        modelAndView.addObject("contents", memo.get().getContents());
        modelAndView.addObject("memoDate",memo.get().getCreateDate());
        modelAndView.addObject("memoCreatedAt",memo.get().getCreatedAt());
        modelAndView.addObject("memoModifiedAt", memo.get().getModifiedAt());

        return modelAndView;

    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {

        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable("id") Long id) {
        memoRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Memo editMemo(@PathVariable("id") Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("no such data"));

        memo.update(requestDto);

        return memoRepository.save(memo);
    }

}