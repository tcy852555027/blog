package com.tcy.service;

import com.tcy.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @作者:Tcy
 * @date:2020/5/26
 */
public interface TypeService {
    Type saveType(Type type);  //保存

    Type getType(Long id);  //获得一个

    Type getTypeByName(String name); //根据名字

    Page<Type> listType(Pageable pageable);  //分页

    List<Type> listType();

    Type updateType(Long id, Type type); //更新

    void deleteType(Long id); //删除
}
