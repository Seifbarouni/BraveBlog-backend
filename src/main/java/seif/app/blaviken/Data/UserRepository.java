package seif.app.blaviken.Data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import seif.app.blaviken.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
