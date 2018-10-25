package com.taikang.imageservice.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {
    private  Integer userId;
    private  String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
        List<String> a=new ArrayList<String>();
        a.add("q");
        List<String> b=new ArrayList<String>();
        b.add("a");
        b.addAll(a);
        System.out.println(b.size());
        String s="a";
        String[] ss= s.split(",");
        System.out.println(ss.length);
        String s1="a,b";
        String[] ss1= s1.split(",");
        System.out.println(ss1.length);
    }
}
