package com.schoolproject.shoepingmall.board.repo;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.BoardListDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByPrizeNameContaining(String search);
}
