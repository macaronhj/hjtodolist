package first.project.todolist.todolist.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * packageName : first.project.todolist.dto
 * fileName : CheckListDto
 * author : heejin
 * date : 2022-02-06
 * description :
 * ===========================================================
 * DATE                  AUTHOR                  NOTE
 * -----------------------------------------------------------
 * 2022-02-06           heejin             최초 생성
 */
@Getter
@Setter
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CheckListDto {

    /**
     * createAt: 작성한 날짜
     * deadline: 기한
     */

    private Long seq;
    private String todo;
    private Date create;
    private String startdate;
    private String deadline;
}