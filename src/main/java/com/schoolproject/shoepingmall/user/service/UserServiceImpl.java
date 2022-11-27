package com.schoolproject.shoepingmall.user.service;

import com.schoolproject.shoepingmall.exception.DuplicateNameException;
import com.schoolproject.shoepingmall.exception.WrongIdException;
import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.dto.UserDeleteDTO;
import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import com.schoolproject.shoepingmall.user.dto.UserUpdateDTO;
import com.schoolproject.shoepingmall.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User join(UserInsertDTO userInsertDTO) {

        if(userRepository.existsByUsername(userInsertDTO.getUsername())){
            throw new DuplicateNameException(userInsertDTO.getUsername());
        }

        User user = User.builder()
                .username(userInsertDTO.getUsername())
                .password(userInsertDTO.getPassword())
                .build();
        userRepository.save(user);

        return user;
    }

//    @Override
//    public User update(UserUpdateDTO userUpdateDTO) {
//
//        //db user를 들고와
//        User user = userRepository.findById(userUpdateDTO.getId()).orElseThrow(() -> new WrongIdException(userUpdateDTO.getId()));
//
//        if(userRepository.existsByUsername(userUpdateDTO.getUsername()) &&
//        user.getUsername().equals(userUpdateDTO.getUsername())){
//            throw new DuplicateNameException(userUpdateDTO.getUsername());
//        }
//        //들고온 user를 수정
//        user.modify(userUpdateDTO.getUsername(), userUpdateDTO.getPassword());
//
//        return user;
//    }
//
//    @Override
//    public void delete(UserDeleteDTO userDeleteDTO) {
//        User user = userRepository.findById(userDeleteDTO.getId()).orElseThrow(() -> new WrongIdException(userDeleteDTO.getId()));
//
//        userRepository.delete(user);
//    }
}
