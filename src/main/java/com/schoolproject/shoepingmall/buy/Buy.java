package com.schoolproject.shoepingmall.buy;

import com.schoolproject.shoepingmall.buy.dto.BuyUpdateDTO;
import com.schoolproject.shoepingmall.item.Item;
import com.schoolproject.shoepingmall.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Buy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyId;

    private int count;

    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Buy() {

    }

    public void modify(BuyUpdateDTO buyUpdateDTO) {
        this.count = count;
        this.price = price;
    }
}