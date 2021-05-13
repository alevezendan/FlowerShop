package builder;

import entity.Flower;
import entity.FlowerShop;
import entity.User;

import java.util.List;

public class FSBuilder implements FlowerShopBuilder {

    private FlowerShop flowerShop;
   public FSBuilder(){
        this.flowerShop=new FlowerShop();
    }
    @Override
    public void buildId(int id) {
        flowerShop.setId(id);
    }

    @Override
    public void buildName(String name) {
        flowerShop.setName(name);
    }


    @Override
    public FlowerShop getFlowerShop() {
        return this.flowerShop;
    }
}
