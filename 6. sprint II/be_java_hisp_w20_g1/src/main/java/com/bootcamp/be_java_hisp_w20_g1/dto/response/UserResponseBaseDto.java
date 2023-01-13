package com.bootcamp.be_java_hisp_w20_g1.dto.response;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserResponseBaseDto other = (UserResponseBaseDto) obj;
        return userId == other.userId && Objects.equals(userName, other.userName);
    }
    
    
}
