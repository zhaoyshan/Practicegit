package com.zys.collect.releftion;

/**
 * @author zhaoyshan
 * @date 2021/7/24 22:19
 */
public class Person {
    String userName;
    Integer age;
    public Person(String userName ,Integer age){
        this.userName = userName;
        this.age = age;
    }
    public Person(){
        super();
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
