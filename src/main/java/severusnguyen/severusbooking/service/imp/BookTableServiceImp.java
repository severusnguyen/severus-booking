package severusnguyen.severusbooking.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import severusnguyen.severusbooking.dto.BookTableDTO;

import java.util.Date;
import java.util.List;

public interface BookTableServiceImp {
    List<BookTableDTO> getListBookTable();
    boolean bookingTable( String guestName,
                          String email,
                          String phone,
                          String dateBook,
                          String timeBook,
                          int amountOfPeople,
                          String message);

}
