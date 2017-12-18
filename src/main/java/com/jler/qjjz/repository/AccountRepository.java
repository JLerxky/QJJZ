package com.jler.qjjz.repository;

import com.jler.qjjz.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity ,Integer> {
}
