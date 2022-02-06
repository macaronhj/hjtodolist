package com.example.hjtodolist.todolist.controller;


import com.example.hjtodolist.todolist.dto.BoarderDto;
import com.example.hjtodolist.todolist.service.BoarderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoarderController {
    private final BoarderService boarderService;

    @GetMapping(value="/boarder")
    public ModelAndView boarder(ModelAndView mv) {
        log.info("BoarderController > boarder  리스트 요청 시작!!");
        mv.addObject("BoarderList", boarderService.boarder());
        mv.setViewName("/index.html");
        return mv;
    }
    @GetMapping(value = "/boarderRequest")
    public ModelAndView boarderRequest(ModelAndView mv){
        log.info("BoarderController > boarderRequest 화장품 등록 페이지 이동 중 요청");
        mv.setViewName("/boarder/boarderRequest.html");
        return mv;
    }
    @PostMapping(value = "/registerRequest")
    public ModelAndView registerRequest(BoarderDto boardDto, ModelAndView mv) {
        log.info("BoarderController > registerRequest 사용자 등록 요청 시작");

        mv.addObject("BoarderList", boarderService.registerRequest(boardDto));
        mv.setViewName("/boarder/boarderView.html");
        return mv;
    }
    @PostMapping(value = "/delete")
    public ModelAndView delete(ModelAndView mv, Long seq){
        log.info("[BoarderController > delete 사용자 삭제 요청 시작]");
        mv.addObject("BoarderList" , boarderService.delete(seq));
        mv.setViewName("/boarder/boarderView.html");
        return mv;
    }
    @GetMapping(value = "/update1")
    public ModelAndView update1(ModelAndView mv, Long seq){
        BoarderDto boarderDto = boarderService.update1(seq);
        log.info("[BoarderController > update 사용자 수정 요청 시작]");
        mv.addObject("seq", boarderDto.getSeq());
        mv.addObject("name", boarderDto.getName());
        mv.addObject("count", boarderDto.getCount());
        mv.addObject("company", boarderDto.getCompany());
        mv.addObject("sale", boarderDto.getSale());
        mv.setViewName("/boarder/boarderUpdate.html");
        return mv;
    }

    @PostMapping(value = "/update2")
    public ModelAndView update2(BoarderDto boardDto, ModelAndView mv){
        log.info("[BoarderController > update2 사용자 수정 요청 시작]");
        log.info(boardDto.getName());
        log.info(boardDto.getCompany());
        mv.addObject("BoarderList" , boarderService.update2(boardDto));
        mv.setViewName("redirect:/boarder");
        return mv;
    }
}
