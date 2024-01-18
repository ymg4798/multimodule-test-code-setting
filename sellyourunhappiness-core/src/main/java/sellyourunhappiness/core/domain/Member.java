package sellyourunhappiness.core.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sellyourunhappiness.core.domain.enums.MemberType;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column
    private MemberType grade;

    public Member(String name, String nickname, MemberType grade) {
        this.name = name;
        this.nickname = nickname;
        this.grade = grade;
    }

    public static Member create(String name, String nickname, MemberType grade) {
        return new Member(name, nickname, grade);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", grade=" + grade +
                '}';
    }
}


