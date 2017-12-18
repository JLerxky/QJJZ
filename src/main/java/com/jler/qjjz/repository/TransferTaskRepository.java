package com.jler.qjjz.repository;

import com.jler.qjjz.entity.TransferTaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferTaskRepository extends CrudRepository<TransferTaskEntity,Integer>{
}
