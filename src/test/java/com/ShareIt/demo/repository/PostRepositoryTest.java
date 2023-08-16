package com.ShareIt.demo.repository;

import com.ShareIt.demo.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;


    @Test
    void post() {

        Post post=new Post();
        post.setName("hyoseong");

        Post savedPost = postRepository.save(post);

        Assertions.assertThat(post.getName()).isEqualTo(savedPost.getName());
    }

}