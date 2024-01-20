package sellyourunhappiness.core.query;

import org.springframework.stereotype.Repository;
import sellyourunhappiness.core.config.QuerydslRepositorySupport;
import sellyourunhappiness.core.domain.Member;
import sellyourunhappiness.core.domain.QMember;
import sellyourunhappiness.core.infrastructure.MemberRepositoryCustom;

@Repository
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {

    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public Member getMember(Long id) {
        return selectFrom(QMember.member)
                .where(QMember.member.id.eq(id))
                .fetchOne();
    }

    /*
    private BooleanExpression stringContains(StringPath path, String value) {
        return hasText(value) ? path.contains(value) : null;
    }
     */

}
