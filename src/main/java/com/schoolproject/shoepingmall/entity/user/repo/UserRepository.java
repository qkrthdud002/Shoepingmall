package com.schoolproject.shoepingmall.entity.user.repo;

import com.schoolproject.shoepingmall.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
