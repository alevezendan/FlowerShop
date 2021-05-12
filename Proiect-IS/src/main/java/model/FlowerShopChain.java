package model;

import entity.FlowerShop;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FlowerShopChain {
    public ArrayList<FlowerShop> getFlowerShops() {
        return flowerShops;
    }

    public void setFlowerShops(ArrayList<FlowerShop> flowerShops) {
        this.flowerShops = flowerShops;
    }

    private ArrayList<FlowerShop> flowerShops;
}
