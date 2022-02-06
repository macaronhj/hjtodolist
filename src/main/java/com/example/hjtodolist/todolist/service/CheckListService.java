package com.example.hjtodolist.todolist.service;

import com.example.hjtodolist.todolist.dto.CheckListDto;
import com.example.hjtodolist.todolist.mapper.CheckListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckListService {
    private final CheckListMapper checkListMapper;

    public List<CheckListDto> findAll(){
        return checkListMapper.findAll();
    }

    public List<CheckListDto> registerRequest(CheckListDto checkListDto){
        int result = checkListMapper.registerRequest(checkListDto);
        String registerResult = "화장품 등록 실패";
        if(result > 0 ){
            registerResult="화장품 등록 성공";
            log.info("[BoarderService -> registerRequest 화장품 등록 요청 성공함]");
        }
        return checkListMapper.findAll();
    }
}
