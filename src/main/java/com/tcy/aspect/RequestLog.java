package com.tcy.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @作者:Tcy
 * @date:2020/5/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestLog {
    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;
}
