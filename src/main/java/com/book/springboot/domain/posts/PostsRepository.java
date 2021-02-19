package com.book.springboot.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    Page<Posts> findAll(Pageable pageable);

    @Modifying
    @Query("UPDATE Posts p SET p.count = p.count + 1 WHERE id = ?1")
    int updateCount(Long id);
}