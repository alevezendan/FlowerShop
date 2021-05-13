package builder;

import entity.Flower;
import entity.FlowerShop;


public class Builder {
    FlowerShopBuilder build =new FSBuilder();
    FlowerShopConstruct flowsC=new FlowerShopConstruct(build);
   // flowsC.constructFlowerShop(1,"The Flower Studio");
    FlowerShop fs1=flowsC.getFlowerShop();
    FlowerBuilder tulipBuilder=new FBulider();
    FlowerConstruct flowC=new FlowerConstruct(tulipBuilder);
   // flowC.constructFlower(1,"Tulip","White",12.5,"Yes",25,fs1);
    Flower f1=flowC.getFlower();


}
