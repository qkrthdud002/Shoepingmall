package com.schoolproject.shoepingmall.user.service;

import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.dto.UserDeleteDTO;
import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import com.schoolproject.shoepingmall.user.dto.UserUpdateDTO;

public interface UserService {

    /**
     * join : 회원가입
     * 수정 기능 업애기
     * delete : 로그아웃
     * */
    public User join(UserInsertDTO userInsertDTO);
//    public User update(UserUpdateDTO userUpdateDTO);
//    public void delete(UserDeleteDTO userDeleteDTO);
}
