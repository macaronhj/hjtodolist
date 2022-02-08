package first.project.todolist.todolist.service;

import first.project.todolist.todolist.dto.CheckListDto;
import first.project.todolist.todolist.mapper.CheckListMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * packageName : first.project.todolist.service
 * fileName : CheckListService
 * author : heejin
 * date : 2022-02-06
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-06           heejin             최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CheckListService {
    private final CheckListMapper checkListMapper;

    /**
     * 전체 체크리스트 요청
     * @return   List<CheckListDto>
     */
    public List<CheckListDto> findAll(){
        return checkListMapper.findAll();
    }


    /**
     * 체크리스트정보 등록, 결과 문구 리턴
     * @param checkListDto checkListDto
     * @return List<checkListDto>
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
     * 체크리스트 삭제 요청 처리
     * @param seq seq
     * @return List<checkListDto>
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
     * seq에 해당하는 사용자 조회
     * @return CheckListDto
     */
    public CheckListDto updatePage(Long seq){return checkListMapper.updatePage(seq);}


    /**
     * 체크리스트정보 수정, 결과 문구 리턴
     * @param checkListDto checkListDto
     * @return List<checkListDto>
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
