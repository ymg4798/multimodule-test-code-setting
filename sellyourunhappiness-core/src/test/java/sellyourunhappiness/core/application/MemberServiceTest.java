package sellyourunhappiness.core.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sellyourunhappiness.core.domain.Member;
import sellyourunhappiness.core.domain.enums.MemberType;
import sellyourunhappiness.core.infrastructure.MemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // 비즈니스 로직 테스트
class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @DisplayName("회원 가입 성공 - Mock")
    @Test
    void registerMock() {
        // given
        String name = "민규";
        String nickname = "mingyu";
        MemberType memberType = MemberType.one;

        Member input = Member.create(name, nickname, MemberType.one);

        when(memberRepository.save(any(Member.class))).thenReturn(input);

        // when
        Member member = memberService.saveTest(name, nickname, memberType.toString());

        // then
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getNickname()).isEqualTo(nickname);
        assertThat(member.getGrade()).isEqualTo(memberType);
    }
}


