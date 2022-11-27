package com.schoolproject.shoepingmall.buy;

import com.schoolproject.shoepingmall.item.Item;
import com.schoolproject.shoepingmall.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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
}