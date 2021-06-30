package seif.app.blaviken.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {
    @GetMapping("/")
    public String getPosts() {
        return "posts";
    }
}
