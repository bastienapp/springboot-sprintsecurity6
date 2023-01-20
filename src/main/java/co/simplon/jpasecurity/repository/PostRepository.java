package co.simplon.jpasecurity.repository;

import co.simplon.jpasecurity.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
