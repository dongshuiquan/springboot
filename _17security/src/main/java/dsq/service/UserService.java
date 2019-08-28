package dsq.service;

import dsq.entity.UserEntity;
import dsq.entity.UserEntity2;
import dsq.jpa.UserJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by aa on 2019/7/15.
 */
public class UserService implements UserDetailsService
{

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserJPA userJPA;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        UserEntity user = userJPA.findByUsername(username);
//        if(user == null)
//        {
//            throw new UsernameNotFoundException("未查询到用户："+username+"信息！");
//        }
//        return user;

        String password = passwordEncoder.encode("123456");
        logger.info("password : " + password);
        UserEntity2 user = new UserEntity2(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}