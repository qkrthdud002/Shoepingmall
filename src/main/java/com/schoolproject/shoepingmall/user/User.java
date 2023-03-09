package com.schoolproject.shoepingmall.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolproject.shoepingmall.authority.Authority;
import com.schoolproject.shoepingmall.board.Board;
import com.schoolproject.shoepingmall.buy.Buy;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column
    private String username;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;

//    @Column(name = "activated")
//    private boolean activated;

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
    public User(String username, String password, Set<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public void modify(String username, String password) {
        this.username = username;
        this.password = password;
    }

}



