package pl.lewandowski.book_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book-service")
public class BookController {

    @Value("${eureka.instance.instance-id}")
    private String id;

    @GetMapping("/hello")
    public String get() {
        return "Hello world! My id: " + id;
    }

    @GetMapping("/get-ebooks")
    public List<Book> getEbooks() {

        List<Book> ebookList = List.of(
                new Book(
                        "Spring Boot LiveBook",
                        "100",
                        "Przemyslaw Bykowski",
                        "https://livebooks.pl/assets/img/livebook-cover.png",
                        ""),
                new Book(
                        "Java Challenges",
                        "200",
                        "Przemyslaw Bykowski",
                        "https://bykowski.pl/wp-content/uploads/2023/12/Java-Challenges-Real-Interview-Edition-Small.png",
                        "")
        );

        return ebookList;
    }
}
