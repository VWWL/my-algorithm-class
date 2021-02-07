package com.wwl.generator;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 9:47 下午
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

}