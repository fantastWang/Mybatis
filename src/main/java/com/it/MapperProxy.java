package com.it;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/***
 * @Author wangchaojie
 * @Description 具体代理类的实现
 * @Date 2020/8/30 22:26
 **/
public class MapperProxy implements InvocationHandler {

    private WCJSqlSession sqlSession;

    public MapperProxy(WCJSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    //通过statmentId拿到sql语句，使用executor执行sql语句
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //接口名+方法名
        String statementId = method.getDeclaringClass().getName() + "." + method.getName();
        return sqlSession.selectOne(statementId, args[0]);
    }
}
