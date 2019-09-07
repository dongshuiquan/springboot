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

    @Test(expected = RuntimeException.class)
    public void transaction_exception_required_required() throws Exception {
        invokeService.transaction_exception_required_required();
    }

    @Test(expected = RuntimeException.class)
    public void transaction_required_required_exception() throws Exception {
        invokeService.transaction_required_required_exception();
    }

    @Test(expected = RuntimeException.class)
    public void transaction_required_required_exception_try() throws Exception {
        invokeService.transaction_required_required_exception_try();
    }

    @Test(expected = RuntimeException.class)
    public void notransaction_exception_requiresNew_requiresNew() throws Exception {
        invokeService.notransaction_exception_requiresNew_requiresNew();
    }

    @Test(expected = RuntimeException.class)
    public void notransaction_requiresNew_requiresNew_exception() throws Exception {
        invokeService.notransaction_requiresNew_requiresNew_exception();
    }

    @Test(expected = RuntimeException.class)
    public void transaction_exception_required_requiresNew_requiresNew() throws Exception {
        invokeService.transaction_exception_required_requiresNew_requiresNew();
    }

    @Test(expected = RuntimeException.class)
    public void transaction_required_requiresNew_requiresNew_exception() throws Exception {
        invokeService.transaction_required_requiresNew_requiresNew_exception();
    }

    @Test
    public void transaction_required_requiresNew_requiresNew_exception_try() throws Exception {
        invokeService.transaction_required_requiresNew_requiresNew_exception_try();
    }

    @Test(expected = RuntimeException.class)
    public void notransaction_exception_nested_nested() throws Exception {
        invokeService.notransaction_exception_nested_nested();
    }

    @Test(expected = RuntimeException.class)
    public void notransaction_nested_nested_exception() throws Exception {
        invokeService.notransaction_nested_nested_exception();
    }

    @Test(expected = RuntimeException.class)
    public void transaction_exception_nested_nested() throws Exception {
        invokeService.transaction_exception_nested_nested();
    }

    @Test(expected = RuntimeException.class)
    public void transaction_nested_nested_exception() throws Exception {
        invokeService.transaction_nested_nested_exception();
    }

    @Test
    public void transaction_nested_nested_exception_try() throws Exception {
        invokeService.transaction_nested_nested_exception_try();
    }

}
