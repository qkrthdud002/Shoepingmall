package com.schoolproject.shoepingmall.user.service;

import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.dto.UserDeleteDTO;
import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import com.schoolproject.shoepingmall.user.dto.UserUpdateDTO;

public interface UserService {
    public User join(UserInsertDTO userInsertDTO);
    public User update(UserUpdateDTO userUpdateDTO);
    public void delete(UserDeleteDTO userDeleteDTO);
}
