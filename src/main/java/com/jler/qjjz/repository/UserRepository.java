package com.jler.qjjz.repository;

import com.jler.qjjz.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "users")
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<UsersEntity, Integer> {

    UsersEntity findById(int id);

    UsersEntity findByUName(String uName);

    UsersEntity findByUId(String uId);

    UsersEntity save(UsersEntity u);

    @Query("select t from UsersEntity t where t.uName=:uName")
    UsersEntity findUserByName(@Param("uName") String uName);

}
