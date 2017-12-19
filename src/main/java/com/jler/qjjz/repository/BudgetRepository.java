package com.jler.qjjz.repository;

import com.jler.qjjz.entity.BudgetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<BudgetEntity, Integer> {
}
