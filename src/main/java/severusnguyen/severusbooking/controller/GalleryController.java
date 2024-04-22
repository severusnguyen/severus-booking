package severusnguyen.severusbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.payload.ResponseData;
import severusnguyen.severusbooking.service.imp.FileServiceImp;
import severusnguyen.severusbooking.service.imp.GalleryServiceImp;

@RestController
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    GalleryServiceImp galleryServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getGallery(){

        ResponseData responseData = new ResponseData();
        responseData.setData(galleryServiceImp.getHomeGallery());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/addGallery")
    public ResponseEntity<?> addGallery(@RequestParam MultipartFile file){

        ResponseData responseData = new ResponseData();
        boolean isSuccess = galleryServiceImp.insertGallery(file);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("file/{filename:.+}")
    public ResponseEntity<?> getFileGallery(@PathVariable String filename){

        Resource resource = fileServiceImp.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment, filename=\"" + resource.getFilename() + "\"").body(resource);
    }

}
