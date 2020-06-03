package com.tcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者:Tcy
 * @date:2020/5/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_tag")
// 标签类
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}
