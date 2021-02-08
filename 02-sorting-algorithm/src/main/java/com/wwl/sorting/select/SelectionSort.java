package com.wwl.sorting.select;

import com.wwl.helper.sort.Predicate;
import com.wwl.helper.sort.SortingHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * 选择排序法
 *
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 10:22 下午
 */
@Slf4j
public class SelectionSort {

    private static final String ASC = "asc";

    private static final String DESC = "desc";

    private SelectionSort() {
    }

    /**
     * 选择排序，每次寻找剩下的元素中最小的元素并与游标位交换
     *
     * @param arr 初始数
     * @param <T> 数组中的元素类型
     * @param <R> 比较类型
     * @return 排序好的数组
     */
    public static <T, R extends Comparable<R>> T[] sort(T[] arr, String sortMode, Function<T, R> function) {
        if (!ASC.equals(sortMode) && !DESC.equals(sortMode)) {
            throw new IllegalArgumentException("Unexpected parameter.");
        }
        Predicate<R> predicate = analyze(sortMode);
        long start = System.nanoTime();
        log.info("---起始数据为 {}", (Object) arr);
        log.info("排序方式为 {} ---", sortMode);
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int preIndex = i;
            for (int j = i; j < length; j++) {
                if (predicate.test(function.apply(arr[preIndex]), function.apply(arr[j]))) {
                    preIndex = j;
                }
            }
            T t = arr[i];
            arr[i] = arr[preIndex];
            arr[preIndex] = t;
        }
        SortingHelper.isSorted(arr, predicate, function);
        log.info("---排序完成，结果为 {}", (Object) arr);
        log.info("总耗时 {} nano seconds---", System.nanoTime() - start);
        return arr;
    }

    public static <T, R extends Comparable<R>> T[] sort(T[] arr) {
        return sort(arr, ASC, o -> (R) o);
    }

    public static <T, R extends Comparable<R>> T[] sort(T[] arr, String sortMode) {
        return sort(arr, sortMode, o -> (R) o);
    }

    public static <T, R extends Comparable<R>> T[] sort(T[] arr, Function<T, R> function) {
        return sort(arr, ASC, function);
    }

    private static <R extends Comparable<R>> Predicate<R> analyze(String sortMode) {
        return "asc".equals(sortMode) ? (o1, o2) -> o1.compareTo(o2) >= 0 : (o1, o2) -> o1.compareTo(o2) <= 0;
    }
}