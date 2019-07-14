package dsq.controller;

import dsq.entity.UserEntity;
import dsq.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by aa on 2019/7/14.
 */

@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/login")
    public String login(UserEntity user, HttpServletRequest request) {
        //登录成功
        boolean flag = true;
        String result = "登录成功";
        Optional<UserEntity> optional = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //CriteriaQuery<?> name = criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getPwd()));

                //return null;
                //1.获取比较的属性
                Path<Object> custId = root.get("name");//查询的式属性名，不是表的字段名
                //2.构造查询条件  ：    select * from cst_customer where cust_id = 3
                /**
                 * 第一个参数：需要比较的属性（path对象）
                 * 第二个参数：当前需要比较的取值
                 */
                Predicate predicate = criteriaBuilder.equal(custId, user.getPwd());//进行精准的匹配  （比较的属性，比较的属性的取值）
                return predicate;
            }
        });
        UserEntity userEntity = null; //optional.get();
        if(optional.isPresent()) {
            userEntity = optional.get();
        }
       //用户不存在
        if(userEntity == null){
            flag = false;
            result = "用户不存在，登录失败";}
        //密码错误
        else if(!userEntity.getPwd().equals(user.getPwd())){
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        //登录成功
        if(flag){
            //将用户写入session
            request.getSession().setAttribute("_session_user",userEntity);
        }
        return result;
    }
}
