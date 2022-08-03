package com.ioc.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
    private Date enterenceTime;

    private Clazz clazz;

    private List<String> hobbies;
    private Set<Clazz> sets;
    private Map<String,Object> maps;

    public Student() {
    }


    //    public Student(List<String> hobbies, Set<Clazz> sets, Map<String, Object> maps) {
//        this.hobbies = hobbies;
//        this.sets = sets;
//        this.maps = maps;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuAge=" + stuAge +
                ", enterenceTime=" + enterenceTime +
                ", clazz=" + clazz +
                ", hobbies=" + hobbies +
                ", sets=" + sets +
                ", maps=" + maps +
                '}';
    }

//    public Student(String stuNum, String stuName, String stuGender, int stuAge, Date enterenceTime, Clazz clazz) {
//        this.stuNum = stuNum;
//        this.stuName = stuName;
//        this.stuGender = stuGender;
//        this.stuAge = stuAge;
//        this.enterenceTime = enterenceTime;
//        this.clazz = clazz;
//    }



    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
   }

   public Set<Clazz> getSets() {
        return sets;
    }

    public void setSets(Set<Clazz> sets) {
        this.sets = sets;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Date getEnterenceTime() {
        return enterenceTime;
    }

    public void setEnterenceTime(Date enterenceTime) {
        this.enterenceTime = enterenceTime;
    }
}
