package com.it;

import com.it.domain.Blog;
import com.it.mapper.BlogMapper;

public class MyBatisTest {

    public static void main(String[] args) {
        WCJSqlSession sqlSession = new WCJSqlSession(new WCJConfIguartion(), new WCJExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectBlogById(1);
        System.out.println(blog.toString());
    }
}
