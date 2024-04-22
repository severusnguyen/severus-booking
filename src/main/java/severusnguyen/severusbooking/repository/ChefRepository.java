package severusnguyen.severusbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import severusnguyen.severusbooking.entity.Chef;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Integer> {

}
