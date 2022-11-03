package com.schoolproject.shoepingmall.board.dto;

import com.schoolproject.shoepingmall.item.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class BoardViewDTO {

    private Long id;

    private String prizeName;

    private int price;

    private List<Integer> sizes;

}
