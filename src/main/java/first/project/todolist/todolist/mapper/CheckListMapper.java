package first.project.todolist.todolist.mapper;

import first.project.todolist.todolist.dto.CheckListDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CheckListMapper {
    @Select("SELECT * FROM TODOLIST")
    List<CheckListDto> findAll();

    @Insert("INSERT INTO TODOLIST values (SEQ.NEXTVAL,#{todo},now(),#{deadline})")
    int registerRequest(CheckListDto checkListDto);

    @Delete("DELETE FROM TODOLIST WHERE SEQ = #{seq}")
    int requestDelete(Long seq);

    @Select("SELECT TODO, deadline FROM TODOLIST WHERE seq = #{seq}")
    CheckListDto updatePage(Long seq);

    @Update("UPDATE TODOLIST SET TODO=#{todo}, DEADLINE=#{deadline} WHERE seq = #{seq}")
    int doUpdate(CheckListDto checkListDto);
}
