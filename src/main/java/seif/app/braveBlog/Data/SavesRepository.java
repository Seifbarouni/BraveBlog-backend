package seif.app.braveBlog.Data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import seif.app.braveBlog.Models.Saves;

public interface SavesRepository extends JpaRepository<Saves, Long> {
    List<Saves> findByUserId(Long userId);

    @Query("SELECT s FROM Saves s WHERE s.postId = ?1 AND s.userId = ?2")
    Saves getSave(Long postId, Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Saves  WHERE postId = ?1 AND userId = ?2")
    void deleteSave(Long postId, Long userId);
}
