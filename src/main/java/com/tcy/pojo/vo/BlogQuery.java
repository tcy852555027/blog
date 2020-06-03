package com.tcy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者:Tcy
 * @date:2020/5/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogQuery  {

    private String title;
    private Long typeId;
    private boolean recommend;

}
