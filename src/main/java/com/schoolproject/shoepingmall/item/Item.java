package com.schoolproject.shoepingmall.item;

import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.board.dto.BoardUpdateDTO;
import com.schoolproject.shoepingmall.buy.Buy;
import com.schoolproject.shoepingmall.item.dto.ItemUpdateDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "item")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private int price;

    private int size;

    @OneToMany(mappedBy = "item")
    private List<Buy> buyList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id") // ManyToOne을 하면 JoinColumn을 꼭 해줘야 한다.
    private Board board;

    public void modify(ItemUpdateDTO itemUpdateDTO) {
        this.name = itemUpdateDTO.getName();
        this.price = itemUpdateDTO.getPrice();
        this.size = itemUpdateDTO.getSize();
    }

    @Builder
    public Item(String name, int price, int size, Board board) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.board = board;
        board.getItems().add(this);
    }

}
