package juc.saleticket.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程编程步骤：使用 Lock 接口
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-03-26-15:23
 */

class LockTicket {
    private int number = 0;
    // 创建 lock
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incr() throws InterruptedException {
        // 手动上锁
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "  number: " + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decr() throws InterruptedException {
        // 手动上锁
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "  number: " + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

public class LockDemo1 {
    public static void main(String[] args) {
        LockTicket lockTicket = new LockTicket();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockTicket.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockTicket.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockTicket.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockTicket.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
