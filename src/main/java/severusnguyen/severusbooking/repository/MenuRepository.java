package severusnguyen.severusbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import severusnguyen.severusbooking.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
