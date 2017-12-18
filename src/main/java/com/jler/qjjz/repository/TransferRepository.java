package com.jler.qjjz.repository;

import com.jler.qjjz.entity.TransferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<TransferEntity,Integer>{
}
