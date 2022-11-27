package com.schoolproject.shoepingmall.item.repo;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByBoard(Board board);

}
