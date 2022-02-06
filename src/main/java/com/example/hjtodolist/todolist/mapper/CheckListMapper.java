package com.example.hjtodolist.todolist.mapper;

import com.example.hjtodolist.todolist.dto.CheckListDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CheckListMapper {
    @Select("SELECT * FROM TODOLIST")
    List<CheckListDto> findAll();

    @Insert("INSERT INTO TODOLIST values (SEQ.NEXTVAL,#{todo},now(),now())")
    int registerRequest(CheckListDto checkListDto);

    @Delete("DELETE FROM TODOLIST WHERE SEQ = #{seq}")
    int requestDelete(Long seq);
}
