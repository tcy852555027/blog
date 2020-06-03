package com.tcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @作者:Tcy
 * @date:2020/5/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;  // 昵称
    private String username; // 用户名
    private String password; //用户密码
    private String email; //邮箱
    private String avatar; //头像
    private Integer type;//用户类型
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime; //更新时间

    @OneToMany(mappedBy = "user") //被维护  也就是维护表可以控制被维护的表
    private List<Blog> blogs = new ArrayList<>();
}
