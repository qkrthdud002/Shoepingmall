package com.schoolproject.shoepingmall.board;

import com.schoolproject.shoepingmall.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "board")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(length = 15, nullable = false, name = "prize_name")
    private String prizeName;

    @Column(length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Board(String prizeName, String content, User user) {
        this.prizeName = prizeName;
        this.content = content;
        this.user = user;
        // this(자기 자신을 가리킴.)는 Board
        user.getBoardList().add(this);
    }

    public void modify(String prizeName, String content) {
        this.prizeName = prizeName;
        this.content = content;
    }

}
