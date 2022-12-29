package com.bootcamp.be_java_hisp_w20_g7.service;

public interface IFollowService {


    /**
     * US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * @param userIdFollower: usuario que va a ser seguidor
     * @param userIdFollowed: usuario que va a ser seguido
     * @return String
     */
    String follow(int userIdFollower, int userIdFollowed);


    /**
     * US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     * @param userIdFollower: usuario que va dejar de ser seguidor
     * @param userIdFollowed: usuario que va a dejar de ser seguido
     * @return String
     */
    String unfollow(int userIdFollower, int userIdFollowed);
}
