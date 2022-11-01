package com.schoolproject.shoepingmall.item.service;

import com.schoolproject.shoepingmall.item.Item;
import com.schoolproject.shoepingmall.item.dto.ItemDeleteDTO;
import com.schoolproject.shoepingmall.item.dto.ItemInsertDTO;
import com.schoolproject.shoepingmall.item.dto.ItemUpdateDTO;

public interface ItemService {
    public Item insert(ItemInsertDTO itemInsertDTO);
    public Item update(ItemUpdateDTO itemUpdateDTO);
    public Long delete(ItemDeleteDTO itemDeleteDTO);
}
