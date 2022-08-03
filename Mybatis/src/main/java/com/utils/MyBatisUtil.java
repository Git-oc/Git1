package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory;
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(boolean isAutoCommit) {
        SqlSession sqlsession = local.get();
        if (sqlsession == null) {
            sqlsession = factory.openSession(isAutoCommit);
            local.set(sqlsession);
        }
        return sqlsession;
    }

    public static <T extends Object> T getMapper(Class<T> c) {
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }
}
