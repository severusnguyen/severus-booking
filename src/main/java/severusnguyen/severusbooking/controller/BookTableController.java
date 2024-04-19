package severusnguyen.severusbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import severusnguyen.severusbooking.payload.ResponseData;
import severusnguyen.severusbooking.service.imp.BookTableServiceImp;

import java.util.Date;
import java.util.Timer;

@RestController
@RequestMapping("/booktable")
public class BookTableController {

    @Autowired
    BookTableServiceImp bookTableServiceImp;

    @GetMapping("")
    public ResponseEntity<?> getListBookTable(){

        ResponseData responseData = new ResponseData();

        responseData.setData(bookTableServiceImp.getListBookTable());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/bookingtable")
    public ResponseEntity<?> bookingTable(@RequestParam String guestName,
                                          @RequestParam String email,
                                          @RequestParam String phone,
                                          @RequestParam String dateBook,
                                          @RequestParam String timeBook,
                                          @RequestParam int amountOfPeople,
                                          @RequestParam String message){

        ResponseData responseData = new ResponseData();
        boolean isSuccess = bookTableServiceImp.bookingTable(guestName, email, phone, dateBook, timeBook, amountOfPeople, message);
        responseData.setData(isSuccess);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
