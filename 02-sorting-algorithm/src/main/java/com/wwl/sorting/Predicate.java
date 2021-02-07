package com.wwl.sorting;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 7:29 下午
 */
@FunctionalInterface
public interface Predicate<T extends Comparable<T>> {

    /**
     * 比较器
     *
     * @param t1 参数1
     * @param t2 参数2
     * @return 升降判断
     */
    boolean test(T t1, T t2);

}