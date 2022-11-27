package com.schoolproject.shoepingmall.board;

import com.schoolproject.shoepingmall.item.Item;
import com.schoolproject.shoepingmall.photo.Photo;
import com.schoolproject.shoepingmall.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "board")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 15, name = "prize_name")
    private String prizeName;

    @Column(length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Item> items = new ArrayList<>();

    @OneToMany(
            mappedBy = "board",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    private List<Photo> photos = new ArrayList<>();

    @Builder
    public Board(String prizeName, String content, User user) {
        this.prizeName = prizeName;
        this.content = content;
        this.user = user;
        // this(자기 자신을 가리킴.)는 Board
        user.getBoardList().add(this); // User Entity에서 cascade설정을 하게 되면 생략 가능.
    }

    public void modify(String prizeName, String content) {
        this.prizeName = prizeName;
        this.content = content;
    }

    public void addPhoto(Photo photo) {
        System.out.println("=================== board add photo");
        this.photos.add(photo);

        if(photo.getBoard() != this)
            // 파일 저장
            photo.setBoard(this);
    }

}
