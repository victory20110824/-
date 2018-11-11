package learn.springboot.thread;

/*
 run()方法定义在Runnable接口中，start()方法则定义在Thread类中。
 用实现Runnable接口或继承Thread类实现线程，都需要实现run()方法，是多线程真正运行的主方法。
 Thread的start()方法，用来异步启动一个线程，然后主线程立刻返回，该方法启动的线程不会马上执行，
 而是进行就绪状态，在等待队列中等待CPU调度。当线程被CPU调度时，才执行run()方法。
 直接调用 run() 方法，那就等于调用了一个普通的同步方法，达不到多线程运行的异步执行
 */
public class DifferenceBetweenStartAndRun
{
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("java 线程学习");
        });

        /*
         start方法执行时间
         */
        long start = System.currentTimeMillis();
        thread.start();
        System.out.println(System.currentTimeMillis() - start);

        /*
         run方法执行时间
         */
        start = System.currentTimeMillis();
        thread.run();
        System.out.println(System.currentTimeMillis() - start);
    }
}
