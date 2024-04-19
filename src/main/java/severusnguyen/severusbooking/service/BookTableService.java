package severusnguyen.severusbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import severusnguyen.severusbooking.dto.BookTableDTO;
import severusnguyen.severusbooking.entity.BookTable;
import severusnguyen.severusbooking.repository.BookTableRepository;
import severusnguyen.severusbooking.service.imp.BookTableServiceImp;
import severusnguyen.severusbooking.service.imp.FileServiceImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookTableService implements BookTableServiceImp {

    @Autowired
    BookTableRepository bookTableRepository;

    @Override
    public List<BookTableDTO> getListBookTable() {

        List<BookTable> bookTableList = bookTableRepository.findAll();
        List<BookTableDTO> bookTableDTOList = new ArrayList<>();

        for (BookTable bookTable : bookTableList) {
            BookTableDTO bookTableDTO = new BookTableDTO();

            bookTableDTO.setGuestName(bookTable.getGuestName());
            bookTableDTO.setEmail(bookTable.getEmail());
            bookTableDTO.setPhone(bookTable.getPhone());
            bookTableDTO.setDateBook(bookTable.getDateBook());
            bookTableDTO.setTimeBook(bookTable.getTimeBook());
            bookTableDTO.setAmountOfPeople(bookTable.getAmountOfPeople());
            bookTableDTO.setMassage(bookTable.getMessage());

            bookTableDTOList.add(bookTableDTO);
        }
        return bookTableDTOList;
    }

    @Override
    public boolean bookingTable(String guestName, String email, String phone, String dateBook, String timeBook, int amountOfPeople, String message) {

        boolean isInsertSuccess= false;
        try {
            BookTable bookTable = new BookTable();

            bookTable.setGuestName(guestName);
            bookTable.setEmail(email);
            bookTable.setPhone(phone);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date date_Book = simpleDateFormat.parse(dateBook);

            bookTable.setDateBook(date_Book);

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm");
            Date time_Book = simpleDateFormat1.parse(timeBook);
            bookTable.setTimeBook(time_Book);

            bookTable.setAmountOfPeople(amountOfPeople);
            bookTable.setMessage(message);

            bookTableRepository.save(bookTable);
            isInsertSuccess = true;
        }catch (Exception e){
            System.out.println("Error booking table: " + e.getMessage());
        }
        return isInsertSuccess;
    }


}
