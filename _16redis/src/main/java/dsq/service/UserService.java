package dsq.service;

import dsq.entity.UserEntity;
import dsq.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by aa on 2019/7/15.
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserJPA userJPA;

    @Cacheable
    public List<UserEntity> list() {
        return userJPA.findAll();
    }

    @Cacheable
    public UserEntity getById(Long id) {
        UserEntity userEntity = null;
        Optional<UserEntity> optional = userJPA.findById(id);

        if(optional.isPresent()) {
            userEntity = optional.get();
        }
        return userEntity;
    }

    public UserEntity save(UserEntity entity) {
        return userJPA.save(entity);
    }

    public List<UserEntity> delete(Long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
