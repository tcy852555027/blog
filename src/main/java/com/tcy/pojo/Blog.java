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
//博客类
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog {
    //用户ID
    @Id
    @GeneratedValue
    private Long id;
    //博客标题
    private String title;
    //博客内容
    private String content;
    //博客首图
    private String firstPicture;
    //标记 转载原创
    private String flag;
    //浏览次数
    private Integer views;
    //赞赏开起
    private boolean appreciation;
    //转载声明是否开起
    private boolean shareStatement;
    //评论
    private boolean commentabled;
    //发布还是保存草稿
    private boolean published;
    //推荐
    private boolean recommend;
    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    //跟新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Transient
    private String tagIds;

    private String description;

    @ManyToOne //主动维护
    private Type type;  //多博客 博客对应1个类型

    @ManyToMany(cascade = {CascadeType.PERSIST})  //关联关系 级联新增
    private List<Tag> tags = new ArrayList<>();   //博客对多个标签


    @ManyToOne //关系维护方 主动维护
    private User user;  //博客是多的一端  多个博客对应一个user

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

}
