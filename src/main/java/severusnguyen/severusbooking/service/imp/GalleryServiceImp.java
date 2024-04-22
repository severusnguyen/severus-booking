package severusnguyen.severusbooking.service.imp;

import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.GalleryDTO;

import java.util.List;

public interface GalleryServiceImp {
    List<GalleryDTO> getHomeGallery();
    boolean insertGallery(MultipartFile file);
}
