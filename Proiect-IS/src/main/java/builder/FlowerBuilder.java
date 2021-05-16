package builder;


import entity.Flower;
import entity.FlowerShop;

import java.util.List;

interface FlowerBuilder {
    public void buildId(int id);
    public void buildName(String name);
    public void buildPrice(double price);
    public void buildColor(String color);
    public void buildAvailability(String avail);
    public void buildQuantity(double quant);
    public void buildFlowerShop(FlowerShop flowerShop);
    public Flower getFlower();
    public List<Flower> getFlowers();

}
