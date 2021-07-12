package seif.app.braveBlog.Services;

import java.util.List;

import seif.app.braveBlog.Models.Post;

public interface IPostsService {
    public List<Post> getAllPosts();

    public Post getPostById(Long id);

    public String addPost(Post post);

    public String deletePost(Long id);

    public List<Post> getPostsByUser(String user);

    public Long getTotalLikes(String user);
}
