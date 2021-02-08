package com.wwl.generator;

import java.util.Random;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/8 12:04 上午
 */
public class RandomArrayGenerator {

    private RandomArrayGenerator() {
    }

    public static Integer[] generateRandomArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Random().nextInt(size);
        }
        return arr;
    }

}
