package sellyourunhappiness.core.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sellyourunhappiness.core.domain.Member;
import sellyourunhappiness.core.domain.enums.MemberType;
import sellyourunhappiness.core.infrastructure.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(String name, String nickname, String grade) {
        Member member = Member.create(name, nickname, MemberType.valueOf(grade));
        memberRepository.save(member);
    }

    @Transactional
    public Member saveTest(String name, String nickname, String grade) {
        Member member = Member.create(name, nickname, MemberType.valueOf(grade));
        return memberRepository.save(member);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not exist. id : " + id));
    }

    public Member findByIdQueryDsl(Long id) {
        return memberRepository.getMember(id);
    }
}


