package com.wwl.linear.search;

import com.wwl.generator.ArrayGenerator;
import com.wwl.linear.search.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 3:03 下午
 */
@Slf4j
public class LinearSearchTest {

    private static Integer[] data;

    private static final Integer TARGET = 16;

    private static Student[] students;

    private static final Student STUDENT = new Student(1, "张三");

    private static Integer[] arrFromGenerator;

    private static final Integer HUNDRED_MILLION = 100_000;

    private static final Integer THOUSAND_MILLION = 1_000_000;

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
        arrFromGenerator = ArrayGenerator.generateOrderedArray(HUNDRED_MILLION);
        int i6 = LinearSearch.search(arrFromGenerator, -1);
        assertEquals(-1, i6);
        arrFromGenerator = ArrayGenerator.generateOrderedArray(THOUSAND_MILLION);
        int i7 = LinearSearch.search(arrFromGenerator, -1);
        assertEquals(-1, i7);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            arrFromGenerator = ArrayGenerator.generateOrderedArray(THOUSAND_MILLION);
            int i8 = LinearSearch.search(arrFromGenerator, -1);
            assertEquals(-1, i8);
        }
        log.info("---100万个数据运行100轮总时长为 {} ms---", System.currentTimeMillis() - start);
    }

}