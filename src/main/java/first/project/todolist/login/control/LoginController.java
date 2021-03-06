package first.project.todolist.login.control;

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

    @GetMapping(value="/loginPage")
    public ModelAndView requestLogin(ModelAndView mv){
        log.info("Logincontroller -> requestLogin 로그인 시도 요청");
        mv.setViewName("/login/loginPage");
        return mv;
    }
    @GetMapping(value="/joinPage")
    public ModelAndView requestJoin(ModelAndView mv){
        log.info("Logincontroller -> requestJoin 회원가입 시도 요청");
        mv.setViewName("/login/joinPage");
        return mv;
    }
}
