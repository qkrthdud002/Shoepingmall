package com.schoolproject.shoepingmall.board.repo;

import com.schoolproject.shoepingmall.board.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByPrizeNameContaining(String search, Pageable pageable);
}
