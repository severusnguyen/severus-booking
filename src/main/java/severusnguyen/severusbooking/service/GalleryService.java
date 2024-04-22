package severusnguyen.severusbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.GalleryDTO;
import severusnguyen.severusbooking.entity.Gallery;
import severusnguyen.severusbooking.repository.GalleryRepository;
import severusnguyen.severusbooking.service.imp.FileServiceImp;
import severusnguyen.severusbooking.service.imp.GalleryServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class GalleryService implements GalleryServiceImp {

    @Autowired
    GalleryRepository galleryRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<GalleryDTO> getHomeGallery() {

        List<Gallery> galleryList = galleryRepository.findAll();
        List<GalleryDTO> galleryDTOList = new ArrayList<>();

        for (Gallery gallery : galleryList) {
            GalleryDTO galleryDTO = new GalleryDTO();

            galleryDTO.setImage(gallery.getImage());

            galleryDTOList.add(galleryDTO);
        }

        return galleryDTOList;
    }

    @Override
    public boolean insertGallery(MultipartFile file) {
        boolean isInsertSuccess = false;

        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess){
                Gallery gallery = new Gallery();

                gallery.setImage(file.getOriginalFilename());

                galleryRepository.save(gallery);
            }
            isInsertSuccess = true;
        }catch (Exception e){
            System.out.println("Error insert gallery: " + e.getMessage());
        }
        return isInsertSuccess;
    }
}
