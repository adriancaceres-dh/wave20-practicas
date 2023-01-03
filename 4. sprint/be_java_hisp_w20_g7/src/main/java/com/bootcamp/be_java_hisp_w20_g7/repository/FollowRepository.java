package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class FollowRepository implements IFollowRepository {

    List<Follow> follows;

    public FollowRepository() {
        follows = new ArrayList<>();
        follows.add(new Follow(1, 3));
        follows.add(new Follow(2, 3));
        follows.add(new Follow(8, 3));
        follows.add(new Follow(4, 3));
        follows.add(new Follow(5, 4));
        follows.add(new Follow(5, 2));
    }

    @Override
    public List<Follow> findAll() {
        return follows;
    }

    @Override
    public boolean save(Follow follow) {
        follows.add(follow);
        return true;
    }

    @Override
    public void deleteByIds(int idFollower, int idFollowed) {

    }
}
