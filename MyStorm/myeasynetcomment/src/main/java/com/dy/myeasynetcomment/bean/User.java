package com.dy.myeasynetcomment.bean;

import java.util.UUID;

public class User {
    /*
	对应数据库表列名
	 */
    public static final String COLUMN_FLAG = "flag", COLUMN_USERNAME = "userName", COLUMN_LOCATION = "location", COLUMN_NICK = "nick";  
  
    private String flag;//用户标识系统随机生成  
    private String userName;//用户名  
    private String location;//用户当前所在位置  
    private String nick;//用户头像资源ID  
  
    /** 
     * 用户实体的构造函数，创建用户插入数据库时使用 
     */  
    public User() {  
        this.flag = UUID.randomUUID().toString();
        this.userName = ClsCons.USER_NAME[(int) (Math.random() * 10)];  
        this.location = ClsCons.DEFAULT_LOCATION[(int) (Math.random() * 5)];  
        this.nick = ClsCons.DEFAULT_NICK_RESID[(int) (Math.random() * 3)];
    }  
  
    /** 
     * 用户实体的构造函数，从数据库获取用户数据并实例化对象时使用 
     * 
     * @param flag     用户标识 
     * @param userName 用户名 
     * @param location 用户地理位置 
     * @param nick     用户头像资源ID 
     */  
    public User(String flag, String userName, String location, String nick) {  
        this.flag = flag;  
        this.userName = userName;  
        this.location = location;  
        this.nick = nick;  
    }  
  
    public String getFlag() {  
        return flag;  
    }  
  
    public void setFlag(String flag) {  
        this.flag = flag;  
    }  
  
    public String getUserName() {  
        return userName;  
    }  
  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
  
    public String getLocation() {  
        return location;  
    }  
  
    public void setLocation(String location) {  
        this.location = location;  
    }  
  
    public String getNick() {  
        return nick;  
    }  
  
    public void setNick(String nick) {  
        this.nick = nick;  
    }  
} 