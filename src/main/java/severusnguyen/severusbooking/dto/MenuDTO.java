package severusnguyen.severusbooking.dto;

public class MenuDTO {
    private int id;
    private String title;
    private String subtitle;
    private double price;
    private boolean specialDish;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isSpecialDish() {
        return specialDish;
    }

    public void setSpecialDish(boolean specialDish) {
        this.specialDish = specialDish;
    }
}
