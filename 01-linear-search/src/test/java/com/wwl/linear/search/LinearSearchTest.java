package com.wwl.linear.search;

import com.wwl.linear.search.pojo.Student;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 3:03 下午
 */
public class LinearSearchTest {

    private static Integer[] data;

    private static final Integer TARGET = 16;

    private static Student[] students;

    private static final Student STUDENT = new Student(1, "张三");

    @Before
    public void setUp() {
        data = new Integer[]{24, 18, 12, 9, 16, 66, 32, 4};
        students = new Student[]{
                new Student(2, "王武"),
                new Student(4, "张三"),
                new Student(1, "刘六"),
                new Student(1, "张三")
        };
    }

    @Test
    public void linearSearchTest() {
        int i1 = LinearSearch.search(data, TARGET);
        assertEquals(4, i1);
        int i2 = LinearSearch.search(data, TARGET + 1);
        assertEquals(-1, i2);
        int i3 = LinearSearch.search(students, STUDENT);
        assertEquals(3, i3);
        int i4 = LinearSearch.search(students, STUDENT, (o1, o2) -> o1.getId().equals(o2.getId()));
        assertEquals(2, i4);
        int i5 = LinearSearch.search(students, STUDENT, (o1, o2) -> o1.getName().equals(o2.getName()));
        assertEquals(1, i5);
    }

}