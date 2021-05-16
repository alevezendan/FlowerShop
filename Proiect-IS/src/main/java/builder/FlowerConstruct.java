package builder;

import entity.Flower;
import entity.FlowerShop;


import java.util.List;

public class FlowerConstruct {
    private FlowerBuilder flowerBuilder;
    public FlowerConstruct(FlowerBuilder flowerBuilder){
        this.flowerBuilder=flowerBuilder;
    }
    public Flower getFlower(){
            return this.flowerBuilder.getFlower();
    }
    public List<Flower> getFlowers(){return this.flowerBuilder.getFlowers();}
    public void constructFlower(int id, String name, String color, double price, String avail, double quant, FlowerShop fl)
    {
        this.flowerBuilder.buildId(id);
        this.flowerBuilder.buildName(name);
        this.flowerBuilder.buildColor(color);
        this.flowerBuilder.buildPrice(price);
        this.flowerBuilder.buildAvailability(avail);
        this.flowerBuilder.buildQuantity(quant);
        this.flowerBuilder.buildFlowerShop(fl);
    }
}
