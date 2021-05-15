package entity;

//import lombok.Data;

import builder.FlowerShopP;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
@Table(name = "FlowerShop")
public class FlowerShop implements FlowerShopP {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "flowerShop")
    //@OneToMany(mappedBy = "flowerShopId")
    private List<User> users;

    @OneToMany(mappedBy = "flowerShop")
    private List<Flower> flowers;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public void deleteUser(User u){
        this.users.remove(u);

    }

    public void deleteFlower(Flower flower) {
        this.flowers.remove(flower);
    }
}
