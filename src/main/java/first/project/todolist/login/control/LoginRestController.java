package first.project.todolist.login.control;

import first.project.todolist.login.dto.LoginDto;
import first.project.todolist.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/Login")
public class LoginRestController {
//    private final LoginService loginService;
//    @PostMapping(value="/signin")
//    public String requestLogin(LoginDto loginDto){
//        log.info("LoginRestController -> signin 로그인 시도 요청");
//        return loginService.requestLogin(loginDto);
//    }
}
