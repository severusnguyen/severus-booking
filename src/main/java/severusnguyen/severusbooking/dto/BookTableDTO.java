package severusnguyen.severusbooking.dto;

import java.util.Date;

public class BookTableDTO {
    private String guestName;
    private String email;
    private String phone;
    private Date dateBook;
    private Date timeBook;
    private int amountOfPeople;
    private String massage;

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateBook() {
        return dateBook;
    }

    public void setDateBook(Date dateBook) {
        this.dateBook = dateBook;
    }

    public Date getTimeBook() {
        return timeBook;
    }

    public void setTimeBook(Date timeBook) {
        this.timeBook = timeBook;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
