package test;


import java.util.Arrays;

/**
 * 研究HashMap源码
 *
 * @author chenjianglin
 * @date 2021/2/21
 * @since 1.0.0
 **/
public class HashMapTest {
    public static void main(String[] args) {
        String spilt = "xxxx xxx xxx xx  -Dspring.profiles.active=dev xxxx";
        String string = spilt.replaceFirst("-Dspring.profiles.active=test", "String");
        System.out.println(string);
    }

}