package sellyourunhappiness.core.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sellyourunhappiness.core.domain.Member;

public interface MemberRepository extends JpaRepository <Member, Long>, MemberRepositoryCustom {
}
