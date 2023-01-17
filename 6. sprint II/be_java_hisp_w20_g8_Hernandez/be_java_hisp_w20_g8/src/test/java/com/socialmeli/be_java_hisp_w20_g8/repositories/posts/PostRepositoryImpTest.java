package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test check  the difference between the date when a post is created and the current date
 * @author: Grupo 8
 */

class PostRepositoryImpTest {

    private final PostRepositoryImp postRepository;

    public PostRepositoryImpTest(){
        this.postRepository = new PostRepositoryImp();
    }

    @Test
    @DisplayName("T-0008 -> Check post from two weeks ago are correct")
    void testTwoWeeksDifference(){

        //Arrange
        Set<Integer> listPostId = Set.of(1,2,3,4);
        //Action
        Set<PostDTO> postDTOSet = postRepository.findPostsById(listPostId);
        //Assert
        assertFalse(postDTOSet.stream()
                .anyMatch(p -> p.getDate().isBefore(LocalDate.now().minusWeeks(2))));

    }

}