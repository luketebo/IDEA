package com.luketebo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class MyAsyncService {

    @Async
    public void sendSMS() throws InterruptedException {
        System.out.println("beginning to send message ....");
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("end of sending message!");
        System.out.printf(String.valueOf(end - start));
    }
    @Async
    public Future<Integer> processA() throws InterruptedException {
        System.out.println("开始业务A");
        long start = System.currentTimeMillis();
        Thread.sleep(4000);
        int count = 12356;
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return new AsyncResult<>(count);
    }
    @Async
    public Future<Integer> processB() throws InterruptedException {
        System.out.println("开始业务b");
        long start = System.currentTimeMillis();
        Thread.sleep(4000);
        int count = 12346;
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return new AsyncResult<>(count);
    }
}
