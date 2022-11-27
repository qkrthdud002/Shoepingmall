package com.schoolproject.shoepingmall.photo.repo;

import com.schoolproject.shoepingmall.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
