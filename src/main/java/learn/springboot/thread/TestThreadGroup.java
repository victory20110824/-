package learn.springboot.thread;

/*
 run()方法定义在Runnable接口中，start()方法则定义在Thread类中。
 用实现Runnable接口或继承Thread类实现线程，都需要实现run()方法，是多线程真正运行的主方法。
 Thread的start()方法，用来异步启动一个线程，然后主线程立刻返回，该方法启动的线程不会马上执行，
 而是进行就绪状态，在等待队列中等待CPU调度。当线程被CPU调度时，才执行run()方法。
 */
public class TestThreadGroup
{
    public static void main(String[] args)
    {
        Runnable runnable = () -> {
            System.out.println("线程组名称:" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("线程名称:" + Thread.currentThread().getName());

            try
            {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        /*
         创建线程组
         */
        ThreadGroup threadGroup = new ThreadGroup("中国人");
        threadGroup.setMaxPriority(Thread.MAX_PRIORITY);

        /*
         创建线程
         */
        Thread thread1 = new Thread(threadGroup, runnable, "thread-person-1");
        Thread thread2 = new Thread(threadGroup, runnable, "thread-person-2");

        /*
         启动线程
         */
        thread1.start();
        thread2.start();

        /*
         统计
         */
        System.out.println("线程组活跃线程数：" + threadGroup.activeCount());
        threadGroup.list();

//        /*
//         中断线程
//         */
//        threadGroup.interrupt();
    }
}
