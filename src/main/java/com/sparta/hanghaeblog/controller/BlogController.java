package com.sparta.hanghaeblog.controller;


import com.sparta.hanghaeblog.dto.BlogRequestDto;
import com.sparta.hanghaeblog.dto.NewDto;
import com.sparta.hanghaeblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/blogs")
    public NewDto createMemo(@RequestBody BlogRequestDto requestDto) {
        return blogService.createMemo(requestDto);
    }

    @GetMapping("/api/blogs")
    public List<NewDto> getMemos() {
        return blogService.getMemos();
    }

    @GetMapping("/api/blogs/{id}")
    public NewDto getMemo(@PathVariable Long id) {
        return blogService.getMemo(id);
    }

    @PutMapping("/api/blogs/{id}")
    public NewDto updateMemo(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.update(id, requestDto);
    }

    @DeleteMapping("/api/blogs/{id}")
    public String deleteMemo(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.deleteMemo(id, requestDto);

    }
}