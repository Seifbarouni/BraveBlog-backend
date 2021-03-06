package seif.app.braveBlog.Data;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import seif.app.braveBlog.Models.Post;

@Transactional
public interface PostsRepository extends JpaRepository<Post, Long> {
    public Optional<List<Post>> findByUser(String user);

    @Modifying
    @Transactional
    @Query("UPDATE Post SET user=?1 WHERE user = ?2")
    void updatePosts(String newUsername, String oldUsername);
}
