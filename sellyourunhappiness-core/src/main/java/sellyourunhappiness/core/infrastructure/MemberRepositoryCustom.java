package sellyourunhappiness.core.infrastructure;

import sellyourunhappiness.core.domain.Member;

public interface MemberRepositoryCustom {
    Member findByIdCustom(Long id);
}
