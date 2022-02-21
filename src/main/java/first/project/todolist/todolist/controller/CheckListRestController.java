package first.project.todolist.todolist.controller;

import first.project.todolist.todolist.dto.CheckListDto;
import first.project.todolist.todolist.service.CheckListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/checkList")
public class CheckListRestController {
    private final CheckListService checkListService;
    /**
     * 체크리스트 등록  ( DTO 로 요청 받는 경우 )
     * 현재는 postman 과같은 툴을 이용해서만 테스트 가능
     * @param checkListDto checkListDto
     * @return ModelAndView
     */
    @PostMapping(value = "/register")
    public String registerRequest(CheckListDto checkListDto){
        log.info("[CheckListRestController -> registerRequest 리스트 등록 요청함]");
        return checkListService.registerRequest(checkListDto);
    }
    /**
     * 체크리스트 삭제 요청
     * @param seq seq
     * @return ModelAndView
     */
    @PostMapping(value = "/delete")
    public String requestDelete(Long seq){
        log.info("[CheckListRestController -> requestDelete 리스트 삭제 요청함]");
        return checkListService.requestDelete(seq);
    }
    /**
     * 체크리스트 수정  ( DTO 로 요청 받는 경우 )
     * 현재는 postman 과같은 툴을 이용해서만 테스트 가능
     * @param checkListDto checkListDto
     * @return ModelAndView
     */
    @PostMapping(value = "/update")
    public String doUpdate(CheckListDto checkListDto){
        log.info("[CheckListController -> doUpdate 수정 요청함]");
        return checkListService.doUpdate(checkListDto);
    }
}
