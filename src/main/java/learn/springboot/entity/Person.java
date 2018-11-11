package learn.springboot.entity;

import java.util.Date;
import java.util.List;

public class Person
{
    private String name;
    private Integer age;
    private String nickname;
    private Date birthdy;
    private List<String> lol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirthdy() {
        return birthdy;
    }

    public void setBirthdy(Date birthdy) {
        this.birthdy = birthdy;
    }

    public List<String> getLol() {
        return lol;
    }

    public void setLol(List<String> lol) {
        this.lol = lol;
    }

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                ", birthdy=" + birthdy +
                '}';
    }
}
