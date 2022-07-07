package com.ioc.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

@Component("stu")
@Scope("singleton")         //singleton 单例模式(默认)   prototype 非单例模式
@Lazy(false)                //false 饿汉模式(默认)    true 懒汉模式
public class Student {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date enterenceTime;
    //@Autowired(required = false)          //true 自动装配必须(默认)  false()自动装配不必须   根据类型进行匹配(byType)
    @Resource
    private Clazz clazz;

    @PostConstruct
    public void init(){
        System.out.println("------init------");
    }

    @PreDestroy
    public void destory(){
        System.out.println("------destory------");
    }

    public Student() {
        System.out.println("-------创建-------");
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", enterenceTime=" + enterenceTime +
                ", clazz=" + clazz +
                '}';
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public void setEnterenceTime(Date enterenceTime) {
        this.enterenceTime = enterenceTime;
    }

    @Autowired
    public void setClazz(@Qualifier("clazz") Clazz clazz) {
        this.clazz = clazz;
    }
}
