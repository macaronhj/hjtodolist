package first.project.todolist.login.control;

import first.project.todolist.login.dto.LoginForm;
import first.project.todolist.login.dto.MemberDto;
import first.project.todolist.login.service.LoginService;
import first.project.todolist.login.session.SessionConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/Login")
public class LoginRestController {
//    private final LoginService loginService;
//    @PostMapping(value="/requestLogin")
//    public String requestLogin(MemberDto memberDto, HttpServletRequest request, RedirectAttributes rttr)
//    throws Exception{
//        log.info("LoginRestController -> signin 로그인 시도 요청");
//        HttpSession session = request.getSession();
//          MemberDto member = loginService.memberLogin(memberDto);
//          if(member == null){
//              session.setAttribute("member",null);
//              rttr.addFlashAttribute("msg",false);
//          }else session.setAttribute("member", member);
//        return "checkList/list";
//    }
    private final LoginService loginService;

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
                        BindingResult bindingResult,
                        @RequestParam(defaultValue = "/checkList/list") String redirectURL,
                        HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/loginPage";
        }
        MemberDto loginMember = loginService.login(loginForm.getEmail(), loginForm.getPwd());
        log.info("loginMember: "+loginMember);
        if(loginMember == null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginPage";
        }
        // 로그인 성공 처리
        HttpSession session = request.getSession();                         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);   // 세션에 로그인 회원 정보 보관
        return "redirect:" + redirectURL;
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();   // 세션 날림
        }

        return "redirect:/";
    }
}
