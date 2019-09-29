package com.filichkin.blog.db.reactive;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface R2DBCSubscriptionRepository extends R2dbcRepository<User, Long> {
    @Query("select * from blog.user  limit $1")
    Flux<User> findWithLimit(int limit);
}
