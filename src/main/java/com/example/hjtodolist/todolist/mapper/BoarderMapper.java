package com.example.hjtodolist.todolist.mapper;

import com.example.hjtodolist.todolist.dto.BoarderDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BoarderMapper {
    @Select("SELECT * FROM COSMETIC")
    List<BoarderDto> boarder();

    @Insert("INSERT INTO COSMETIC(SEQ, NAME, COUNT, COMPANY, SALE) VALUES (SEQ.NEXTVAL,#{name},#{count},#{company},#{sale})")
    int registerRequest(BoarderDto boardDto);

    @Delete("DELETE FROM COSMETIC WHERE seq = #{seq}")
    int delete(Long seq);

    @Select("SELECT * FROM COSMETIC where seq = #{seq}")
    BoarderDto update1(Long seq);

    @Update("UPDATE COSMETIC SET NAME=#{name}, COUNT=#{count}, COMPANY=#{company}, SALE=#{sale} WHERE seq = #{seq}")
    int update2(BoarderDto boardDto);
}
