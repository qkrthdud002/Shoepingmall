package com.schoolproject.shoepingmall.buy.service;

import com.schoolproject.shoepingmall.buy.Buy;
import com.schoolproject.shoepingmall.buy.dto.BuyDeleteDTO;
import com.schoolproject.shoepingmall.buy.dto.BuyInsertDTO;
import com.schoolproject.shoepingmall.buy.repo.BuyRepository;
import com.schoolproject.shoepingmall.exception.BuyCountException;
import com.schoolproject.shoepingmall.exception.WrongIdException;
import com.schoolproject.shoepingmall.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BuyServiceImpl implements BuyService{

    private final BuyRepository buyRepository;

    private final UserRepository userRepository;

    @Override
    public Buy insert(BuyInsertDTO buyInsertDTO) {

        if(buyInsertDTO.getCount() <= 0) {
            log.error("수량이 0이하 입니다. {}", buyInsertDTO.getCount());

            throw new BuyCountException(buyInsertDTO.getCount());
        }

        Buy buy = Buy.builder()
                .count(buyInsertDTO.getCount())
                .price(buyInsertDTO.getPrice())
                .build();

        return buyRepository.save(buy);
    }

    @Override
    public Long delete(BuyDeleteDTO buyDeleteDTO) {

        Buy buy = buyRepository.findById(buyDeleteDTO.getBuyId()).orElseThrow(() -> new WrongIdException("buy", buyDeleteDTO.getBuyId()));

        buyRepository.delete(buy);

        return buy.getBuyId();
    }
}
