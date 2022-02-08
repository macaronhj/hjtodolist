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

    /**
     * @return     todolist table에 담겨있는 모든 정보 (selectAll)
     */

    public List<CheckListDto> findAll(){
        return checkListMapper.findAll();
    }

    /**
     *
     * @param checkListDto todo, deadline을 입력받아 등록하기 위해 씀
     * @return             등록한 값을 리스트에 담아 전체 리스트를 뽑음
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
     *
     * @param seq   삭제하고자 하는 row의 인덱스 값
     * @return      삭제한 것을 제외한 모든 리스트를 뽑음
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
     *
     * @param seq   수정하고자 하는 row의 인덱스 값
     * @return      특정 인덱스의 'todo', 'deadline'의 정보
     *              'todo'와 'dealine' 수정을 가능케 함
     */

    public CheckListDto updatePage(Long seq){return checkListMapper.updatePage(seq);}


    /**
     *
     * @param checkListDto    수정하고자 특정 row의 'todo','deadline'의 정보
     * @return                수정하고 나서의 값으로 전체 리스트를 뽑음
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
