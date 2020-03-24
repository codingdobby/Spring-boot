package com.my.springboot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();

    }

    @Test
    public void 게시글_저장_불러오기(){
        String title = "test";
        String content = "게시글 본문";

        postsRepository.save(Posts.builder().
                title(title)
                .content(content)
                .author("minyeong@naver.com")
                .build()

        );

        List<Posts> postsList = postsRepository.findAll();

        Posts post = postsList.get(0);
        Assertions.assertThat(post.getTitle()).isEqualTo(title);
        Assertions.assertThat(post.getContent()).isEqualTo(content);



    }

}
