package com.example.legomanagerbe.model;

import com.example.legomanagerbe.model.Decentralization.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    private Boolean gender;

    @Column(columnDefinition = "varchar(100)")
    private String email;

    private String address;

    @Column(columnDefinition = "varchar(30)")
    private String phoneNumber;

    private String dayOfBirth;

    @Column(columnDefinition = "varchar(30)")
    private String idCard;

    @Column(columnDefinition = "text")
    private String imgUrl;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

}
