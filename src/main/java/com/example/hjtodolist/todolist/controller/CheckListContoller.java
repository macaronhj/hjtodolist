package com.example.hjtodolist.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/checkList")

public class CheckListContoller {
    @GetMapping(value = "/firstPage")
    public ModelAndView requestPage(ModelAndView mv){
        log.info("CosController > requestPage 화장품 등록 페이지 이동 중 요청");
        mv.setViewName("firstPage.html");
        return mv;
    }
}
