package orm.example.springboot.web.dto;

import lombok.Getter;
import orm.example.springboot.domain.posts.Posts;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) { //entity의 일부만 필요하기 때문에 dto는 entity를 받아서 처리
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
