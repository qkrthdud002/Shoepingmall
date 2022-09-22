package com.schoolproject.shoepingmall.repository;

import com.schoolproject.shoepingmall.entity.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
