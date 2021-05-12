package service;

import model.FlowerShopChain;
import entity.FlowerShop;
import repository.FlowerShopRepo;

import java.util.List;

public class FlowerShopService {

    private FlowerShopChain flowerShopChain;
    private FlowerShopRepo flowerShopRepo;

    public FlowerShopService(){
        this.flowerShopRepo=new FlowerShopRepo();
        this.flowerShopChain=new FlowerShopChain();
    }
    public FlowerShop getFlowerShopByName(String flowerShopName){
        System.out.println(flowerShopName);
        for(FlowerShop f:flowerShopChain.getFlowerShops()){
            System.out.println(f.getName());
            if(f.getName().equals(flowerShopName)){
                return f;
            }
        }
        return null;
    }

    public List<FlowerShop> getFlowerShops(){
       return  flowerShopRepo.showAllFlowerShops();
    }

    public FlowerShopChain getFlowerShopChain() {
        return flowerShopChain;
    }

    public void setFlowerShopChain(FlowerShopChain flowerShopChain) {
        this.flowerShopChain = flowerShopChain;
    }
}
