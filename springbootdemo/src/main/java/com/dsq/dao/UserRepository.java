package com.dsq.dao;

import com.dsq.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by DELL on 2018/12/5.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    User findByUsernameOrEmail(String username, String email);

}
