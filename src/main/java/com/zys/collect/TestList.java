package com.zys.collect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaoyshan
 * @date 2021/7/12 21:06
 */
public class TestList {
    public static void main(String[] args) {
        Integer[] myArray = {1,2,3,4};
        List<Integer> collect = Arrays.stream(myArray).collect(Collectors.toList()); // 这个方法无论是基本数据类型还是封装类都可以使用

        //注意：在aslist方法中 其实底层还是数组，它转换的list其实时它内部的一个内部类 ,集成了abstractList  以下方法都没有具体实现，都是抛出异常
        // 而且 转换成的list是不能使用add，remove，clear方法 。 其实底层看的时候发现其实每个方法都是直接抛出异常的
        System.out.println(Arrays.asList(myArray).getClass()); //class java.util.Arrays$ArrayList
        List<Integer> integers1 = Arrays.asList(myArray);
        boolean add = integers1.add(1);
        System.out.println(add);
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(myArray));
        System.out.println("helloworld");
        Test test = (Test)new handdler().setObject(new ttest1());
        test.run("zhaoyshan");
    }
}
class handdler implements InvocationHandler{

    private Object object;
    Object setObject(Object object){
        this.object = object;
        // 返回代理对象的时候的 需要代理工程，
        // 说白了 就是我们生成 代理的对象使用的Proxy这个类，然后需要一个invocationHandler 所以我们创建了这个 ，然后这个代理就会执行这个invoke方法
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this); //返回代理对象
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类在作怪");
        Object invoke = method.invoke(args);
        return null;
    }
}

interface Test{
    public void run(String name);
}
class ttest1 implements  Test {

    @Override
    public void run(String name) {
        System.out.println(name);
    }
}
