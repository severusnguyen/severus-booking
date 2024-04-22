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
import severusnguyen.severusbooking.service.imp.MenuServiceImp;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuServiceImp menuServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getHomeMenu(){

        ResponseData responseData = new ResponseData();

        responseData.setData(menuServiceImp.getHomeMenu());

        return new ResponseEntity<>(menuServiceImp.getHomeMenu(), HttpStatus.OK);
    }

    @PostMapping("/addMenu")
    public ResponseEntity<?> createMenu(@RequestParam MultipartFile file,
                                        @RequestParam String title,
                                        @RequestParam String subtitle,
                                        @RequestParam String description ,
                                        @RequestParam double price,
                                        @RequestParam boolean special_dish ,
                                        @RequestParam int cate_menu_id){ //upload file

        ResponseData responseData = new ResponseData();
        boolean isSuccess = menuServiceImp.insertMenu(file, title, subtitle, description, price, special_dish, cate_menu_id);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("file/{filename:.+}")
    public ResponseEntity<?> getFileMenu(@PathVariable String filename){ //download file

        Resource resource = fileServiceImp.loadFile(filename);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

}
