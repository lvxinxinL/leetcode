package juc.saleticket.thread;

/**
 * 多线程编程步骤：使用 synchronized 关键字
 *
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-03-26-15:10
 */
// 1. 创建资源类，包括属性和方法
class Resource {
    private int number = 0;

    // 2. 在资源类里操作方法
    public synchronized void incr() throws InterruptedException {
        // 2.1 判断
        while (number != 0) {// 4. 防止虚假唤醒
            this.wait();
        }
        // 2.2 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "  number: " + number);
        // 2.3 通知
        this.notifyAll();
    }
    public synchronized void decr() throws InterruptedException {
        // 2.1 判断
        while (number != 1) {// 4. 防止虚假唤醒
            this.wait();
        }
        // 2.2 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "  number: " + number);
        // 2.3 通知
        this.notifyAll();
    }

}

public class ThreadDemo1 {
    // 3. 创建线程，调用资源类中的操作
    public static void main(String[] args) {
        Resource resource = new Resource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.incr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.decr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.incr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    resource.decr();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "DD").start();
    }
}
