package com.schoolproject.shoepingmall.item;

import com.schoolproject.shoepingmall.buy.Buy;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "item")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    private Long price;

    private Long size;

    @OneToMany(mappedBy = "item")
    private List<Buy> buyList = new ArrayList<>();

}
