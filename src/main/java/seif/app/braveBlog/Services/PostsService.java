package seif.app.braveBlog.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seif.app.braveBlog.Data.PostsRepository;
import seif.app.braveBlog.Data.SavesRepository;
import seif.app.braveBlog.Models.Post;

@Service
public class PostsService implements IPostsService {
    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private SavesRepository savesRepository;

    @Override
    public List<Post> getAllPosts() {
        List<Post> postsOp = postsRepository.findAll();
        if (postsOp != null)
            return postsOp;
        return new ArrayList<Post>();
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> post = postsRepository.findById(id);
        return post.get();
    }

    @Override
    public List<Post> getPostsByUser(String user) {
        Optional<List<Post>> postsOp = postsRepository.findByUser(user);
        if (postsOp.isPresent())
            return postsOp.get();
        return new ArrayList<Post>();
    }

    @Override
    public String addPost(Post post) {
        post = postsRepository.save(post);
        if (post != null)
            return "Success";
        return "Error";
    }

    @Override
    public Long getTotalLikes(String user) {
        Long res = 0L;
        List<Post> posts = getPostsByUser(user);
        for (Post post : posts) {
            res += post.getLikes();
        }
        return res;
    }

    @Override
    public String deletePost(Long id) {
        postsRepository.deleteById(id);
        savesRepository.deleteSave(id);
        return "Success";
    }

}
