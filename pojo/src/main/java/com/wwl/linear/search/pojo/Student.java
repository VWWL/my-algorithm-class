package com.wwl.linear.search.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangweili
 * @version 1.0
 * @date 2021/2/7 7:23 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private Integer id;

    private String name;

    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}