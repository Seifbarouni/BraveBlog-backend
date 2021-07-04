package seif.app.blaviken.Data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import seif.app.blaviken.Models.Post;

public interface PostsRepository extends JpaRepository<Post, Long> {
    public Optional<List<Post>> findByUser(String user);
}
