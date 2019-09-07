package com.dsq.transation;

import com.dsq.transation.service.InvokeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by DELL on 2018/12/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvokeServiceTest {

    @Autowired
    private InvokeService invokeService;

    @Before
    public void before() {
        invokeService.deleteAll();
    }

    @Test(expected = RuntimeException.class)
    public void notransaction_exception_required_required() throws Exception {
        invokeService.notransaction_exception_required_required();
    }

    @Test(expected = RuntimeException.class)
    public void notransaction_required_required_exception() throws Exception {
        invokeService.notransaction_required_required_exception();
    }

}
