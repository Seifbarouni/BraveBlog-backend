package seif.app.blaviken.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seif.app.blaviken.Data.PostsRepository;
import seif.app.blaviken.Models.Post;

@Service
public class PostsService implements IPostsService {
    @Autowired
    private PostsRepository postsRepository;

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
    public Post getPostByUser(String user) {
        Optional<Post> post = postsRepository.findByUser(user);
        return post.get();
    }

}
