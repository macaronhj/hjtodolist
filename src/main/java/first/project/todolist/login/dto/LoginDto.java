package first.project.todolist.login.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private Long memberSeq;
    private String email;
    private String name;
    private String pwd;
}
