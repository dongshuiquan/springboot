package com.dsq.controller;

import com.dsq.entiry.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by aa on 2019/7/14.
 */

@RestController
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "validator")
    public String validator(@Valid DemoEntity entity, BindingResult result) {
        if(result.hasErrors()) {
            StringBuilder msg = new StringBuilder();
            List<FieldError> fieldErrors = result.getFieldErrors();
            Locale locale = LocaleContextHolder.getLocale();
            for(FieldError fieldError: fieldErrors) {
                String errorMessage = messageSource.getMessage(fieldError, locale);
                msg.append(fieldError.getField() + " : " + errorMessage + ",");
            }
            return msg.toString();
        }
        return "验证通过，名称 ： " + entity.getName() + " 年龄： " + entity.getAge() + "邮件地址：" + entity.getMail();

    }
}
