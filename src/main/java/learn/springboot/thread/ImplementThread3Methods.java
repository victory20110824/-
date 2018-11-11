package learn.springboot.thread;

import learn.springboot.entity.Person;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ImplementThread3Methods
{
    /*
     1 继承Thread Thread实现了Runnable接口
     */
    static class Thread1 extends Thread
    {
        @Override
        public void run()
        {
            System.out.println("Thread1 running, which extends Thread class.");
        }
    }

    /*
     2 实现Runnable接口
     */
    static class Thread2 implements Runnable
    {

        @Override
        public void run() {
            System.out.println("Thread2 running, which implements Runnable interface.");
        }
    }

    /*
     3 实现Callable接口
     */
    static class Thread3<T> implements Callable<T>
    {

        @SuppressWarnings("unchecked")
        @Override
        public T call() throws Exception {
            System.out.println("Thread3 running, which implements Callable interface.");
            return (T)new Person("hard work",23);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
         创建线程
         */
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread(new Thread2());
        FutureTask<Person> ft = new FutureTask<>(new Thread3<>());
        Thread thread3 = new Thread(ft);

        /*
         启动线程
         */
        thread1.start();
        thread2.start();
        thread3.start();

        /*
         Callable能返回一个异步处理的结果Future对象并能抛出异常。
         */
        System.out.println(ft.get().toString());
    }
}
