package com.wwl.array;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/23 2:42 下午
 */
@Slf4j
@EqualsAndHashCode
@SuppressWarnings("all")
public class Array<T> {

    private T[] v;

    /**
     * 数组中的元素个数
     */
    private int size;

    /**
     * 构造函数，创建Array
     *
     * @param capacity 容量大小
     */
    public Array(int capacity) {
        v = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(12);
    }

    /**
     * 获取数组的容量
     *
     * @return 数组容量
     */
    public int getCapacity() {
        return v.length;
    }

    /**
     * 获取数组的已使用长度
     *
     * @return 数组已使用长度
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向指定位置新增元素
     *
     * @param t     需要新增的元素
     * @param index 索引
     */
    public void add(int index, T t) {
        parseIllegalByEdit(index);
        System.arraycopy(v, index, v, index + 1, size - index);
        v[index] = t;
        size++;
    }

    /**
     * 向数组末尾新增元素
     *
     * @param t 需要新增的元素
     */
    public void addLast(T t) {
        add(size, t);
    }

    /**
     * 向数组头部新增元素
     *
     * @param t 需要新增的元素
     */
    public void addFirst(T t) {
        add(0, t);
    }

    /**
     * 获取指定索引的元素
     *
     * @param index 索引
     * @return 指定索引的元素
     */
    public T get(int index) {
        parseIllegalByQuery(index);
        return v[index];
    }

    /**
     * 设置指定索引的值
     *
     * @param index 索引
     * @param t     指定值
     */
    public void set(int index, T t) {
        parseIllegalByQuery(index);
        v[index] = t;
    }

    /**
     * 查找数组中是否有元素t
     *
     * @param t 元素t
     * @return 是否存在
     */
    public boolean contains(T t) {
        return Arrays.stream(v).anyMatch(o -> t.equals(o));
    }

    /**
     * 查询数组中元素t的索引
     *
     * @param t 元素t
     * @return 索引
     */
    public int find(T t) {
        for (int i = 0; i < size; i++) {
            if (t.equals(v[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中是否有元素t，无则返回null
     *
     * @param t 元素t
     * @return 返回值
     */
    public T findAny(T t) {
        return Arrays.stream(v).filter(o -> t.equals(o)).findAny().orElse(null);
    }

    /**
     * 删除数组中索引位置的值，返回值
     *
     * @param index 索引
     * @return 返回值
     */
    public T remove(int index) {
        parseIllegalByEdit(index);
        if (size == 0) {
            throw new IllegalArgumentException("Remove failed. No data!");
        }
        T ret = v[index];
        for (int i = index + 1; i < size; i++) {
            v[i - 1] = v[i];
        }
        v[size] = null;
        size--;
        return ret;
    }

    /**
     * 删除第一个元素，返回删除的元素
     *
     * @return 第一个元素
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素，返回删除的元素
     *
     * @return 最后一个元素
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中指定的元素
     *
     * @param t 指定的元素
     */
    public void removeElement(T t) {
        int index = find(t);
        if (index == -1) {
            return;
        }
        remove(index);
    }

    /**
     * 删除数组中所有指定的元素
     *
     * @param t 指定的元素
     */
    public void removeAllElement(T t) {
        int index = find(t);
        if (index == -1) {
            return;
        }
        remove(index);
        removeAllElement(t);
    }

    /**
     * 解析是否合法
     *
     * @param index 索引
     * @param msg   错误提示
     */
    private void parseIllegalByQuery(int index, String msg) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * 解析是否合法
     *
     * @param index 索引
     */
    private void parseIllegalByQuery(int index) {
        this.parseIllegalByQuery(index, "Method run failed. Index is illegal.");
    }

    private void parseIllegalByEdit(int index, String msg) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(msg);
        }
//        if (size < v.length / 2) {
//            resize((int) (v.length / 2));
//        }
        if (size == v.length) {
            resize((int) (2 * v.length));
        }
    }

    private void parseIllegalByEdit(int index) {
        this.parseIllegalByEdit(index, "Method run failed. Index is illegal.");
    }

    /**
     * 数组动态扩容
     */
    private void resize(int newCapacity) {
        T[] newV = (T[]) new Object[newCapacity];
        System.arraycopy(v, 0, newV, 0, v.length);
        v = newV;
    }

    private void desize() {

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ,capacity = %d, array = [", size, v.length));
        for (int i = 0; i < size; i++) {
            res.append(v[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

}
