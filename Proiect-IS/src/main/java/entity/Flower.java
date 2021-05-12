package entity;



//import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
@Table(name = "Flowers")
public class Flower {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="Name")
    private String name;

    @Column(name="Color")
    private String color;

    @Column(name = "Quantity")
    private double quantity;

    @Column(name = "Price")
    private double price;

    @Column(name = "Availability")
    private String availability;

    @ManyToOne
    @JoinColumn(name = "id_flowerShop")
    private FlowerShop flowerShop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public FlowerShop getFlowerShop() {
        return flowerShop;
    }

    public void setFlowerShop(FlowerShop flowerShop) {
        this.flowerShop = flowerShop;
    }
}
