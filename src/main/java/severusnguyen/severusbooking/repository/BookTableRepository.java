package severusnguyen.severusbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import severusnguyen.severusbooking.entity.BookTable;

@Repository
public interface BookTableRepository extends JpaRepository<BookTable, Integer> {

}
