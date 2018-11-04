package learn.springboot.service;

import learn.springboot.entity.Person;
import learn.springboot.proxy.Ashe;
import learn.springboot.proxy.AsheFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

@Service
public class UserService
{
    public boolean addPerson(Person person)
    {
        return true;
    }

    public Person getPerson(Long id)
    {
        /*
        查询玩家信息
        TODO 可以从数据库查出来
         */
        Person person = new Person();
        person.setName("张三");
        person.setAge(22);
        person.setNickname("行者");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.roll(Calendar.YEAR,-22);
        person.setBirthdy(calendar.getTime());
        person.setLol(Collections.emptyList());
        return person;
    }

    public Person palyLol(Long id)
    {
        /*
        初始化一个玩家
        TODO 可以从数据库查出来
         */
        Person person = new Person();
        person.setName("张三");
        person.setAge(22);
        person.setNickname("行者");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.roll(Calendar.YEAR,-22);
        person.setBirthdy(calendar.getTime());
        person.setLol(new ArrayList<>());

        /*
        开始玩LOL游戏
         */
        Ashe ashe = AsheFactory.getInstance();
        ashe.hawkshot(person);
        ashe.enchantedCrystalArrow(person);
        return person;
    }
}
