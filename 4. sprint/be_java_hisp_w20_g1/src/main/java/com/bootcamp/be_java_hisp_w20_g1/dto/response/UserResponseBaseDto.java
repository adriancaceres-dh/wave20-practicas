package com.bootcamp.be_java_hisp_w20_g1.dto.response;


public abstract class UserResponseBaseDto {
    private int userId;
    private String userName;

    public UserResponseBaseDto(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserResponseBaseDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserResponseBaseDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
