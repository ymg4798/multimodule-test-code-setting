package sellyourunhappiness.api.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sellyourunhappiness.api.dto.MemberResisterParam;
import sellyourunhappiness.core.application.MemberService;
import sellyourunhappiness.core.domain.Member;

@Service
@RequiredArgsConstructor
public class MemberBroker {

    private final MemberService memberService;

    public Member save(MemberResisterParam param) {
        return memberService.saveTest(param.getName(), param.getNickname(), param.getGrade());
    }

    public Member findById(Long id) {
        return memberService.findById(id);
    }
}
