package learn.springboot.aop;

import learn.springboot.annotation.Limit;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/*
 描述：描述切面类
 */
@Component
@Aspect
public class LimiTime
{
    Logger logger = LoggerFactory.getLogger(LimiTime.class);

    /*
    定义一个切入点
     */
    @Pointcut("@annotation(learn.springboot.annotation.Limit)")
    public void limitAnnotation()
    {
    }

    @Before(value = "limitAnnotation()&&@annotation(limit)")
    public void limitPlayTime(Limit limit) throws Throwable
    {
        int value = limit.value();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        TimeZone timeZone = calendar.getTimeZone();
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        logger.info("当前时间：{}，时区：{}，今天是周几：{}",calendar.getTime(),timeZone,day);
        if(value == day)
        {
            System.out.println("星期五不能玩游戏");
        }
        else
        {
            System.out.println("可以玩游戏");
        }
    }
}
