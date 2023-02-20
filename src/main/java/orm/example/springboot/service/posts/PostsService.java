package orm.example.springboot.service.posts;

////선언된 모든 final 필드가 포함된 생성자를 생성해 줍니다
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import orm.example.springboot.domain.posts.Posts;
import orm.example.springboot.domain.posts.PostsRepository;
import orm.example.springboot.web.dto.PostsResponseDto;
import orm.example.springboot.web.dto.PostsSaveRequestDto;
import orm.example.springboot.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        //db에 쿼리를 날리는 부분이 없는이유
        //JPA의 영속성 컨텍스트 때문 -> 엔티티를 영구 저장하는 환경
        //엔티티가 영속성 컨텍스트에 포함되어 있는지 아닌지로 갈림
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        return new PostsResponseDto(entity);
    }
}
