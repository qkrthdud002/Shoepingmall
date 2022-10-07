package com.schoolproject.shoepingmall.item.repo;

import com.schoolproject.shoepingmall.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
