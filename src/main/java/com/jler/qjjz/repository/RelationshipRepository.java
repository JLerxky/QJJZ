package com.jler.qjjz.repository;

import com.jler.qjjz.entity.RelationshipEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends CrudRepository<RelationshipEntity, Integer> {
}
