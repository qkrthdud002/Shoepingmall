package com.schoolproject.shoepingmall.photo;

import com.schoolproject.shoepingmall.board.Board;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Photo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    private String originFile;

    private String filePath;

    private Long fileSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Photo(String originFile, String filePath, Long fileSize) {
        this.originFile = originFile;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    // Board 정보 저장
    public void setBoard(Board board) {
        this.board = board;

        // 게시글에 현재 파일이 존재하지 않는다면
        // TODO 기억하세용
        // TODO 기억해라
        if(!board.getPhotos().contains(this))
            // 파일 추가
            board.getPhotos().add(this);
    }

}
