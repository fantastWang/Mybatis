package com.it;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

/***
 * @Author wangchaojie
 * @Description 创建代理类
 * @Date 2020/8/30 22:27
 **/
public class WCJConfIguartion {
    //因为没有spring框架，使用ResourceBundle解析properties文件
    public static final ResourceBundle sql = ResourceBundle.getBundle("sql");

    //类加载器 代理的接口 实现InvocationHandler接口的对象
    public <T> T getMapper(Class clazz, WCJSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                new Class[]{clazz},
                new MapperProxy(sqlSession));
    }
}
