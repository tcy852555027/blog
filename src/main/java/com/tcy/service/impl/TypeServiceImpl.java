package com.tcy.service.impl;

import com.tcy.dao.TypeDao;
import com.tcy.exception.NotFoundException;
import com.tcy.pojo.Type;
import com.tcy.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者:Tcy
 * @date:2020/5/26
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeDao typeDao;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeDao.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.findById(id).get();
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeDao.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {

        return typeDao.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeDao.findAll();
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t= typeDao.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);  //保护一份  spring中的方法
        return typeDao.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {

        typeDao.deleteById(id);

    }
}
