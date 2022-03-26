package first.project.todolist.login.control;

import first.project.todolist.login.dto.MemberDto;
import static first.project.todolist.login.domain.LoginConst.*;

import first.project.todolist.login.mapper.LoginMapper;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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


//    @PostMapping("/login")
//    public String login(@ModelAttribute @Validated LoginForm loginForm,
//                        BindingResult bindingResult,
//                        @RequestParam(defaultValue = "/checkList/list") String redirectURL,
//                        HttpServletRequest request){
//        if(bindingResult.hasErrors()){
//            return "login/loginPage";
//        }
//        MemberDto loginMember = loginService.login(loginForm.getEmail(), loginForm.getPwd());
//        log.info("loginMember: "+loginMember);
//        if(loginMember == null){
//            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
//            return "login/loginPage";
//        }
//        // 로그인 성공 처리
//        HttpSession session = request.getSession();                         // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
//        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);   // 세션에 로그인 회원 정보 보관
//        return "redirect:" + redirectURL;
//    }
//    @PostMapping("/logout")
//    public String logout(HttpServletRequest request) {
//
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();   // 세션 날림
//        }
//
//        return "redirect:/";
//    }
        private final LoginService loginService;
        private final LoginMapper loginMapper;

        @PostMapping("login")
        private ModelAndView check(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
            String memail = request.getParameter("memail");
            String mpwd = request.getParameter("mpwd");
            ModelAndView mv = new ModelAndView();
            //유효성 검사(클라이언트측 View:js, 서버측 Controller:java)
            log.info("loginCon check //email: "+memail+", pwd: "+mpwd);
            int result = loginService.login(memail, mpwd);
            log.info("로그인 결과(1>성공) : " + result);

            if(result == YES_ID_PWD) { //로그인 성공시
                log.info("로그인 성공");
                MemberDto m = loginMapper.getUser(memail);
                session = request.getSession();
                mv.addObject("msg", "success");
                session.setAttribute("memail", memail);
                mv.setViewName("redirect:/checkList/list");
                session.setAttribute("loginOkUser", m);
                log.info("m: "+m);
            }else { // 로그인 실패시
                log.info("로그인 실패");
                mv.setViewName("login_check_module");
            }
            return mv;
        }

}
