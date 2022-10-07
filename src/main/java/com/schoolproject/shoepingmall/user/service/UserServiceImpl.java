package com.schoolproject.shoepingmall.user.service;

import com.schoolproject.shoepingmall.exception.DuplicateNameException;
import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.dto.UserDeleteDTO;
import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import com.schoolproject.shoepingmall.user.dto.UserUpdateDTO;
import com.schoolproject.shoepingmall.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User join(UserInsertDTO userInsertDTO) {

        if(userRepository.existsByUsername(userInsertDTO.getUsername())){
            throw new DuplicateNameException("이름 중복");
        }

        User user = User.builder()
                .username(userInsertDTO.getUsername())
                .password(userInsertDTO.getPassword())
                .build();
        userRepository.save(user);

        return user;
    }

    @Override
    public User update(UserUpdateDTO userUpdateDTO) {
        return null;
    }

    @Override
    public void delete(UserDeleteDTO userDeleteDTO) {

    }
}
