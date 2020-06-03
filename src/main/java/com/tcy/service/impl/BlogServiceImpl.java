package com.tcy.service.impl;

import com.tcy.dao.BlogDao;
import com.tcy.exception.NotFoundException;
import com.tcy.pojo.Blog;
import com.tcy.pojo.Type;
import com.tcy.pojo.vo.BlogQuery;
import com.tcy.service.BlogService;
import com.tcy.util.MyBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @作者:Tcy
 * @date:2020/5/27
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
  private BlogDao blogDao;

    @Override
    public Blog getBlog(Long id) {
        return blogDao.findById(id).get();
    }


    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogDao.findAll((Specification<Blog>) (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                predicates.add(cb.like(root.<String>get("title"), "%"+blog.getTitle()+"%"));
            }
            if (blog.getTypeId() != null) {
                predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
            }
            if (blog.isRecommend()) {
                predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
            }
            cq.where(predicates.toArray(new Predicate[predicates.size()]));
            return null;
        },pageable);
    }

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if (blog.getId() == null) {
            blog.setCreateTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        } else {
            blog.setUpdateTime(new Date());
        }
        return blogDao.save(blog);
    }

    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b = blogDao.findById(id).get();
        if (b == null) {
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog,b, MyBeanUtils.getNullPropertyNames(blog));
        b.setUpdateTime(new Date());
        return blogDao.save(b);
    }

    @Transactional
    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteById(id);
    }
}
