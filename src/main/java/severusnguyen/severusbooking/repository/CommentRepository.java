package severusnguyen.severusbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import severusnguyen.severusbooking.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
