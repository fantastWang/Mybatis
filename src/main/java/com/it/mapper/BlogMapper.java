package com.it.mapper;


import com.it.domain.Blog;

/***
 * @Author wangchaojie
 * @Description
 * @Date 2020/8/28 22:34
 **/
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    Blog selectBlogById(Integer bid);
}
