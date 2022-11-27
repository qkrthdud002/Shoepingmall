package com.schoolproject.shoepingmall.item.service;

import com.schoolproject.shoepingmall.exception.WrongIdException;
import com.schoolproject.shoepingmall.item.Item;
import com.schoolproject.shoepingmall.item.dto.ItemDeleteDTO;
import com.schoolproject.shoepingmall.item.dto.ItemInsertDTO;
import com.schoolproject.shoepingmall.item.dto.ItemUpdateDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ItemServiceImplTest {

    @Autowired
    private ItemService itemService;

    @Test
    @Rollback(false)
    void 등록() {
        ItemInsertDTO itemInsertDTO = ItemInsertDTO.builder()
                .name("aaaa")
                .price(1234)
                .size(123)
                .quantity(2)
                .boardId(1L)
                .build();

        Item item = itemService.insert(itemInsertDTO);

        assertThat(itemInsertDTO.getName()).isEqualTo(item.getName());

    }

    @Test
    void 수정() {
        Item item = createdItem();

        ItemUpdateDTO itemUpdateDTO = ItemUpdateDTO.builder()
                .name("bbb")
                .price(124)
                .size(333)
                .quantity(2)
                .id(item.getId())
                .build();

        Item updateItem = itemService.update(itemUpdateDTO);

        assertThat(item.getName()).isEqualTo(itemUpdateDTO.getName()).isEqualTo(updateItem.getName());

    }

    @Test
    void 수정예외() {
        Item item = createdItem();

        ItemUpdateDTO itemUpdateDTO = ItemUpdateDTO.builder()
                .id(item.getId() + 1)
                .name("asdf")
                .price(1234)
                .quantity(3)
                .build();

        assertThrows(WrongIdException.class, () -> itemService.update(itemUpdateDTO));
    }

    @Test
    void 삭제() {
        Item item = createdItem();

        ItemDeleteDTO itemDeleteDTO = ItemDeleteDTO.builder()
                .id(item.getId())
                .build();

        itemService.delete(itemDeleteDTO);

        assertThat(item.getId()).isEqualTo(itemDeleteDTO.getId());
    }

    @Test
    void 삭제예외() {
        Item item = createdItem();

        ItemDeleteDTO itemDeleteDTO = ItemDeleteDTO.builder()
                .id(item.getId() + 1)
                .build();

        assertThrows(WrongIdException.class, () -> itemService.delete(itemDeleteDTO));
    }

    public Item createdItem() {
        ItemInsertDTO itemInsertDTO = ItemInsertDTO.builder()
                .name("aaaa")
                .price(1234)
                .size(123)
                .quantity(2)
                .build();

        return itemService.insert(itemInsertDTO);

    }

}