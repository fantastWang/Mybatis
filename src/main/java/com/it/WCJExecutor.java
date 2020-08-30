package com.it;

import com.it.domain.Blog;

import java.sql.*;

public class WCJExecutor {

    public <T> T query(String sql, Object params) {
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123456");
            stmt = conn.createStatement();
            //将%d替换成实际的参数
            ResultSet rs = stmt.executeQuery(String.format(sql, params));
            while (rs.next()) {
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return (T) blog;
    }

}
