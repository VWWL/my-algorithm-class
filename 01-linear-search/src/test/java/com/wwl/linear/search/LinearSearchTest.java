package com.wwl.linear.search;

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

    private static int[] data;

    private static final int TARGET = 16;

    @Before
    public void setUp() {
        data = new int[]{24, 18, 12, 9, 16, 66, 32, 4};
    }

    @Test
    public void linearSearchTest() {
        int i1 = LinearSearch.search(data, TARGET);
        assertEquals(4, i1);
        int i2 = LinearSearch.search(data, TARGET + 1);
        assertEquals(-1, i2);
    }

}