package com.schoolproject.shoepingmall.user.repo;

import com.schoolproject.shoepingmall.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
