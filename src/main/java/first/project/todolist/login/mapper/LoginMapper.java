package first.project.todolist.login.mapper;

import first.project.todolist.login.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
//    @Select("SELECT email, pwd FROM MEMBER where email=#{email}, pwd=#{pwd}")
//    MemberDto memberLogin(MemberDto memberDto);
}
