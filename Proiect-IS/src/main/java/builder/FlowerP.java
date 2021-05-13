package builder;

import entity.FlowerShop;

public interface FlowerP {
    public void setId(int id);
    public void setName(String name);
    public void setColor(String color);
    public void setPrice(double price);
    public void setAvailability(String avail);
    public void setQuantity(double quant);
    public void setFlowerShop(FlowerShop flowerShop);
}
