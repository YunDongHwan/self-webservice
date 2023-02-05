package orm.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    //인터페 이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본 적인 CRUD 메소드가 자동으로 생성
}
