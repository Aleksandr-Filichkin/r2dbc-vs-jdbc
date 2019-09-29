package com.filichkin.blog.db.blockingservice;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select * from blog.user limit :limit")
    List<User> findWithLimit(@Param("limit") int limit);
}
