package com.luketebo.controller;

import com.luketebo.service.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class DemoController {
    @Autowired
    private MyAsyncService myAsyncService;
    @GetMapping("asyn")
    public String demo() throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("'before call asynservice");
        myAsyncService.sendSMS();
        System.out.println("after call asyncservice");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return "test over";
    }
    @GetMapping("total")
    public String total() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        System.out.println("before call asynservice");
        Future<Integer> fa = myAsyncService.processA();
        Future<Integer> fb = myAsyncService.processB();
        int total = fa.get() - fb.get();
        System.out.println("total: " + total);
        System.out.println("after call asynservice");
        return "success";
    }

}
