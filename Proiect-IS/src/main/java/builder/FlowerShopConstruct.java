package builder;


import entity.FlowerShop;

public class FlowerShopConstruct {

    private FlowerShopBuilder flowerShopBuilder;
    public FlowerShopConstruct(FlowerShopBuilder flowerShopBuilder){
        this.flowerShopBuilder=flowerShopBuilder;
    }
    public FlowerShop getFlowerShop(){
        return this.flowerShopBuilder.getFlowerShop();
    }

   // public void constructFlowerShop(int id, String name, List<User> users, List<Flower> flowers)
   public void constructFlowerShop(int id, String name)
    {
        this.flowerShopBuilder.buildId(id);
        this.flowerShopBuilder.buildName(name);
       // this.flowerShopBuilder.buildUsers(users);
       // this.flowerShopBuilder.buildFlowers(flowers);

    }
}
