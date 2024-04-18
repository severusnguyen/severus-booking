package severusnguyen.severusbooking.entity;

import jakarta.persistence.*;

@Entity(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "image")
    private String image;

    @Column(name = "special_dish")
    private boolean specialDish; // Sử dụng kiểu dữ liệu Boolean thay cho boolean

    @ManyToOne
    @JoinColumn(name = "cate_menu_id")
    private MenuCategory cateMenuId;

    // Getter và Setter

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

    public boolean isSpecialDish() {
        return specialDish;
    }

    public void setSpecialDish(boolean specialDish) {
        this.specialDish = specialDish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public MenuCategory getCateMenuId() {
        return cateMenuId;
    }

    public void setCateMenuId(MenuCategory cateMenuId) {
        this.cateMenuId = cateMenuId;
    }
}
