package jdk8;

import java.util.function.*;

/**
 * @author zhaoyshan
 * @date 2021/7/26 22:46
 */
public class LambdaBasic {
    private static Function<Integer,String>  int2String = (Integer i) ->{ return String.valueOf(i);}; //最简单的一个函数接收
    private static Function<Integer,String> Int2String_1 = (Integer i) -> String.valueOf(i); // 只有一个表达式，可以胜利略中括号
    private static Function<Integer,String> int2String_2 = (i) -> String.valueOf(i); // 参数可以自动推导
    private static Function<Integer,String> int2String_3 = i -> String.valueOf(i); //类型推导且只有一个参数的时候，可以省略括号
    //think it ?其实就是返回值 是一个函数的情况
    private static Function<Integer,Function<Integer,String>> twoString =  x -> y -> x+""+y;

    //Function  Interface
    private static Runnable run = ()->{ System.out.println("hello");}; //这其实就是一个Runnable接口实现的run方法
    private static Supplier<Integer> supplier = ()->1;
    private static Consumer<?> consumer = a ->{
        System.out.println(a);
    } ;//消费者就是 只有参数没有返回值  他们现在其实就是一个变量 ，所以无法直接使用，但是可以当作一个参数进行运算、使用的
    private static Predicate<?> predicate = a -> true; //返回值是一个bool 类型的
    private static Function<?,Boolean> fn  = a -> true;

     void test (){
        BiFunction<Integer,Integer,Integer> temp = LambdaBasic::testFunction;
        temp.apply(1,2);
        String apply = int2String.apply(1);
        Consumer<LambdaBasic> testcon = LambdaBasic::test2;

    }
   void test2(){
        System.out.println();
    }
    static void test1(Consumer consumer){
        consumer.accept("zhaoyshan");
    }
 
    public static void main(String[] args) {
        test1(consumer);
    }
   static Integer testFunction(int n, int m){
        return n + m;
    }
}
