package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.UnionMember;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * 工会会员 repository
 * @author lxw
 */
@Repository
public interface UnionMemberRepository extends BaseRepository<UnionMember> {

}
