package com.wwl.sorting.select;

import com.wwl.linear.search.pojo.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 11:18 下午
 */
public class SelectionSortTest {

    private static final Integer[] DATA1 = {1, 4, 2, 3, 6, 5};

    private static final Student[] DATA2 = new Student[]{
            new Student(2, "老王"),
            new Student(4, "老刘"),
            new Student(1, "张三")
    };

    @Before
    public void setUp() {
    }

    @Test
    public void selectionSortTest() {
        Integer[] res1 = SelectionSort.sort(DATA1);
        Integer[] res2 = SelectionSort.sort(DATA1, "desc");
        Student[] res3 = SelectionSort.sort(DATA2, Student::getId);
        Student[] res4 = SelectionSort.sort(DATA2, "desc", Student::getId);
        Student[] res5 = SelectionSort.sort(DATA2, Student::getName);
    }

}