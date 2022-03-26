package first.project.todolist.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long memberSeq;
    private String memail;
    private String mname;
    private String mpwd;
    private int mcallnum;
    }
