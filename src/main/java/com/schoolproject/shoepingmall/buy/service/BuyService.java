package com.schoolproject.shoepingmall.buy.service;

import com.schoolproject.shoepingmall.buy.Buy;
import com.schoolproject.shoepingmall.buy.dto.BuyDeleteDTO;
import com.schoolproject.shoepingmall.buy.dto.BuyInsertDTO;

public interface BuyService {
    public Buy insert(BuyInsertDTO buyInsetDTO);
    public Long delete(BuyDeleteDTO buyDeleteDTO);
}
