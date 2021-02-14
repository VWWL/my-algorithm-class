package com.wwl.sorting.insert;

import com.wwl.generator.RandomArrayGenerator;
import com.wwl.linear.search.pojo.Student;
import com.wwl.sorting.select.SelectionSort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/14 6:07 下午
 */
public class InsertionSortTest {

    private static final Integer[] DATA1 = {1, 4, 2, 3, 6, 5};

    private static final Student[] DATA2 = new Student[]{
            new Student(2, "老王"),
            new Student(4, "老刘"),
            new Student(1, "张三")
    };

    private static final Integer TEN_MILLION = 10_000;

    private static final Integer HUNDRED_MILLION = 100_000;

    private static final Integer THOUSAND_MILLION = 1_000_000;

    private static final Integer[] DATA3 = RandomArrayGenerator.generateRandomArray(HUNDRED_MILLION);

    private static final Integer[] DATA4 = RandomArrayGenerator.generateRandomArray(TEN_MILLION);


    @Before
    public void setUp() {
    }

    @Test
    public void insertionSortTest() {
        Integer[] res1 = InsertionSort.sort(DATA1);
        Integer[] res2 = InsertionSort.sort(DATA1, "desc");
        Student[] res3 = InsertionSort.sort(DATA2, Student::getId);
        Student[] res4 = InsertionSort.sort(DATA2, "desc", Student::getId);
        Student[] res5 = InsertionSort.sort(DATA2, Student::getName);
        Student[] res6 = InsertionSort.sort(DATA2);
        Integer[] res7 = InsertionSort.sort(DATA3);
        Integer[] res8 = InsertionSort.sort(DATA4);
    }

}