package com.jler.qjjz.repository;

import com.jler.qjjz.entity.DetailTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailTypeRepository extends CrudRepository<DetailTypeEntity, Integer> {
}
