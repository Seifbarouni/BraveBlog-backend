package seif.app.blaviken.Services;

import java.util.List;

import seif.app.blaviken.Models.Post;

public interface IPostsService {
    public List<Post> getAllPosts();

    public Post getPostById(Long id);

    // public Post getPostByUser(String user);

    public List<Post> getPostsByUser(String user);
}
