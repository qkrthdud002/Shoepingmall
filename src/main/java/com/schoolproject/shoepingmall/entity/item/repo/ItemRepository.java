package com.schoolproject.shoepingmall.entity.item.repo;

import com.schoolproject.shoepingmall.entity.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
