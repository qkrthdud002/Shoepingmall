package com.schoolproject.shoepingmall.item.service;

import com.schoolproject.shoepingmall.exception.WrongIdException;
import com.schoolproject.shoepingmall.item.Item;
import com.schoolproject.shoepingmall.item.dto.ItemDeleteDTO;
import com.schoolproject.shoepingmall.item.dto.ItemInsertDTO;
import com.schoolproject.shoepingmall.item.dto.ItemUpdateDTO;
import com.schoolproject.shoepingmall.item.repo.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public Item insert(ItemInsertDTO itemInsertDTO) {

        Item item = Item.builder()
                .name(itemInsertDTO.getName())
                .price(itemInsertDTO.getPrice())
                .size(itemInsertDTO.getSize())
                .quantity(itemInsertDTO.getQuantity())
                .build();

        return itemRepository.save(item);
    }

    @Override
    public Item update(ItemUpdateDTO itemUpdateDTO) { // 상품의 갯수가 매진되면 채워야 되니까

        Item item = itemRepository.findById(itemUpdateDTO.getId()).orElseThrow(() -> new WrongIdException("item", itemUpdateDTO.getId()));

        item.modify(itemUpdateDTO);

        return item;
    }

    @Override
    public Long delete(ItemDeleteDTO itemDeleteDTO) {

        Item item = itemRepository.findById(itemDeleteDTO.getId()).orElseThrow(() -> new WrongIdException("item", itemDeleteDTO.getId()));
        itemRepository.delete(item);

        return item.getId();
    }
}
