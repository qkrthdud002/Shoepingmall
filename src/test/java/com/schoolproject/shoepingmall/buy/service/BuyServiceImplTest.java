package com.schoolproject.shoepingmall.buy.service;

import com.schoolproject.shoepingmall.buy.Buy;
import com.schoolproject.shoepingmall.buy.dto.BuyDeleteDTO;
import com.schoolproject.shoepingmall.buy.dto.BuyInsertDTO;
import com.schoolproject.shoepingmall.exception.BuyCountException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
class BuyServiceImplTest {

    @Autowired
    BuyService buyService;

    @Test
    void 저장() {
        BuyInsertDTO buyInsertDTO = createBuyInsertDTO(2);

        Buy buy = buyService.insert(buyInsertDTO);

        assertThat(buyInsertDTO.getCount()).isEqualTo(buy.getCount());
    }

    @Test
    void 예외처리() {
        BuyInsertDTO buyInsertDTO = createBuyInsertDTO(0);

        assertThrows(BuyCountException.class, () -> {
            buyService.insert(buyInsertDTO);
        });
    }

    @Test
    void 삭제() {

        Buy buy = buyService.insert(createBuyInsertDTO(3));
        BuyDeleteDTO buyDeleteDTO = dropBuyDeleteDTO(buy.getBuyId());

        Long delete = buyService.delete(buyDeleteDTO);

        assertThat(buyDeleteDTO.getBuyId()).isEqualTo(buy.getBuyId()).isEqualTo(delete);
    }

    private BuyInsertDTO createBuyInsertDTO(int count) {
        BuyInsertDTO buyInsertDTO = BuyInsertDTO.builder()
                .count(count)
                .price(12344)
                .build();

        return buyInsertDTO;
    }

    private BuyDeleteDTO dropBuyDeleteDTO(Long buyId) {
        BuyDeleteDTO buyDeleteDTO = BuyDeleteDTO.builder()
                .buyId(buyId)
                .build();

        return buyDeleteDTO;
    }

}