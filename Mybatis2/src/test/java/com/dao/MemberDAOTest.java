package com.dao;

import com.pojo.Member;
import com.pojo.MemberSearchCondition;
import com.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberDAOTest {

    @Test
    public void testsearchMember() {

        HashMap<String, Object> params1 = new HashMap<>();
        params1.put("gender", "女");
        params1.put("minAge", 18);
        params1.put("maxAge", 23);
        params1.put("city", "衡阳");

        //------------------------------------------------------------
        MemberSearchCondition params2 = new MemberSearchCondition();
        params2.setGender("女");
        // params2.setMinAge(18);
        // params2.setMaxAge(23);
        // params2.setCity("衡阳");

        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMember(params2);

        for (Member m : members) {
            System.out.println(m);
        }
    }

    @Test
    public void testSearchMemberByCity() {
        List<String> cities = new ArrayList<>();
        cities.add("衡阳");
        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMemberByCity(cities);
        for (Member m : members) {
            System.out.println(m);
        }
    }

    @Test
    public void testSearchMemberByNick() {
        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMemberByNick("花");
        for (Member m : members) {
            System.out.println(m);
        }
    }

    @Test
    public void testQueryMemberById() {
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();

        SqlSession sqlSession1 = factory.openSession(true);
        SqlSession sqlSession2 = factory.openSession(true);
        System.out.println(sqlSession1 == sqlSession2);

        MemberDAO memberDAO1 = sqlSession1.getMapper(MemberDAO.class);
        Member member1 = memberDAO1.queryMemberById(1);
        System.out.println(member1);
        sqlSession1.commit();

        System.out.println("------------------------------------------------------------");

        MemberDAO memberDAO2 = sqlSession2.getMapper(MemberDAO.class);
        Member member2 = memberDAO2.queryMemberById(1);
        System.out.println(member2);
    }

    @Test
    public void updateMember() {
        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        memberDAO.updateMember(1, 19);
    }

}