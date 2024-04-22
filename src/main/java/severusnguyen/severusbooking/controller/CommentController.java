package severusnguyen.severusbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.payload.ResponseData;
import severusnguyen.severusbooking.service.imp.CommentServiceImp;
import severusnguyen.severusbooking.service.imp.FileServiceImp;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentServiceImp commentServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getHomeComment(){

        ResponseData responseData = new ResponseData();
        responseData.setData(commentServiceImp.getHomeComment());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestParam MultipartFile file,
                                        @RequestParam String name,
                                        @RequestParam String subject,
                                        @RequestParam String message){
        ResponseData responseData = new ResponseData();
        boolean isSuccess = commentServiceImp.insertComment(file, name,subject, message);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    
}
