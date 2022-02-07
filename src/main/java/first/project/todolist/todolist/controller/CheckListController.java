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

public class CheckListController {
    private final CheckListService checkListService;

    /**
     * todolist 등록 페이지(View) 이동
     */
    @GetMapping(value = "/register")
    public ModelAndView listRegisterPage(ModelAndView mv){
        log.info("[ CheckListController -> listRegisterPage 리스트 등록 페이지 이동 요청함]");
        mv.setViewName("/todo/registerForm");
        return mv;
    }

    /**
     * todolist 등록 기능 수행 
     */
    @PostMapping(value = "/register")
    public ModelAndView registerRequest(CheckListDto checkListDto, ModelAndView mv){
        log.info("[CheckListController -> registerRequest 리스트 등록 요청함]");
        mv.addObject("todoList", checkListService.registerRequest(checkListDto));
        mv.setViewName("redirect:/checkList/list");
        return mv;
    }

    /**
     * todolist selectAll 페이지(View) 이동
     */
    @GetMapping(value = "/list")
    public ModelAndView list(ModelAndView mv){
        log.info("[CheckListController -> list 게시판 페이지 이동 요청함]");
        mv.addObject("todoList", checkListService.findAll());
        mv.setViewName("/todo/list");
        return mv;
    }

    /**
     * todolist 수정과 삭제 가능한 페이지(View) 이동
     */
    @GetMapping(value = "/request/page")
    public ModelAndView requestmdPage(ModelAndView mv){
        log.info("CheckListController > requestPage 수정 삭제 페이지 이동 중 요청");
        mv.addObject("todoList", checkListService.findAll());
        mv.setViewName("/todo/requestmdPage");
        return mv;
    }

    /**
     * todolist 삭제 기능 수행
     */
    @PostMapping(value = "/delete")
    public ModelAndView requestDelete(ModelAndView mv, Long seq){
        log.info("[CheckListController -> requestDelete 리스트 삭제 요청함]");
        mv.addObject("todoList", checkListService.requestDelete(seq));
        mv.setViewName("redirect:/checkList/list");
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

    /**
     * todolist 수정 기능 수행
     */
    @PostMapping(value = "/update")
    public ModelAndView doUpdate(CheckListDto checkListDto, ModelAndView mv){
        log.info("[CheckListController -> doUpdate 수정 요청함]");
        mv.addObject("todoList", checkListService.doUpdate(checkListDto));
        mv.setViewName("redirect:/checkList/list");
        return mv;
    }
}
