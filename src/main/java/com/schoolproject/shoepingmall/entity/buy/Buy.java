package com.schoolproject.shoepingmall.entity.buy;

import com.schoolproject.shoepingmall.entity.board.Board;
import com.schoolproject.shoepingmall.entity.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Buy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buy_id;

    private Long count;

    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

}
