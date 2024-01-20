package sellyourunhappiness.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sellyourunhappiness.api.application.MemberBroker;
import sellyourunhappiness.api.dto.MemberResisterParam;
import sellyourunhappiness.core.application.MemberService;
import sellyourunhappiness.core.domain.Member;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberBroker memberBroker;

    private final MemberService memberService;

    @PostMapping("/v1/member")
    @ResponseStatus(HttpStatus.CREATED)
    public Member resister(@RequestBody MemberResisterParam param) {
        return memberBroker.save(param);
    }

    @GetMapping("/v1/member/{id}")
    public Member getMember(@PathVariable("id") Long id) {
        return memberBroker.findById(id);
    }

    @GetMapping("/v1/member/custom/{id}")
    public Member getMemberCustom(@PathVariable("id") Long id) {
        return memberService.findByIdQueryDsl(id);
    }
}
