package com.tcy.service.impl;

import com.tcy.dao.TagDao;
import com.tcy.exception.NotFoundException;
import com.tcy.pojo.Tag;
import com.tcy.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者:Tcy
 * @date:2020/5/27
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagDao tagDao;


    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagDao.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagDao.findById(id).get();
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagDao.findAll(pageable);
    }


    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagDao.findById(id).get();
        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag, t);
        return tagDao.save(t);
    }


    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagDao.deleteById(id);
    }


    @Override
    public List<Tag> listTag(String ids) { //1,2,3
        return tagDao.findAll(convertToList(ids));
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    public List<Tag> listTag() {
        return tagDao.findAll();
    }
}
