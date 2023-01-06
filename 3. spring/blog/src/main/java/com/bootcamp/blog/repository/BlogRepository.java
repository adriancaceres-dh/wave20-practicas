package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogPost;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{

    private List<BlogPost> posts;

    public BlogRepository() {
        posts = new ArrayList<>();
        posts.add(new BlogPost("1","Hoy","Juan",
                LocalDate.of(2022,12,1)));
    }

    public BlogPost addPost(BlogPost blogPost) {
        this.posts.add(blogPost);
        return blogPost;
    }

    public BlogPost findById(String id){
        return posts.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public List<BlogPost> getPosts(){
        return this.posts;
    }
}
