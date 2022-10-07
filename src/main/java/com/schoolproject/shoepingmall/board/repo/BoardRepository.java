package com.schoolproject.shoepingmall.board.repo;

import com.schoolproject.shoepingmall.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
