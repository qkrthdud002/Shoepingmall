package com.schoolproject.shoepingmall.repository;

import com.schoolproject.shoepingmall.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
