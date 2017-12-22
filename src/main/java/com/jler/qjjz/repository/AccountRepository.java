package com.jler.qjjz.repository;

import com.jler.qjjz.entity.AccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

    @Query("select t from AccountEntity t where t.uId=:uId")
    Iterable<AccountEntity> findByu(@Param("uId") Integer uId);
}
