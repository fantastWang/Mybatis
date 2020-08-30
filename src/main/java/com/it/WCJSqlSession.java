package com.it;

/***
 * @Author wangchaojie
 * @Description
 * @Date 2020/8/28 22:36
 **/
public class WCJSqlSession {

    private WCJConfIguartion confIguartion;
    private WCJExecutor executor;

    public WCJSqlSession(WCJConfIguartion confIguartion,WCJExecutor executor){
        this.confIguartion = confIguartion;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId,Object params){
        String sql = WCJConfIguartion.sql.getString(statementId);
        return this.executor.query(sql,params);
    }

    //用于获取mapper接口的代理对象
    public <T> T getMapper(Class clazz){
       return this.confIguartion.getMapper(clazz,this);
    }
}
