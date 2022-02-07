package first.project.todolist.todolist.service;

import first.project.todolist.todolist.dto.CheckListDto;
import first.project.todolist.todolist.mapper.CheckListMapper;
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

    /**
     * [register]
     * 글 등록 후 리스트가 나오도록!!(selectAll)
     */
    public List<CheckListDto> registerRequest(CheckListDto checkListDto){
        int result = checkListMapper.registerRequest(checkListDto);
        String registerResult = "failed to register the todolist!";
        if(result > 0 ){
            registerResult="success to register the todolist!";
        }
        log.info("[CheckListService -> registerRequest 리스트 등록 요청 결과 -> {}]",registerResult);
        return checkListMapper.findAll();
    }


    /**
     * [Delete]
     * 삭제 후 해당 글을 제외한 나머지 리스트가 나오도록!!(selectAll)
     */
    public List<CheckListDto> requestDelete(Long seq){
        int result = checkListMapper.requestDelete(seq);
        String registerResult = "failed to delete the todolist!";
        if(result > 0 ){
            registerResult = "success to delete the todolist!";
        }
        log.info("[CheckListService -> delete 리스트 삭제 요청 결과 -> {}]",registerResult);
        return checkListMapper.findAll();
    }


    /**
     * [UpdatePage]
     * 수정할 글 선택 후 값을 바꿀 수 있음(select)
     */
    public CheckListDto updatePage(Long seq){return checkListMapper.updatePage(seq);}


    /**
     * [Update]
     * 바꾼 값으로 리스트 보여줌(selectAll)
     */
    public List<CheckListDto> doUpdate(CheckListDto checkListDto){
        int result = checkListMapper.doUpdate(checkListDto);
        String updateRegister = "failed to update the todolist!";
        if(result>0){
            updateRegister="success to update the todolist";
        }
        log.info("[BoarderService -> doUpdate 리스트 수정 요청 결과 -> {}]",updateRegister);
        return checkListMapper.findAll();
    }
}
