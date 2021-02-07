package com.wwl.linear.search;

import lombok.extern.slf4j.Slf4j;

/**
 * 线性查找法
 *
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 2:57 下午
 */
@Slf4j
public class LinearSearch {

    /**
     * 输入一个数组及想搜索的目标，输出其所在的索引值，若不存在则为-1
     * target.equals(data[i])
     *
     * @param data      目标数组
     * @param target    匹配值
     * @param predicate 可以重写的比较器
     * @return 索引
     */
    public static <T> int search(T[] data, T target, Predicate<T> predicate) {
        for (int i = 0; i < data.length; i++) {
            if (predicate.test(target, data[i])) {
                log.info("---result is {}---", i);
                return i;
            }
        }
        log.warn("---result is not found.---");
        return -1;
    }

    public static <T> int search(T[] data, T target) {
        Predicate<T> predicate = Object::equals;
        return search(data, target, predicate);
    }

    private LinearSearch() {
    }

}