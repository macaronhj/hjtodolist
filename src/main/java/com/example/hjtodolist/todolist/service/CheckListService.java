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
        String registerResult = "투두리스트 등록 실패";
        if(result > 0 ){
            registerResult="투두리스트 등록 성공";
            log.info("[CheckListService -> registerRequest 리스트 등록 요청 성공함]");
        }
        return checkListMapper.findAll();
    }
    public List<CheckListDto> requestDelete(Long seq){
        int result = checkListMapper.requestDelete(seq);
        String registerResult = "투두리스트 삭제 실패";
        if(result > 0 ){
            registerResult = "투두리스트 삭제 성공";
            log.info("[CheckListService -> delete 리스트 삭제 요청 성공]");
        }
        return checkListMapper.findAll();
    }
    public CheckListDto updatePage(Long seq){return checkListMapper.updatePage(seq);}

    public List<CheckListDto> doUpdate(CheckListDto checkListDto){
        int result = checkListMapper.doUpdate(checkListDto);
        String updateRegister = "수정 실패";
        if(result>0){
            updateRegister="수정 성공";
            log.info("[BoarderService -> doUpdate 리스트 수정 요청 성공]");
        }
        return checkListMapper.findAll();
    }
}
