package com.schoolproject.shoepingmall.user;

import com.schoolproject.shoepingmall.authority.Authority;
import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.buy.Buy;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 25, nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")}
    )
    private Set<Authority> authorities;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Buy> buy;

    @Builder
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void modify(String username, String password) {
        this.username = username;
        this.password = password;
    }

}



