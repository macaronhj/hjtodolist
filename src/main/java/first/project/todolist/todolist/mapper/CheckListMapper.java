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
    @Select("SELECT * FROM TODOLIST")
    List<CheckListDto> findAll();

    @Insert("INSERT INTO TODOLIST values (SEQ.NEXTVAL,#{todo},now(),#{deadline})")
    int registerRequest(CheckListDto checkListDto);

    @Delete("DELETE FROM TODOLIST WHERE SEQ = #{seq}")
    int requestDelete(Long seq);

    @Select("SELECT * FROM TODOLIST WHERE seq = #{seq}")
    CheckListDto updatePage(Long seq);

    @Update("UPDATE TODOLIST SET TODO=#{todo}, DEADLINE=#{deadline} WHERE seq = #{seq}")
    int doUpdate(CheckListDto checkListDto);
}
