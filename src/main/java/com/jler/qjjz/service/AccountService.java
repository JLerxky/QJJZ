package com.jler.qjjz.service;

import com.jler.qjjz.entity.AccountEntity;
import com.jler.qjjz.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    public AccountRepository accountRepository;

    public AccountEntity add(AccountEntity accountEntity){
        return accountRepository.save(accountEntity);
    }

    public AccountEntity update(AccountEntity accountEntity){
        return accountRepository.save(accountEntity);
    }

    public void delete(AccountEntity accountEntity){
        accountRepository.delete(accountEntity);
    }

    public Iterable<AccountEntity> findAllByuId (Integer uid){
        return accountRepository.findByu(uid);
    }
}
