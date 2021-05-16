package service;


import entity.FlowerShop;
import entity.User;
import model.FlowerShopChain;

import model.Users;
import repository.repository.FlowerShopRepo;
import repository.repository.UserRepo;

import java.util.List;

public class FlowerShopService {

    private FlowerShopChain flowerShopChain;
    private FlowerShopRepo flowerShopRepo;
    private UserRepo userRepo;
    private Users users;

    public FlowerShopService(){
        this.flowerShopRepo=new FlowerShopRepo();
        this.flowerShopChain=new FlowerShopChain();
        this.userRepo=new UserRepo();
    }
    public FlowerShop getFlowerShopByName(String flowerShopName){
       // System.out.println(flowerShopName);
        for(FlowerShop f:flowerShopChain.getFlowerShops()){
            System.out.println(f.getName());
            if(f.getName().equals(flowerShopName)){
                System.out.println("FOUND");
                return f;
            }
        }
        return null;
    }

    public FlowerShop getFlowerShopByUsername(String username) {
        // System.out.println(flowerShopName);

        List<User> users=userRepo.showAllUsers();
        for (User u : users) {
            //System.out.println(username+"din FlowerShopService");
            if (u.getUsername().equals(username)) {
               // System.out.println(u.getFlowerShop().getName()+"din findByUsername");
               /* List<FlowerShop> fs=flowerShopRepo.showAllFlowerShops();
                for(FlowerShop fl:fs){
                    if(fl.getId()==u.getFlowerShopId()){
                        return fl;
                    }
                }*/
                return u.getFlowerShop();
            }

        }
        return null;
    }

    public FlowerShop getFlowerShopById(int id){
        List<FlowerShop> fs=flowerShopRepo.showAllFlowerShops();
        for(FlowerShop f:fs){
            if(f.getId()==id){
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
