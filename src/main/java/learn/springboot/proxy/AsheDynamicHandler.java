package learn.springboot.proxy;

import learn.springboot.entity.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 动态代理类
 */
public class AsheDynamicHandler implements InvocationHandler {
    private Object obj;

    public AsheDynamicHandler(Object obj)
    {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if(args != null && args[0] instanceof Person)
        {
            String name = ((Person)args[0]).getName();
            System.out.println(name + "在玩游戏");
        }
        System.out.println("游戏开始，请不要沉迷游戏！");
        Object result = method.invoke(obj,args);
        System.out.println("游戏结束，请多出去走走！");
        return result;
    }
}
