package severusnguyen.severusbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.payload.ResponseData;
import severusnguyen.severusbooking.service.imp.ChefServiceImp;
import severusnguyen.severusbooking.service.imp.FileServiceImp;

@RestController
@RequestMapping("/chef")
public class ChefController {

    @Autowired
    ChefServiceImp chefServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getHomeChef(){

        ResponseData responseData = new ResponseData();
        responseData.setData(chefServiceImp.getHomeChef());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/addChef")
    public ResponseEntity<?> addChef(@RequestParam MultipartFile file,
                                     @RequestParam String name,
                                     @RequestParam String position){

        ResponseData responseData = new ResponseData();
        boolean isSuccess = chefServiceImp.insertChef(file, name, position);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("file/{filename:.+}")
    public ResponseEntity<?> getFileChef(@PathVariable String filename){

        Resource resource = fileServiceImp.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment, filename=\"" + resource.getFilename() + "\"").body(resource);
    }

}
