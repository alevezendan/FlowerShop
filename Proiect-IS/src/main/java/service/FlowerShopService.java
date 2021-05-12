package service;

import model.FlowerShopChain;
import entity.FlowerShop;

public class FlowerShopService {

    private FlowerShopChain flowerShopChain;
    public FlowerShop getFlowerShopByName(String flowerShopName){
        for(FlowerShop f:flowerShopChain.getFlowerShops()){
            if(f.getName().equals(flowerShopName)){
                return f;
            }
        }
        return null;
    }
}
