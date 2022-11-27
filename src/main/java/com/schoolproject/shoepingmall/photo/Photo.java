package com.schoolproject.shoepingmall.photo;

import com.schoolproject.shoepingmall.board.Board;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Photo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originFile;

    private String filePath;

    private Long fileSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

}
