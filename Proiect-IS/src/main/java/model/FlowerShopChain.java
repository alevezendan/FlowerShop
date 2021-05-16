package model;




import entity.FlowerShop;

import java.util.List;

public class FlowerShopChain {
    public List<FlowerShop> getFlowerShops() {
        return flowerShops;
    }

    public void setFlowerShops(List<FlowerShop> flowerShops) {
        this.flowerShops = flowerShops;
    }

    private List<FlowerShop> flowerShops;
}
