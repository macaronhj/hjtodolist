package first.project.todolist.login.control;

import first.project.todolist.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/Login")
public class LoginController {
    //private final LoginService loginService;

    @GetMapping(value="/requestLogin")
    public ModelAndView requestLogin(ModelAndView mv){
        log.info("Logincontroller -> requestLogin 로그인 시도 요청");
        mv.setViewName("/login/requestLogin");
        return mv;
    }
}
