package com.tcy.service;

import com.tcy.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @作者:Tcy
 * @date:2020/5/27
 */
public interface TagService {


    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag type);

    void deleteTag(Long id);

    List<Tag> listTag(String ids);

    List<Tag> listTag();





}
