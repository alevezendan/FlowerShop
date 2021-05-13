package builder;

import entity.Flower;
import entity.FlowerShop;
import entity.User;

import java.util.List;

public interface FlowerShopP {
    public void setId(int id);
    public void setName(String name);
    public void setUsers(List<User> users);
    public void setFlowers(List<Flower> flowers);

}
