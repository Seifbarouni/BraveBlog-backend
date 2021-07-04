package seif.app.blaviken.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seif.app.blaviken.Models.Post;
import seif.app.blaviken.Services.IPostsService;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin
public class PostsController {
    @Autowired
    private IPostsService postsService;

    @GetMapping("")
    public List<Post> getPosts() {
        return postsService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable(name = "id") Long id) {
        return postsService.getPostById(id);
    }

    @GetMapping("/us/{user}")
    public List<Post> getPostsByUser(@PathVariable(name = "user") String user) {
        return postsService.getPostsByUser(user);
    }
}
