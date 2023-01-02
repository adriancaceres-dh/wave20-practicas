package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

<<<<<<< Updated upstream
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
=======
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.GetFollowersBySellerDto;
>>>>>>> Stashed changes
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;

public interface IUserService extends IService<UserResponseDTO> {

    public FollowersCountDTO getFollowersCount (int id);
    public String addUsers(List<User> users);
    public List<User> getAll();
    User getById(int id);
<<<<<<< Updated upstream
    boolean followUser(int userId, int userIdToFollow);
    void unfollowUser(int userId, int userIdToUnfollow);
=======
    GetFollowersBySellerDto getFollowersBySeller(int userId);
>>>>>>> Stashed changes
}
