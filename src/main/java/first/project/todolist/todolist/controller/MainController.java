package first.project.todolist.todolist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {
    @GetMapping(value = {"/",""})
    public ModelAndView requestPage(ModelAndView mv){
        log.info("CheckListController > requestPage 리스트 등록 페이지 이동 중 요청");
        mv.setViewName("/todo/firstPage");
        return mv;
    }

    @GetMapping(value = "/demo")
    public ModelAndView demo(ModelAndView mv){
        mv.setViewName("index");
        return mv;
    }
}
