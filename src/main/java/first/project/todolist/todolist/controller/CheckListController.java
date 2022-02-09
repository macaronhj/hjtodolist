package first.project.todolist.todolist.controller;

import first.project.todolist.todolist.dto.CheckListDto;
import first.project.todolist.todolist.service.CheckListService;
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

/**
 * packageName : first.project.todolist.controller
 * fileName : CheckListController
 * author : heejin
 * date : 2022-02-06
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-06           heejin             최초 생성
 */

public class CheckListController {
    private final CheckListService checkListService;


    @GetMapping(value = "/register")
    public ModelAndView listRegisterPage(ModelAndView mv){
        log.info("[ CheckListController -> listRegisterPage 리스트 등록 페이지 이동 요청함]");
        mv.setViewName("/todo/registerForm");
        return mv;
    }


    @GetMapping(value = "/list")
    public ModelAndView list(ModelAndView mv){
        log.info("[CheckListController -> list 게시판 페이지 이동 요청함]");
        mv.addObject("todoList", checkListService.findAll());
        mv.setViewName("/todo/list");
        return mv;
    }

    @GetMapping(value = "/request/page")
    public ModelAndView requestmdPage(ModelAndView mv){
        log.info("CheckListController > requestPage 수정 삭제 페이지 이동 중 요청");
        mv.addObject("todoList", checkListService.findAll());
        mv.setViewName("/todo/requestmdPage");
        return mv;
    }


    /**
     * todolist 수정 페이지(View) 이동
     */
    @GetMapping(value = "/update")
    public ModelAndView updatePage(ModelAndView mv, Long seq){
        log.info("[CheckListController->update page 이동 요청함]");
        mv.addObject("todoInfo", checkListService.updatePage(seq));
        mv.setViewName("/todo/updateForm");
        return mv;
    }

}
