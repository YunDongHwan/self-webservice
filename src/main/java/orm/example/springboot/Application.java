package orm.example.springboot;
// @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 class는 항승 프로젝트의 최 상단에 위치 시켜야 합니다.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
