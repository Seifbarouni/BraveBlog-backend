package seif.app.braveBlog.Data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import seif.app.braveBlog.Models.Likes;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByUserId(Long userId);

    @Query("SELECT l FROM Likes l WHERE l.postId = ?1 AND l.userId = ?2")
    Likes getLike(Long postId, Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Likes  WHERE postId = ?1 AND userId = ?2")
    void deleteLike(Long postId, Long userId);
}
