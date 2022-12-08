package com.example.legomanagerbe.model.Decentralization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

//    public User() {
//    }
//
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public User(String username, String password, boolean isEnable, boolean isDelete, List<Role> roles) {
//        this.username = username;
//        this.password = password;
//        this.isDelete = isDelete;
//        this.roles = roles;
//    }

}
