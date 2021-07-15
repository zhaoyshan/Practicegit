package com.zys.collect;

/**
 * @author zhaoyshan
 * @date 2021/7/22 10:34
 */
public class Inc {
    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 1444;
        i= ++i;


        int temp = 1000;
        temp = temp ++;
        System.out.println(temp);

        System.out.println(i);




        int temmp1 = 10;
        int temp2 = temmp1++;
        System.out.println(temmp1);
        System.out.println(temp2);
    }

}
