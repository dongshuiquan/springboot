package com.dsq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by aa on 2019/7/24.
 */

@RestController
public class DataSourceController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "dataSource")
    public String getDataSource() {
        return  dataSource.toString();
    }
}
