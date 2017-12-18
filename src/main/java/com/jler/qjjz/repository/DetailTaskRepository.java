package com.jler.qjjz.repository;

import com.jler.qjjz.entity.DetailTaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailTaskRepository extends CrudRepository<DetailTaskEntity,Integer>{
}
