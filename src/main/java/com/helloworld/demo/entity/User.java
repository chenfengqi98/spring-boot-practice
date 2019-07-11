package com.helloworld.demo.entity;

public class User {
    private Long userId;
    private String userName;
    private Boolean sex;
    private String createdTime;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean getSex() {
        return sex;
    }

    public String getCreatedTime() {
        return createdTime;
    }
}
