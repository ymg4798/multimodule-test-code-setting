package sellyourunhappiness.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResisterParam {
    private String name;
    private String nickname;
    private String grade;
}
