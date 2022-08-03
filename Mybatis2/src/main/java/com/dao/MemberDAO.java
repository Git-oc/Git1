package com.dao;

import com.pojo.Member;
import com.pojo.MemberSearchCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberDAO {
    //再多条件查询中，若查询条件不确定？

    // 1，可直接使用HashMap作为参数
    //优点：无需单独定义传递查询条件的类
    //缺点：当向Map中存放参数时key必须与动态sql保持一致
//    public List<Member> searchMember(HashMap<String,Object> params);

    //2，定义专门用于存放查询条件的实体类存放参数
    //优点：设置参数时无需关注属性名
    //缺点：需要单独定义传递查询条件的类 来封装参数
    public List<Member> searchMember(MemberSearchCondition params);

    //根据城市查询用户信息
    public List<Member> searchMemberByCity(List<String> cities);

    //根据昵称查询用户信息——模糊查询
    public List<Member> searchMemberByNick(String keyWorld);

    public Member queryMemberById(int mid);

    public void updateMember(@Param("mid") int mid, @Param("age") int age);
}
