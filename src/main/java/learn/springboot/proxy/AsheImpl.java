package learn.springboot.proxy;

import learn.springboot.entity.Person;
import learn.springboot.proxy.Ashe;

import java.util.List;

/*
 寒冰实现类
 */
public class AsheImpl implements Ashe
{

    @Override
    public void hawkshot(Person person)
    {
        List<String> lol = person.getLol();
        lol.add("hawkshot");
        person.setLol(lol);
    }

    @Override
    public void enchantedCrystalArrow(Person person)
    {
        List<String> lol = person.getLol();
        lol.add("enchanted crystal arrow");
        person.setLol(lol);
    }
}
