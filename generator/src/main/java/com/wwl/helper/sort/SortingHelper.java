package com.wwl.helper.sort;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/8 7:57 下午
 */
public class SortingHelper {

    private SortingHelper() {
    }

    public static <T, R extends Comparable<R>> void isSorted(T[] arr, Predicate<R> predicate, Function<T, R> function) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            if (!predicate.test(function.apply(arr[i]), function.apply(arr[i - 1]))) {
                throw new IllegalArgumentException("Sort not true!!! your wrong sort is " + Arrays.toString(arr));
            }
        }
    }

}
