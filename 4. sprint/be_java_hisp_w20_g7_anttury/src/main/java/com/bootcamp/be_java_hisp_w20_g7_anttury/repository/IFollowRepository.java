package com.bootcamp.be_java_hisp_w20_g7_anttury.repository;

import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Follow;

import java.util.List;

public interface IFollowRepository {

    List<Follow> findAll();

    boolean save(Follow follow);

    void deleteByIds(int idFollower, int idFollowed);

}
