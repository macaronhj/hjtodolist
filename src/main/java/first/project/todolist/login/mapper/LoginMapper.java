package first.project.todolist.login.mapper;

import first.project.todolist.login.dto.MemberDto;
import first.project.todolist.todolist.dto.CheckListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
//    @Select("SELECT email, pwd FROM MEMBER where email=#{email}, pwd=#{pwd}")
//    MemberDto memberLogin(MemberDto memberDto);
    @Select("select * from member where memail=#{memail} and mpwd=#{mpwd}")
    MemberDto login(String memail, String mpwd);

    @Select("select * from member where memail=#{memail}")
    MemberDto getUser(String memail);
}
