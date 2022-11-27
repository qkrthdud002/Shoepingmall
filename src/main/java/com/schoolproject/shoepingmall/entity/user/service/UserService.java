package com.schoolproject.shoepingmall.entity.user.service;

import com.schoolproject.shoepingmall.entity.user.User;
import com.schoolproject.shoepingmall.entity.user.dto.UserInsertDTO;

public interface UserService {
    public User join(UserInsertDTO userInsertDTO);
}
