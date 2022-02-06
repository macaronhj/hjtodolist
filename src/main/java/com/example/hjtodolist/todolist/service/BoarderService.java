package com.example.hjtodolist.todolist.service;


import com.example.hjtodolist.todolist.dto.BoarderDto;
import com.example.hjtodolist.todolist.mapper.BoarderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class BoarderService {
    private final BoarderMapper boarderMapper;

    public List<BoarderDto> boarder() {
        return boarderMapper.boarder();
    }

    public List<BoarderDto> registerRequest(BoarderDto boardDto) {
        int result = boarderMapper.registerRequest(boardDto);
        String registerResult = "화장품 등록 실패";

        if (result > 0) {
            registerResult = "화장품 등록 완료!!!";
            log.info("ManageService > registerCos 화장품 등록 요청 성공");
        }
        return boarderMapper.boarder();
    }
    public List<BoarderDto> delete(Long seq){
        int result = boarderMapper.delete(seq);
        String registerResult = "delete fail";

        if(result>0){
            registerResult = "delete success";
            log.info("[BoarderService > deleteUser 사용자 삭제 요청 성공]");
        }
        return boarderMapper.boarder();
    }
    public BoarderDto update1(Long seq){
        return boarderMapper.update1(seq);
    }

    public List<BoarderDto> update2(BoarderDto boardDto){
        log.info("[BoarderService > updateU2 사용자 수정 시도]");
        int result = boarderMapper.update2(boardDto);
        log.info("[BoarderService > updateU2 사용자 수정 시도2]");
        String registerResultU = "update fail";

        if(result>0){
            registerResultU = "update success";
        }
        log.info(registerResultU);
        log.info("[BoarderService > updateU2 사용자 수정 시도3]");
        return boarderMapper.boarder();
    }
}
