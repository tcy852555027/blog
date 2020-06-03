package com.tcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
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
@Table(name = "t_type")
//博客类型
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "分类名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")  //被维护
    private List<Blog> blogs = new ArrayList<>(); //博客是多的一端 一个博客对应多个类型  需要关系维护


}
