package builder;

import entity.Flower;
import entity.FlowerShop;
import entity.User;

import java.util.List;

public interface FlowerShopBuilder {

    public void buildId(int id);
    public void buildName(String name);
   // public void buildUsers(List<User> users);
  //  public void buildFlowers(List<Flower> flowers);
    public FlowerShop getFlowerShop();
}
