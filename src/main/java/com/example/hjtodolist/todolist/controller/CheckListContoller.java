package com.example.hjtodolist.todolist.controller;

import com.example.hjtodolist.todolist.dto.CheckListDto;
import com.example.hjtodolist.todolist.service.CheckListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/checkList")

public class CheckListContoller {
    private final CheckListService checkListService;
    @GetMapping(value = "/firstPage")
    public ModelAndView requestPage(ModelAndView mv){
        log.info("CheckListController > requestPage 화장품 등록 페이지 이동 중 요청");
        mv.setViewName("firstPage.html");
        return mv;
    }
    @GetMapping(value = "/register/page")
    public ModelAndView listRegisterPage(ModelAndView mv){
        log.info("[ CheckListController -> listRegisterPage 리스트 등록 페이지 이동 요청함]");
        mv.setViewName("/registerForm.html");
        return mv;
    }
    @PostMapping(value = "/registerRequest")
    public ModelAndView registerRequest(CheckListDto checkListDto, ModelAndView mv){
        log.info("[CheckListController -> registerRequest 상품 등록 요청함]");
        mv.addObject("todoList", checkListService.registerRequest(checkListDto));
        mv.setViewName("redirect:/checkList/firstPage");
        return mv;
    }
    @GetMapping(value = "/list")
    public ModelAndView list(ModelAndView mv){
        log.info("[CheckListController -> list 게시판 페이지 이동 요청함]");
        mv.addObject("todoList", checkListService.findAll());
        mv.setViewName("/list.html");
        return mv;
    }
}
