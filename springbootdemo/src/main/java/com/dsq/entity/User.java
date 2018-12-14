package com.dsq.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by DELL on 2018/12/5.
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {

    public User(String username, String email, String nickName, String password, String regTime) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String regTime;

}
