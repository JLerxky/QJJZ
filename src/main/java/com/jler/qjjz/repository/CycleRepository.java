package com.jler.qjjz.repository;

import com.jler.qjjz.entity.CycleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CycleRepository extends CrudRepository<CycleEntity,Integer> {
}
