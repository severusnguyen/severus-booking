package severusnguyen.severusbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import severusnguyen.severusbooking.dto.GalleryDTO;
import severusnguyen.severusbooking.entity.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer> {

}
