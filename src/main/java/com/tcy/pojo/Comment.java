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
@Table(name = "t_comment")
//评论类
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname; //昵称
    private String email;  //邮箱
    private String content; // 评论内容
    private String avatar; //头像
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; //创建时间


    @ManyToOne
    private Blog blog;

    //评论自关联
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;

}
