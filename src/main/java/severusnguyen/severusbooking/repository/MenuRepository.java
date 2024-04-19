package severusnguyen.severusbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
