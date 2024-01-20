package sellyourunhappiness.core.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sellyourunhappiness.core.domain.Member;
import sellyourunhappiness.core.domain.enums.MemberType;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("멤버 가입")
    @Test
    public void register() {
        // given
        String name = "민규";
        String nickname = "mingyu";
        MemberType memberType = MemberType.one;

        Member input = Member.create(name, nickname, MemberType.one);

        //when
        Member member =memberRepository.save(input);

        // then
        assertThat(member.getName()).isEqualTo(name);
        assertThat(member.getNickname()).isEqualTo(nickname);
        assertThat(member.getGrade()).isEqualTo(memberType);
    }
}


