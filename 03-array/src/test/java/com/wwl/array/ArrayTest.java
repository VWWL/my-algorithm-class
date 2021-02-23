package com.wwl.array;

import com.wwl.linear.search.pojo.Student;
import org.junit.Test;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/23 3:10 下午
 */
public class ArrayTest {

    @Test
    public void myArrayTest() {
        Array<Integer> array = new Array();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(1, 100);
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);
        System.out.println(array.contains(99));
        System.out.println(array.find(99));
        System.out.println(array.find(100));
        System.out.println(array.findAny(99));
        System.out.println(array.findAny(100));
        System.out.println(array.remove(9));
        System.out.println(array);
        array.addLast(2);
        System.out.println(array);
        array.removeElement(2);
        System.out.println(array);
    }

    @Test
    public void myArrayTest2() {
        Array<Student> array = new Array<>();
        array.addLast(new Student(2, "Alice"));
        array.addLast(new Student(1, "Bob"));
        array.addLast(new Student(3, "Charlie"));
        System.out.println(array);
    }
}