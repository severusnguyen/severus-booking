package severusnguyen.severusbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import severusnguyen.severusbooking.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
