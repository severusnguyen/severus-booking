package severusnguyen.severusbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import severusnguyen.severusbooking.payload.ResponseData;
import severusnguyen.severusbooking.service.imp.MenuServiceImp;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuServiceImp menuServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getHomeMenu(){

        ResponseData responseData = new ResponseData();

        responseData.setData(menuServiceImp.getHomeMenu());

        return new ResponseEntity<>(menuServiceImp.getHomeMenu(), HttpStatus.OK);
    }
}
