package com.dao;

import com.pojo.Detail;
import com.pojo.User;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDAOTest {

    @Test
    public void testInsertUser() {

        User user = new User(0, "wangwu", "123123", "王五", "01.jpg", null);
        Detail detail = new Detail(0, "湖南衡阳", "13031313311", "没个性不签名", 0);

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try {
            UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
            int i = userDAO.insertUser(user);
            System.out.println(i);

            detail.setUserId(user.getUserId());

            DetailDAO detailDAO = MyBatisUtil.getMapper(DetailDAO.class);
            int j = detailDAO.insertDetail(detail);
            System.out.println(j);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }

    }

    @Test
    public void testQueryUser() {
        UserDAO userDAO = MyBatisUtil.getMapper(UserDAO.class);
        User user = userDAO.queryUser("lisi");
        System.out.println(user);
    }
}