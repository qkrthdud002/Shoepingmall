package com.schoolproject.shoepingmall.user.service;

import com.schoolproject.shoepingmall.exception.DuplicateNameException;
import com.schoolproject.shoepingmall.user.User;
import com.schoolproject.shoepingmall.user.dto.UserInsertDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserServiceImplTest {

    @Autowired UserService userService;

    @Test
    @Rollback(false)
    void 회원가입() {

        UserInsertDTO userInsertDTO = createUserInsertDTO("kim");
        User user = userService.join(userInsertDTO);

        assertThat(user.getUsername()).isEqualTo(userInsertDTO.getUsername());
        assertThat(user.getPassword()).isEqualTo(userInsertDTO.getPassword());
    }

    @Test
    void 에러() {

        UserInsertDTO userInsertDTO = createUserInsertDTO("천사");
        User user = userService.join(userInsertDTO);

        assertThrows(DuplicateNameException.class, () -> {
            userService.join(userInsertDTO);
        });

    }

    private UserInsertDTO createUserInsertDTO(String username) {
        return UserInsertDTO.builder()
                .username(username)
                .password("1234")
                .build();
    }

}