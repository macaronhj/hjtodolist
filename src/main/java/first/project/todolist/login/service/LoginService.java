package first.project.todolist.login.service;

import first.project.todolist.login.dto.MemberDto;
import first.project.todolist.login.dto.MemberRepository;
import first.project.todolist.login.mapper.LoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
//    private final LoginMapper loginMapper;
//    public MemberDto memberLogin(MemberDto memberDto){
//        return loginMapper.memberLogin(memberDto);
//    }
    private final MemberRepository memberRepository;

    public MemberDto login(String email, String pwd){
        return memberRepository.findByEmail(email)
                .filter(m -> m.getPwd().equals(pwd))
                .orElse(null);
    }
    //이 로그인 로직은 앞서 구현한 MemberRepository#findByLoginId로 회원을 조회한 다음에 파라미터로 넘어온 password와 비교해서 같으면 Member 인스턴스를 반환하고, password가 다르면 null을 반환한다.
}
