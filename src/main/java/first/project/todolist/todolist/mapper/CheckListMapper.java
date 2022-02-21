package first.project.todolist.todolist.mapper;

import first.project.todolist.todolist.dto.CheckListDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * packageName : first.project.todolist.mapper
 * fileName : CheckListMapper
 * author : heejin
 * date : 2022-02-06
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-06           heejin             최초 생성
 */
@Mapper
public interface CheckListMapper {
    @Select("SELECT * FROM todolist")
    List<CheckListDto> findAll();

    @Insert("INSERT INTO todolist(seq, todo, create, startdate, deadline) VALUES (seq.NEXTVAL,#{todo},now(),#{startdate},#{deadline})")
    int registerRequest(CheckListDto checkListDto);

    @Delete("DELETE FROM todolist WHERE seq = #{seq}")
    int requestDelete(Long seq);

    @Select("SELECT * FROM todolist WHERE seq = #{seq}")
    CheckListDto updatePage(Long seq);

    @Update("UPDATE todolist SET todo=#{todo}, deadline=#{deadline} WHERE seq = #{seq}")
    int doUpdate(CheckListDto checkListDto);
}
