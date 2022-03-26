package first.project.todolist.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private Long memberSeq;
    private String memail;
    private String mname;
    private String mpwd;
    private int mcallnum;
    }
