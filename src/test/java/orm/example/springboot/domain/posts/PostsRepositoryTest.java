package orm.example.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After // 1
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_save_find() {
    //given
        String title = "1";
        String content = "테스트 본문";
        String author = "jojoldu@gmail.com";
        postsRepository.save(Posts.builder() // 2
                .title(title)
                .content(content)
                .author(author)
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll(); // 3
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title); // assertj라는 테스트 검증 라이브러리의 검증 메소드
        assertThat(posts.getContent()).isEqualTo(content);
    }
}