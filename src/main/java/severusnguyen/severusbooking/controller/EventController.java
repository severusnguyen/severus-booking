package severusnguyen.severusbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.payload.ResponseData;
import severusnguyen.severusbooking.service.imp.EventServiceImp;
import severusnguyen.severusbooking.service.imp.FileServiceImp;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventServiceImp eventServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getHomeEvent(){

        ResponseData responseData = new ResponseData();

        responseData.setData(eventServiceImp.getHomeEvent());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/addEvent")
    public ResponseEntity<?> createEvent(@RequestParam MultipartFile file,
                                         @RequestParam String title,
                                         @RequestParam String subtitle,
                                         @RequestParam String description,
                                         @RequestParam double price){

        ResponseData responseData = new ResponseData();

        boolean isSuccess = eventServiceImp.insertEvent(file, title, subtitle, description, price);

        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
