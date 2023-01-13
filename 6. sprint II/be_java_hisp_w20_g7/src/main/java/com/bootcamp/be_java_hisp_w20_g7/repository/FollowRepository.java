package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class FollowRepository implements IFollowRepository {

    List<Follow> follows;

    public FollowRepository() {
        follows = loadData();
        //follows = new ArrayList<>();
        //follows.add(new Follow(1, 3));
        //follows.add(new Follow(2, 3));
        //follows.add(new Follow(8, 3));
        //follows.add(new Follow(4, 3));
        //follows.add(new Follow(5, 4));
        //follows.add(new Follow(5, 2));
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

    public List<Follow> loadData(){
        List<Follow> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/main/resources/follows.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<Follow>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }
}
