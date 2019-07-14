package dsq.controller;

import dsq.entity.UserEntity;
import dsq.jpa.UserJPA;
import dsq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * Created by aa on 2019/7/13.
 */

@RestController
@RequestMapping(value = "/user" )
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)

    public List<UserEntity> list() {
        return userService.list();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public UserEntity get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public UserEntity save(UserEntity entity) {
        return userService.save(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<UserEntity> delete(Long id) {
        return userService.delete(id);
    }
}
