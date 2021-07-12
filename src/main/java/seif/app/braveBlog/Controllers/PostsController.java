package seif.app.braveBlog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seif.app.braveBlog.Models.Post;
import seif.app.braveBlog.Services.IPostsService;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = { "https://wonderful-knuth-debaec.netlify.app/",
        "http://localhost:3000" }, exposedHeaders = "**")
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

    @GetMapping("/likes/{user}")
    public String getTotalPostLikes(@PathVariable(name = "user") String user) {
        return postsService.getTotalLikes(user).toString();
    }

    @PostMapping("/addPost")
    public String addPost(@RequestBody Post post) {
        return postsService.addPost(post);
    }
}
