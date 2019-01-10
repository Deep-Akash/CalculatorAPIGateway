package com.calculator.calculatorapigateway.user.service.model;


import java.io.Serializable;
import java.util.LinkedHashMap;


public class User implements Serializable {
    private Long id;
    private String userEmailId;
    private String userName;
    private Double creditBalance;



    public User() {
    }

    public User(Long id, String userEmailId, String userName, Double creditBalance) {
        this.id = id;
        this.userEmailId = userEmailId;
        this.userName = userName;
        this.creditBalance = creditBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Double creditBalance) {
        this.creditBalance = creditBalance;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userEmailId='" + userEmailId + '\'' +
                ", userName='" + userName + '\'' +
                ", creditBalance=" + creditBalance +
                '}';
    }

    public static User buildFromData(Object data) {
        LinkedHashMap<String,Object> map = (LinkedHashMap) data;
        User user = new User();
        user.setId(Long.valueOf((int) map.get("id")));
        user.setUserEmailId((String) map.get("userEmailId"));
        user.setUserName((String) map.get("userName"));
        user.setCreditBalance((Double) map.get("creditBalance"));
        return user;
    }
}
