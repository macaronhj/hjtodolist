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
        log.info("CheckListController > requestPage 리스트 등록 페이지 이동 중 요청");
        mv.setViewName("firstPage");
        return mv;
    }
    @GetMapping(value = "/register/page")
    public ModelAndView listRegisterPage(ModelAndView mv){
        log.info("[ CheckListController -> listRegisterPage 리스트 등록 페이지 이동 요청함]");
        mv.setViewName("/registerForm");
        return mv;
    }
    @PostMapping(value = "/registerRequest")
    public ModelAndView registerRequest(CheckListDto checkListDto, ModelAndView mv){
        log.info("[CheckListController -> registerRequest 리스트 등록 요청함]");
        mv.addObject("todoList", checkListService.registerRequest(checkListDto));
        mv.setViewName("redirect:/checkList/list");
        return mv;
    }
    @GetMapping(value = "/list")
    public ModelAndView list(ModelAndView mv){
        log.info("[CheckListController -> list 게시판 페이지 이동 요청함]");
        mv.addObject("todoList", checkListService.findAll());
        mv.setViewName("/list");
        return mv;
    }
    @GetMapping(value = "/request/page")
    public ModelAndView requestmdPage(ModelAndView mv){
        log.info("CheckListController > requestPage 수정 삭제 페이지 이동 중 요청");
        mv.addObject("todoList", checkListService.findAll());
        mv.setViewName("requestmdPage");
        return mv;
    }
    @PostMapping(value = "/delete")
    public ModelAndView requestDelete(ModelAndView mv, Long seq){
        log.info("[CheckListController -> requestDelete 리스트 삭제 요청함]");
        mv.addObject("todoList", checkListService.requestDelete(seq));
        mv.setViewName("redirect:/checkList/list");
        return mv;
    }
    @GetMapping(value = "/update/page")
    public ModelAndView updatePage(ModelAndView mv, Long seq){
        log.info("[CheckListController->update page 이동 요청함]");
        mv.addObject("todoInfo", checkListService.updatePage(seq));
        mv.setViewName("/updateForm");
        return mv;
    }
    @PostMapping(value = "/update/save")
    public ModelAndView doUpdate(CheckListDto checkListDto, ModelAndView mv){
        log.info("[CheckListController -> doUpdate 수정 요청함]");
        mv.addObject("todoList", checkListService.doUpdate(checkListDto));
        mv.setViewName("redirect:/checkList/list");
        return mv;
    }
}
