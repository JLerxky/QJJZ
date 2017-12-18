package com.jler.qjjz.repository;

import com.jler.qjjz.entity.MessageTaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageTaskRepository extends CrudRepository<MessageTaskEntity,Integer>{
}
