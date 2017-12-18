package com.jler.qjjz.repository;

import com.jler.qjjz.entity.DetailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends CrudRepository<DetailEntity,Integer> {
}
